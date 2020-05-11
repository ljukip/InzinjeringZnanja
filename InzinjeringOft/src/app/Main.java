package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static final String TITLE = "InzinjeringOft";
    public static final String APP_LOGO = "/images/logo.jpg";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle(String.format(TITLE));
        primaryStage.getIcons().add(new Image(APP_LOGO));
        primaryStage.setScene(new Scene(root, 600, 400));
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

	public static void main(String[] args) {
		launch(args);

	}

}
