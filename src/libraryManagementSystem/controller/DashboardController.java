package libraryManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private Label txtAdminName;

    @FXML
    private Label txtUsernameAdmin;

    @FXML
    void btnManageBookIssuing(ActionEvent event) {


        try {

            Stage ManageBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/BookIssuing.fxml"));
            ManageBooks.setTitle("Issuing Books");
            ManageBooks.setScene(new Scene(root));
            ManageBooks.show();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnManageBookReturning(ActionEvent event) {

        try {

            Stage ManageBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/BookReturning.fxml"));
            ManageBooks.setTitle("Issuing Books");
            ManageBooks.setScene(new Scene(root));
            ManageBooks.show();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnManageBooks(ActionEvent event) {

        try {

            Stage ManageBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/ManageBooks.fxml"));
            ManageBooks.setTitle("Manage Books");
            ManageBooks.setScene(new Scene(root));
            ManageBooks.show();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnManageReaders(ActionEvent event) {
        
        try {

            Stage ManageBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/ManageReaders.fxml"));
            ManageBooks.setTitle("Manage Books");
            ManageBooks.setScene(new Scene(root));
            ManageBooks.show();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void setAdminDetails(String adminName, String username) {
        txtAdminName.setText(adminName);
        txtUsernameAdmin.setText(username);

    }

}
