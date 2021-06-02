package a.vkube.controller;

import a.vkube.daoimpl.DriverDaoImpl;
import a.vkube.daoimpl.StatusDaoImpl;
import a.vkube.model.Driver;
import a.vkube.model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateWindowController {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DriverDaoImpl driverDao = new DriverDaoImpl(factory);
    StatusDaoImpl statusDao = new StatusDaoImpl(factory);
    ObservableList<Driver> driverObservableList = FXCollections.observableArrayList();
    ObservableList<Status> statusObservableList = FXCollections.observableArrayList();

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textFirstName;

    @FXML
    private DatePicker datePickerBirthday;

    @FXML
    private TextField textAdress;

    @FXML
    private TextField textLicense;

    @FXML
    private ComboBox<Status> comboBoxStatus;

    @FXML
    private Button buttonOk;

    @FXML
    void initialize(){
        driverObservableList.addAll(driverDao.findByAll());
        statusObservableList.addAll(statusDao.findByAll());
        comboBoxStatus.setItems(statusObservableList);
    }

}