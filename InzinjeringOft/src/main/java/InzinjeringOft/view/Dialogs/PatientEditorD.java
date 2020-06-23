package InzinjeringOft.view.Dialogs;

import InzinjeringOft.controller.PatientController;
import InzinjeringOft.model.Patient;
import javafx.stage.Modality;
import javafx.stage.Stage;
import InzinjeringOft.view.scenes.PatientEditor;

public class PatientEditorD extends Stage {
    private InzinjeringOft.view.scenes.PatientEditor scene;
    private static final String TITLE = "Edit Patient";

    public PatientEditorD(Patient patient, Stage parent) {
        scene = PatientEditor.create(patient);

        setTitle(TITLE);
        setScene(scene);
        initOwner(parent);
        initModality(Modality.APPLICATION_MODAL);
    }

    public boolean isCanceled() {
        return getController().isCanceled();
    }

    public PatientController getController() {
        return scene.getController();
    }

    public static PatientEditorD edit(Patient patient, Stage parent) {
        PatientEditorD dialog = new PatientEditorD(patient, parent);
        dialog.showAndWait();
        return dialog;
    }

    public static PatientEditorD create(Stage parent) {
        PatientEditorD dialog = new PatientEditorD(null, parent);
        dialog.showAndWait();
        return dialog;
    }

}
