package libraryManagementSystem.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXToggleButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dto.BookInsertDetailsDTO;
import libraryManagementSystem.service.bookCRUDService;
import libraryManagementSystem.tm.BookTM;

public class ManageBooksController implements Initializable {

    List<BookEntity> lt;

    @FXML
    private JFXToggleButton statusIdBook;

    @FXML
    private TableView<BookTM> tableBookTable;

    @FXML
    private TableColumn<BookTM, String> tblBookAuthor;

    @FXML
    private TableColumn<BookTM, String> tblBookAvailabilityStatus;

    @FXML
    private TableColumn<BookTM, String> tblBookId;

    @FXML
    private TableColumn<BookTM, String> tblBookName;

    @FXML
    private TextField txtBookRegTime;

    @FXML
    private TextField txtManageBookAuthor;

    @FXML
    private TextField txtManageBookCategory;

    @FXML
    private TextField txtManageBookID;

    @FXML
    private TextField txtManageBookName;

    @FXML
    private JFXTextArea txtManageBookdesc;

    @FXML
    private TextField txtSearchBookData;

    @FXML
    void btnRegisterNewBook(ActionEvent event) {

        try {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            Stage registerBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/registerBook.fxml"));
            registerBooks.setTitle("Register Book");
            registerBooks.setScene(new Scene(root));
            registerBooks.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnSerachBookFromData(ActionEvent event) {

    }

    @FXML
    void btnUpdateBook(ActionEvent event) {

        String id = txtManageBookID.getText();

        if (id.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Select Book First");
            alert.show();

        } else {

            int status = 2;

            if (statusIdBook.isSelected()) {

                status = 1;

            }

            String desc = txtManageBookdesc.getText();
            String bookname = txtManageBookName.getText();

            try {

                if (new bookCRUDService()
                        .UpdateBook(new BookInsertDetailsDTO(id, String.valueOf(status), bookname, desc))) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Update Succesfully");
                    alert.show();
                    getBooks();

                    txtBookRegTime.setText("");
                    txtManageBookName.setText("");
                    txtManageBookAuthor.setText("");
                    txtManageBookdesc.setText("");
                    txtManageBookID.setText("");
                    txtManageBookCategory.setText("");

                    statusIdBook.setText("Status");
                    statusIdBook.setSelected(false);

                } else {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Something Went Wrong");
                    alert.show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void btnDeleteBook(ActionEvent event) {

        String id = txtManageBookID.getText();

        if (!id.isEmpty()) {

            try {

                int Intid = Integer.parseInt(id);

                if (new bookCRUDService().DeleteBook(Intid)) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("BookDelete Succesfull");
                    alert.show();

                    txtBookRegTime.setText("");
                    txtManageBookName.setText("");
                    txtManageBookAuthor.setText("");
                    txtManageBookdesc.setText("");
                    txtManageBookID.setText("");
                    txtManageBookCategory.setText("");

                    statusIdBook.setText("Status");
                    statusIdBook.setSelected(false);

                    getBooks();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Unknown eroor Occured");
                    alert.show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select Book First");
            alert.show();

        }

    }

    public void getBooks() {

        try {

            lt = new bookCRUDService().LoadAllBooks();

            ObservableList<BookTM> bookTm = FXCollections.observableArrayList();

            for (BookEntity l : lt) {

                bookTm.add(new BookTM(l.getBookId(), l.getBookName(), l.getAuthorName(), l.getAvailabiltyAsName()));

            }

            tableBookTable.setItems(bookTm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void getSelectedBook(MouseEvent event) {

        if (event.getClickCount() == 2) {

            BookTM selectTm = tableBookTable.getSelectionModel().getSelectedItem();

            if (selectTm != null) {

                String id = selectTm.getBookID();

                for (BookEntity bt : lt) {

                    if (bt.getBookId() == id) {

                        txtBookRegTime.setText(bt.getRegisterDateTime());
                        txtManageBookName.setText(bt.getBookName());
                        txtManageBookAuthor.setText(bt.getAuthorName());
                        txtManageBookdesc.setText(bt.getDescription());
                        txtManageBookID.setText(bt.getBookId());
                        txtManageBookCategory.setText(bt.getCategoryAsName());

                        if (bt.getBookStatusID() == 1) {

                            statusIdBook.setSelected(true);
                            statusIdBook.setText("Active");
                        } else {

                            statusIdBook.setSelected(false);
                            statusIdBook.setText("Decative");
                        }

                    }

                }

            }

        }

    }

    @FXML
    void bookSearchText(KeyEvent event) {

        String serach = txtSearchBookData.getText();

        try {

            lt = new bookCRUDService().LoadSearchAllBooks(serach);

            ObservableList<BookTM> bookTm = FXCollections.observableArrayList();

            for (BookEntity l : lt) {

                bookTm.add(new BookTM(l.getBookId(), l.getBookName(), l.getAuthorName(), l.getAvailabiltyAsName()));

            }

            tableBookTable.setItems(bookTm);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getBooks();

        tblBookId.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        tblBookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tblBookAuthor.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        tblBookAvailabilityStatus.setCellValueFactory(new PropertyValueFactory<>("bookAvilability"));

    }

}
