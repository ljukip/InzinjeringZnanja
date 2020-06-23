package InzinjeringOft.view.scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Main extends Scene {
    private static String FXML = "InzinjeringOft/view/fxml/main.fxml";

    public Main(Parent root) {
        super(root);
    }

    public static Main create() {
    	System.out.println(ClassLoader.getSystemResource(FXML) + "ovde");
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(FXML));
        System.out.println(ClassLoader.getSystemResource(FXML));
        Main main = null;
        try {
            main = new Main(loader.load());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return main;
    }
}
