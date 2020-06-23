package InzinjeringOft.controller;

import org.springframework.beans.factory.annotation.Autowired;

import InzinjeringOft.enums.Genders;
import InzinjeringOft.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PatientController {
	
	@Autowired
	InzinjeringOft.repository.PatientRep PatientRep;

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtJMBG;
    @FXML
    private ComboBox cbGender;
    @FXML
    private TextField txtAdress;
    @FXML
    private DatePicker dpDateOfBirth;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    private Long id;

    private Patient patient;

    private boolean canceled = true;

    ObservableList<Genders> genders =
            FXCollections.observableArrayList(Genders.femail, Genders.mail, Genders.prefer_not_to_disclose);

    public void initialize() {
        cbGender.setItems(genders);
    }

    public void save(ActionEvent actionEvent) {
        patient = new Patient();

        patient.setId(this.id);
        patient.setFirstName(txtFirstName.getText().trim());
        patient.setLastName(txtLastName.getText().trim());
        patient.setJmbg(Long.parseLong(txtLastName.getText()));
        patient.setGender((Genders) cbGender.getSelectionModel().getSelectedItem());
        patient.setAddress(txtAdress.getText().trim());
        patient.setDateOfBirth(dpDateOfBirth.getValue());
        patient.setPhoneNumber(txtPhoneNumber.getText().trim());

        canceled = false;

        Stage stage = (Stage) ((Control) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Control) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (patient != null) {
            this.id = patient.getId();
            txtFirstName.setText(patient.getFirstName());
            txtLastName.setText(patient.getLastName());
            txtJMBG.setText(String.valueOf(patient.getJmbg()));
            cbGender.getSelectionModel().select(patient.getGender());
            txtAdress.setText(patient.getAddress());
            dpDateOfBirth.setValue(patient.getDateOfBirth());
            txtPhoneNumber.setText(patient.getPhoneNumber());
        }
    }

    public boolean isCanceled() {
        return canceled;
    }
}
