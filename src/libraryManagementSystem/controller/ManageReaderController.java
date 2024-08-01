package libraryManagementSystem.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;
import libraryManagementSystem.service.ReaderCRUDService;
import libraryManagementSystem.tm.ReaderTableModel;

public class ManageReaderController implements Initializable {

    List<ReaderEntity> readers;

    @FXML
    private JFXToggleButton statusToogleButton;

    @FXML
    private TableColumn<ReaderTableModel, String> tabelReaderBirthday;

    @FXML
    private TableColumn<ReaderTableModel, String> tableReaderGender;

    @FXML
    private TableColumn<ReaderTableModel, String> tableReaderNIC;

    @FXML
    private TableColumn<ReaderTableModel, String> tableReaderName;

    @FXML
    private TableColumn<ReaderTableModel, Integer> tableReaderStatus;

    @FXML
    private TableView<ReaderTableModel> tableReaderTable;

    @FXML
    private TableColumn<ReaderTableModel, String> tableReaderregTime;

    @FXML
    private TableColumn<ReaderTableModel, String> tbaleReaderId;

    @FXML
    private TextField txtReaderBirthday;

    @FXML
    private TextField txtReaderFn;

    @FXML
    private TextField txtReaderGender;

    @FXML
    private TextField txtReaderLn;

    @FXML
    private TextField txtReaderNIC;

    @FXML
    private TextField txtReaderRegistereddate;

    @FXML
    private TextField txtUserSearch;

    @FXML
    void btnRegisterNewReader(ActionEvent event) {

        try {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            Stage ManageBooks = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/libraryManagementSystem/view/registerReader.fxml"));
            ManageBooks.setTitle("Manage Books");
            ManageBooks.setScene(new Scene(root));
            ManageBooks.show();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void btnUpdateRegisterUser(ActionEvent event) {

        String fName = txtReaderFn.getText();
        String lName = txtReaderLn.getText();
        String nic = txtReaderNIC.getText();
        int status;

        if (nic.isEmpty()) {

            Alert ar = new Alert(Alert.AlertType.WARNING);
            ar.setContentText("Select Reader First");
            ar.show();

        } else {

            if (statusToogleButton.isSelected()) {

                status = 1;

            } else {

                status = 2;

            }

            try {

                if (new ReaderCRUDService()
                        .ReaderUpdate(new ReaderInsertDetailsDTO(fName, lName, nic, null, null, null, status))) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("User (" + nic + ") Update SuccessFully");
                    alert.show();
                    loadUsers();

                    txtReaderBirthday.setText("");
                    txtReaderGender.setText("");
                    txtReaderFn.setText("");
                    txtReaderLn.setText("");
                    txtReaderNIC.setText("");
                    txtReaderRegistereddate.setText("");

                } else {

                    Alert ar = new Alert(Alert.AlertType.ERROR);
                    ar.setContentText("Unknow Error Occured");
                    ar.show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void txtUserSerachQuick(KeyEvent event) {

        try {

            readers = new ReaderCRUDService().SelectReaders(txtUserSearch.getText());

            ObservableList<ReaderTableModel> readerTM = FXCollections.observableArrayList();

            for (ReaderEntity rn : readers) {
                ReaderTableModel readerTableModel = new ReaderTableModel(
                        rn.getReaderFname() + " " + rn.getReaderLname(),
                        rn.getId(),
                        rn.getReaderNic(),
                        rn.getReaderGender(),
                        rn.getReaderBirthday(),
                        rn.getReaderRegisterTime(),
                        rn.getReaderStatus());

                readerTM.add(readerTableModel);
            }

            tableReaderTable.setItems(readerTM);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void loadUsers() {

        try {
            readers = new ReaderCRUDService().AllReaders(); // object

            ObservableList<ReaderTableModel> readerTM = FXCollections.observableArrayList();

            for (ReaderEntity rn : readers) {
                ReaderTableModel readerTableModel = new ReaderTableModel(
                        rn.getReaderFname() + " " + rn.getReaderLname(),
                        rn.getId(),
                        rn.getReaderNic(),
                        rn.getReaderGender(),
                        rn.getReaderBirthday(),
                        rn.getReaderRegisterTime(),
                        rn.getReaderStatus());

                readerTM.add(readerTableModel);
            }

            tableReaderTable.setItems(readerTM);

            // System.out.println(readerTM);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void mouseClickedReaderTable(MouseEvent event) {

        if (event.getClickCount() == 2) {
            ReaderTableModel selectedReader = tableReaderTable.getSelectionModel().getSelectedItem();

            if (selectedReader != null) {

                String id = selectedReader.getReaderId();

                for (ReaderEntity reader : readers) {

                    if (reader.getId() == id) {

                        txtReaderFn.setText(reader.getReaderFname());
                        txtReaderLn.setText(reader.getReaderLname());
                        txtReaderBirthday.setText(reader.getReaderBirthday());
                        txtReaderNIC.setText(reader.getReaderNic());
                        txtReaderRegistereddate.setText(reader.getReaderRegisterTime());
                        txtReaderGender.setText(reader.getReaderGender());

                        if (reader.getReaderStatus() == 1) {

                            statusToogleButton.setSelected(true);
                            statusToogleButton.setText("Active");

                        } else if (reader.getReaderStatus() == 2) {

                            statusToogleButton.setSelected(false);
                            statusToogleButton.setText("Inactive");

                        }

                    }

                }

            }

        }

    }

    @FXML
    void btnDeleteRegisterUser(ActionEvent event) {

        String nic = txtReaderNIC.getText();

        if (nic.isEmpty()) {

            Alert ar = new Alert(Alert.AlertType.WARNING);
            ar.setContentText("Select Reader First");
            ar.show();

        } else {

            try {

                if (new ReaderCRUDService()
                        .DeleteReader(new ReaderInsertDetailsDTO(null, null, nic, null, null, null, 0))) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("User (" + nic + ") Delete SuccessFully");
                    alert.show();
                    loadUsers();

                    txtReaderBirthday.setText("");
                    txtReaderGender.setText("");
                    txtReaderFn.setText("");
                    txtReaderLn.setText("");
                    txtReaderNIC.setText("");
                    txtReaderRegistereddate.setText("");

                } else {

                    Alert ar = new Alert(Alert.AlertType.ERROR);
                    ar.setContentText("Unknow Error Occured");
                    ar.show();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadUsers();

        tableReaderName.setCellValueFactory(new PropertyValueFactory<>("readerName"));
        tableReaderNIC.setCellValueFactory(new PropertyValueFactory<>("readerNIC"));
        tableReaderGender.setCellValueFactory(new PropertyValueFactory<>("readerGender"));
        tableReaderStatus.setCellValueFactory(new PropertyValueFactory<>("readerStatus"));
        tableReaderregTime.setCellValueFactory(new PropertyValueFactory<>("readerRegTime"));
        tabelReaderBirthday.setCellValueFactory(new PropertyValueFactory<>("readerBirthday"));
        tbaleReaderId.setCellValueFactory(new PropertyValueFactory<>("readerId"));
    }

}
