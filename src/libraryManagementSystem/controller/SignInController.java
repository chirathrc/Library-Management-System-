package libraryManagementSystem.controller;

import static libraryManagementSystem.service.AdminService.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManagementSystem.service.AdminService;

public class SignInController {

    private AdminService adminService;

    public SignInController() {

        adminService = new AdminService();

    }

    @FXML
    private PasswordField txtUserPassword;

    @FXML
    private TextField txtUserUserName;

    @FXML
    void btnSignIn(ActionEvent event) {

        String userName = txtUserUserName.getText();
        String password = txtUserPassword.getText();

        if (userName.isEmpty() || password.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username or Password is Empty");
            alert.show();
        } else {

            if (adminService.signIn(userName, password)) {

                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/libraryManagementSystem/view/test.fxml"));

                    Parent root = loader.load();

                    DashboardController dashboardController = loader.getController();
                    dashboardController.setAdminDetails(admin.getfName() + " " + admin.getlName(), admin.getUserName());

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();

                    Stage dashboard = new Stage();
                    dashboard.setTitle("Dashboard");
                    dashboard.setScene(new Scene(root));
                    dashboard.show();

                    // Stage currentStage = (Stage) ((Window)
                    // event.getSource()).getScene().getWindow();
                    // currentStage.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid Username or Password");
                alert.show();

            }

        }

    }

}
