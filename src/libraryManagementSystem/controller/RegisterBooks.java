package libraryManagementSystem.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import libraryManagementSystem.dao.entity.bookCategoriesEntitiy;
import libraryManagementSystem.dto.BookInsertDetailsDTO;
import libraryManagementSystem.service.ItemAddService;
import libraryManagementSystem.service.bookCRUDService;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterBooks implements Initializable {

    @FXML
    private JFXComboBox<bookCategoriesEntitiy> selectBookCategoryInsert;

    @FXML
    private TextField txtBookAuthorInsert;

    @FXML
    private JFXTextArea txtBookDescriptionInsert;

    @FXML
    private TextField txtBookNameInsert;

    @FXML
    void btnRegisterBookFinal(ActionEvent event) {

        String bookName = txtBookNameInsert.getText();
        String author = txtBookAuthorInsert.getText();
        String descBook = txtBookDescriptionInsert.getText();
        bookCategoriesEntitiy selectBookCategory = selectBookCategoryInsert.getValue();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        if (bookName.isEmpty() || author.isEmpty() || descBook.isEmpty() || selectBookCategory == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill All Deatils");
            alert.show();

        } else {

            try {
                bookCRUDService bookCRUDService = new bookCRUDService();
                String categoryIdSelected = selectBookCategory.getCatId();

                if (bookCRUDService.bookInsert(
                        new BookInsertDetailsDTO(bookName, author, descBook, categoryIdSelected, formattedDateTime))) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Register Suucessfull");
                    alert.show();

                    txtBookAuthorInsert.setText("");
                    txtBookNameInsert.setText("");
                    txtBookDescriptionInsert.setText("");
                    addCategory();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Something Went Wrong");
                    alert.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCategory() throws Exception {
        ItemAddService addService = new ItemAddService();
        List<bookCategoriesEntitiy> category = addService.getAllBookCategories();
        // System.out.println(category);
        selectBookCategoryInsert.setItems(FXCollections.observableArrayList(category));
    }
}
