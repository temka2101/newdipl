package a.vkube.controller;

import a.vkube.daoimpl.DriverDaoImpl;
import a.vkube.model.Driver;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.time.LocalDate;

public class MainWindowController {

    ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    private TableView<Driver> mainTable;

    @FXML
    private TableColumn<Driver, Integer> columnID;

    @FXML
    private TableColumn<Driver, String> columnLastName;

    @FXML
    private TableColumn<Driver, String> columnFirstName;

    @FXML
    private TableColumn<Driver, String> columnLicense;

    @FXML
    private TableColumn<Driver, String> columnStatus;

    @FXML
    private Button fxCreate;

    @FXML
    private Button fxDelete;

    @FXML
    private Button fxUpdate;

    @FXML
    void initialize(){
        initData();

        mainTable.setItems(observableList);

        columnID.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDriverID()));
        columnLastName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getLastName()));
        columnFirstName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getFirstName()));
        columnLicense.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDriverLicense().getNumber()));
        columnStatus.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getStatus().getName()));
    }
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    @FXML
    void initData(){
        DriverDaoImpl driverDao = new DriverDaoImpl(factory);
        observableList.addAll(driverDao.findByAll());
    }
    @FXML
    void onActionCreate(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/createWindow.fxml"));
        stage.setTitle("Добавление");
        stage.setScene(new Scene(root));
        stage.show();
    }
}