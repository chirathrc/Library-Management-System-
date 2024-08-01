package libraryManagementSystem.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import libraryManagementSystem.dao.entity.genderEntity;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;
import libraryManagementSystem.service.ItemAddService;
import libraryManagementSystem.service.ReaderCRUDService;

public class RegisterReadersController implements Initializable {

    @FXML
    private JFXComboBox<genderEntity> redaerRegitserGender;

    @FXML
    private TextField txtReaderRegisterLastName;

    @FXML
    private TextField txtReaderRegisterNIC;

    @FXML
    private DatePicker txtReaderregisterBirthday;

    @FXML
    private TextField txtReaderregisterFirstName;

    @FXML
    void btnReaderRegister(ActionEvent event) {

        String ReaderFirstname = txtReaderregisterFirstName.getText();
        String ReaderLastname = txtReaderRegisterLastName.getText();
        String ReaderNIC = txtReaderRegisterNIC.getText();
        String ReaderBirthday = String.valueOf(txtReaderregisterBirthday.getValue());
        genderEntity genderEntity = redaerRegitserGender.getValue();

        LocalDateTime currenDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currenDateTime.format(formatter);

        if (ReaderFirstname.isEmpty() || ReaderLastname.isEmpty() || ReaderNIC.isEmpty() || ReaderBirthday.isEmpty()
                || genderEntity == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Fill All the Details");
            alert.show();

        } else {

            String genderId = genderEntity.getGenderId();

            try {

                ReaderInsertDetailsDTO reader = new ReaderInsertDetailsDTO(ReaderFirstname,
                        ReaderLastname, ReaderNIC, ReaderBirthday, genderId, formattedDateTime, 1);

                if (new ReaderCRUDService().readerInsert(reader)) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Register Successfull");
                    alert.show();

                    txtReaderregisterFirstName.setText("");
                    txtReaderRegisterLastName.setText("");
                    txtReaderRegisterNIC.setText("");
                    txtReaderregisterBirthday.setValue(null);
                    addGenders();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Something Went Wrong");
                    alert.show();
                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            addGenders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGenders() throws Exception {
        ItemAddService addService = new ItemAddService();
        List<genderEntity> genders = addService.getAllGenders();
        // System.out.println(category);
        redaerRegitserGender.setItems(FXCollections.observableArrayList(genders));
    }

}
