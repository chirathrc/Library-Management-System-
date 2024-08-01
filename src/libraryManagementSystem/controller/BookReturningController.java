package libraryManagementSystem.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import libraryManagementSystem.dao.entity.ReturnBookEntity;
import libraryManagementSystem.service.ReturnBookService;
import libraryManagementSystem.tm.ReturnTM;

public class BookReturningController implements Initializable {

    ReturnBookService ReturnService;
    ObservableList<ReturnTM> list;
    ReturnTM selectTm;

    List<ReturnBookEntity> bookList;

    @FXML
    private TableColumn<ReturnTM, String> colBookAuthor;

    @FXML
    private TableColumn<ReturnTM, String> colBookID;

    @FXML
    private TableColumn<ReturnTM, String> colBookName;

    @FXML
    private TableColumn<ReturnTM, String> colIssuingdate;

    @FXML
    private TableColumn<ReturnTM, Double> colLatePanletyFee;

    @FXML
    private TableColumn<ReturnTM, String> colReturnDate;

    @FXML
    private TableColumn<ReturnTM, String> colReturnId;

    @FXML
    private Label labelTotalPanelty;

    @FXML
    private TableView<ReturnTM> tblReturn;

    @FXML
    private TextField txtIReturnSearchNIC;

    @FXML
    private TextField txtPayingPanlety;

    @FXML
    private TextField txtReaderBirthday;

    @FXML
    private TextField txtReaderNIC;

    @FXML
    private Label labelBookId;

    @FXML
    private TextField txtReaderName;

    @FXML
    void btnReaderSearchButton(ActionEvent event) {

        callReturnBooks();

    }

    public void callReturnBooks() {

        String serachNIC = txtIReturnSearchNIC.getText();

        if (!serachNIC.isEmpty()) {

            try {

                AddReturnBooksData(ReturnService.ReturnBooks(serachNIC));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Empty NIC");
            alert.show();
            clerTable();

        }

    }

    public void clerTable() {

        ObservableList<ReturnTM> Clearist = FXCollections.observableArrayList();
        tblReturn.setItems(Clearist);

    }

    public void AddReturnBooksData(List<ReturnBookEntity> l) {

        bookList = l;

        list = FXCollections.observableArrayList();

        double totalPenalty = 0;

        if (bookList == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No Anny Book Records");
            alert.show();
            clerTable();

            txtIReturnSearchNIC.setText("");
            txtPayingPanlety.setText("");
            txtReaderBirthday.setText("");
            txtReaderNIC.setText("");
            txtReaderName.setText("");

            labelBookId.setText("Book ID");

        } else {

            for (ReturnBookEntity rt : bookList) {

                list.add(new ReturnTM(rt.getBookID(), rt.getBookName(), rt.getBookAuthor(), rt.getIssuingDate(),
                        rt.getReturnDate(), rt.getLatePanlety(), rt.getIssuingId()));

                txtReaderNIC.setText(rt.getNIC());
                txtReaderName.setText(rt.getReaderName());
                txtReaderBirthday.setText(rt.getBirthday());

                if (rt.getLatePanlety() != null && !String.valueOf(rt.getLatePanlety()).isEmpty()) {
                    totalPenalty += rt.getLatePanlety();
                }
            }

            tblReturn.setItems(list);
            labelTotalPanelty.setText(String.valueOf(totalPenalty));

        }

    }

    @FXML
    void btnReturnBook(ActionEvent event) {

        String paymentTextFiledValue = txtPayingPanlety.getText();
        String readerNIC = txtReaderNIC.getText();

        ReturnBookEntity FinalreturnBookEntity = null;

        if (selectTm != null && !paymentTextFiledValue.isEmpty() && !readerNIC.isEmpty()) {

            for (ReturnBookEntity bE : bookList) {

                if (selectTm.getBookID().equals(bE.getBookID()) && selectTm.getIssuingId().equals(bE.getIssuingId())) {

                    FinalreturnBookEntity = bE;

                }

            }

        }

        try {
            if (ReturnService.ReturnBookFinal(FinalreturnBookEntity, readerNIC)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Success Returned");
                alert.showAndWait();
                callReturnBooks();

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Something Went Wrong");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }

    }

    @FXML
    void clickgGetBook(MouseEvent event) {

        if (event.getClickCount() == 2) {

            selectTm = tblReturn.getSelectionModel().getSelectedItem();

            if (selectTm != null) {

                labelBookId.setText(selectTm.getBookID());

                if (selectTm.getLatePanelty() != null) {

                    txtPayingPanlety.setText(String.valueOf(selectTm.getLatePanelty()));

                } else {

                    txtPayingPanlety.setText("0.0");

                }

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            ReturnService = new ReturnBookService();

        } catch (Exception e) {
            e.printStackTrace();
        }

        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("BookAutor"));
        colIssuingdate.setCellValueFactory(new PropertyValueFactory<>("IssuingDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("dueReturnDate"));
        colLatePanletyFee.setCellValueFactory(new PropertyValueFactory<>("LatePanelty"));
        colReturnId.setCellValueFactory(new PropertyValueFactory<>("IssuingId"));

    }

}
