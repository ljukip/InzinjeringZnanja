package InzinjeringOft.view.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import InzinjeringOft.controller.PatientController;
import InzinjeringOft.model.Patient;

public class PatientEditor extends Scene {
    private static final String FXML = "fxml/patient.fxml";

    private PatientController controller;

    public PatientEditor(Parent root, Patient patient) throws IOException {
        super(root);
    }

    public PatientController getController() {
        return controller;
    }

    public static PatientEditor create(Patient patient) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(FXML));
        PatientEditor PatientEditor = null;
        try {
            PatientEditor = new PatientEditor(loader.load(), patient);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        PatientController controller = loader.getController();
        controller.setPatient(patient);
        PatientEditor.controller = controller;

        return PatientEditor;
    }

}
