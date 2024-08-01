package libraryManagementSystem.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Node;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dto.BookBorrowingConfirmDTO;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;
import libraryManagementSystem.service.BookIssuingService;
import libraryManagementSystem.tm.IssuingBookTM;

public class IssuingBookController implements Initializable {

    BookIssuingService bookIssuingService;
    ReaderEntity readerEntity;
    BookEntity Book1;
    BookEntity Book2;
    BookEntity Book3;
    ObservableList<IssuingBookTM> ITM;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            bookIssuingService = new BookIssuingService();

        } catch (Exception e) {

            e.printStackTrace();
        }

        ITM = FXCollections.observableArrayList();

        IssuingBookIdColumn.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        issuingBookTittleColumn.setCellValueFactory(new PropertyValueFactory<>("nameBook"));
        issuingBookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("authorBook"));

    }

    @FXML
    private TableColumn<IssuingBookTM, String> IssuingBookIdColumn;

    @FXML
    private TextField dateReturningDate;

    @FXML
    private TableColumn<IssuingBookTM, String> issuingBookAuthorColumn;

    @FXML
    private TableColumn<IssuingBookTM, String> issuingBookTittleColumn;

    @FXML
    private TableView<IssuingBookTM> issuingTable;

    @FXML
    private TextField txtBook1;

    @FXML
    private TextField txtBook2;

    @FXML
    private TextField txtBook3;

    @FXML
    private TextField txtIssuingSearchNIC;

    @FXML
    private TextField txtReaderBirthday;

    @FXML
    private TextField txtReaderNIC;

    @FXML
    private TextField txtReaderName;

    @FXML
    void btnBook1(ActionEvent event) {

        String B1 = txtBook1.getText();

        if (Book1 != null) {
            // Use an iterator to safely remove items while iterating
            java.util.Iterator<IssuingBookTM> iterator = ITM.iterator();
            while (iterator.hasNext()) {
                IssuingBookTM issuingBookTM = iterator.next();
                if (Book1.getBookId().equals(issuingBookTM.getIdBook())) {
                    iterator.remove();
                }
            }
        }

        try {
            Book1 = bookIssuingService.giveSelectBook(B1);

            if (Book1 != null) {

                ITM.add(new IssuingBookTM(Book1.getBookId(), Book1.getBookName(), Book1.getAuthorName()));
                issuingTable.setItems(ITM);

                System.out.println(ITM.size());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid Book ID");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnBook2(ActionEvent event) {

        String B2 = txtBook2.getText();

        if (Book2 != null) {
            // Use an iterator to safely remove items while iterating
            java.util.Iterator<IssuingBookTM> iterator = ITM.iterator();
            while (iterator.hasNext()) {
                IssuingBookTM issuingBookTM = iterator.next();
                if (Book2.getBookId().equals(issuingBookTM.getIdBook())) {
                    iterator.remove();
                }
            }
        }

        try {

            Book2 = bookIssuingService.giveSelectBook(B2);

            if (Book2 != null) {

                if (Book1 != null) {

                    if ((Book1 != null && Book1.getBookId().equals(Book2.getBookId())) ||
                            (Book3 != null && Book3.getBookId().equals(Book2.getBookId()))) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("Duplicate Entry");
                        alert.show();
                        Book2 = null;
                        txtBook2.setText("");
                    } else {
                        // Add the new book to the list
                        ITM.add(new IssuingBookTM(Book2.getBookId(), Book2.getBookName(),
                                Book2.getAuthorName()));

                        issuingTable.setItems(ITM);

                        System.out.println(ITM.size());
                    }

                }

            } else if (Book2 == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid Book ID");
                alert.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnBook3(ActionEvent event) {

        String B3 = txtBook3.getText();

        if (Book3 != null) {
            // Use an iterator to safely remove items while iterating
            java.util.Iterator<IssuingBookTM> iterator = ITM.iterator();
            while (iterator.hasNext()) {
                IssuingBookTM issuingBookTM = iterator.next();
                if (Book3.getBookId().equals(issuingBookTM.getIdBook())) {
                    iterator.remove();
                }
            }
        }

        try {

            Book3 = bookIssuingService.giveSelectBook(B3);

            if (Book3 != null) {

                if ((Book1 != null && Book1.getBookId().equals(Book3.getBookId())) ||
                        (Book2 != null && Book2.getBookId().equals(Book3.getBookId()))) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Duplicate Entry");
                    alert.show();
                    Book3 = null;
                    txtBook3.setText("");
                } else {
                    // Add the new book to the list
                    ITM.add(new IssuingBookTM(Book3.getBookId(), Book3.getBookName(),
                            Book3.getAuthorName()));

                    issuingTable.setItems(ITM);

                    System.out.println(ITM.size());
                }

            } else if (Book3 == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid Book ID");
                alert.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnConfirmButton(ActionEvent event) {

        String nic = txtReaderNIC.getText();

        if (!nic.isEmpty()) {

            ReaderInsertDetailsDTO detailsDTO = new ReaderInsertDetailsDTO();
            detailsDTO.setReaderNic(readerEntity.getReaderNic());
            detailsDTO.setReaderFname(readerEntity.getReaderFname());
            detailsDTO.setReaderLname(readerEntity.getReaderLname());

            List<BookEntity> BookList = new ArrayList<>();

            for (IssuingBookTM b : ITM) {

                BookEntity bookEntity = new BookEntity();
                bookEntity.setBookId(b.getIdBook());
                bookEntity.setBookName(b.getNameBook());

                BookList.add(bookEntity);
            }

            try {

                BookBorrowingConfirmDTO bookBorrowingConfirmDTO = bookIssuingService.IssuingBookFinal(nic, BookList,
                        detailsDTO);

                if (bookBorrowingConfirmDTO.isConfirmation()) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("You ReturnDate Is : " + bookBorrowingConfirmDTO.getReturndate());

                    alert.showAndWait(); //
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                } else {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Something Went Wrong");
                    alert.show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Invalid User");
            alert.show();

        }

    }

    @FXML
    void btnReaderSearchButton(ActionEvent event) {

        String raeder = txtIssuingSearchNIC.getText();

        try {

            readerEntity = bookIssuingService.giveSearchReader(raeder);

            if (readerEntity != null) {

                txtReaderName.setText(readerEntity.getReaderFname() + " " + readerEntity.getReaderLname());
                txtReaderBirthday.setText(readerEntity.getReaderBirthday());
                txtReaderNIC.setText(readerEntity.getReaderNic());

                System.out.println(readerEntity.getReaderNic());

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Invalid NIC");
                alert.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
