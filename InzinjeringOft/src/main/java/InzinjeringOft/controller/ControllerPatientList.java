package InzinjeringOft.controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import InzinjeringOft.model.Patient;
import InzinjeringOft.repository.PatientRep;
import InzinjeringOft.view.Dialogs.PatientEditorD;

public class ControllerPatientList implements ListChangeListener<Patient> {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public TableView<Patient> tblPatients;
    @Autowired
    private PatientRep repository;

    final ObservableList<Patient> patients;

    private TableColumn firstNameCol;
    private TableColumn lastNameCol;
    private TableColumn dateOfBirthCol;

    public ControllerPatientList() {
		repository = new PatientRep();
        patients = FXCollections.observableArrayList();
        //patients.addAll(repository.findAll());
        patients.addListener(this);
    }

    public void initialize() {
        setupColumns();

        tblPatients.setItems(patients);
    }

    private void setupColumns() {
        firstNameCol = tblPatients.getColumns().get(0);
        lastNameCol = tblPatients.getColumns().get(1);
        dateOfBirthCol = tblPatients.getColumns().get(2);

        firstNameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("lastName"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("dateOfBirth"));
    }

    public void tblClicked(MouseEvent mouseEvent) {
        Patient clickedPatient = tblPatients.getSelectionModel().getSelectedItem();
        if (mouseEvent.getClickCount() == 1) {
        } else {
            Stage stage = (Stage) ((Control) mouseEvent.getSource()).getScene().getWindow();
            PatientEditorD patientEditor = new PatientEditorD(clickedPatient, stage);
            patientEditor.showAndWait();
            if (!patientEditor.getController().isCanceled()) {
                patients.set(patients.indexOf(clickedPatient), patientEditor.getController().getPatient());
            }
        }
    }

    public ObservableList<Patient> getModel() {
        return patients;
    }

    public Patient getSelected() {
        int i = tblPatients.getSelectionModel().getSelectedIndex();
        if (i >= 0 && i < patients.size()) {
            return patients.get(i);
        } else {
            return null;
        }
    }

    public int getSelectedIndex() {
        return tblPatients.getSelectionModel().getSelectedIndex();
    }

    public ObservableList<Patient> getPatients() {
        return patients;
    }

    @Override
    public void onChanged(Change change) {
        change.next();
        if (change.wasReplaced()) {
            Patient patient = patients.get(change.getFrom());
            if(patient != null)
                repository.update(patient);
        } else if (change.wasAdded()) {
            repository.save(patients.get(change.getFrom()));
        } else if (change.wasRemoved()) {
            repository.delete((Patient) change.getRemoved().get(0));
        }
    }

}
