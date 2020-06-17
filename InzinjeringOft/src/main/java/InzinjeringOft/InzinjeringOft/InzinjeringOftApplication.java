package InzinjeringOft.InzinjeringOft;

import java.awt.EventQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

@SpringBootApplication
public class InzinjeringOftApplication extends Application{
	
	public static final String TITLE = "InzinjeringOft";
    public static final String APP_LOGO = "/InzinjeringOft/images/logo.jpg";
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/InzinjeringOft/sample.fxml"));
        primaryStage.setTitle(String.format(TITLE));
        primaryStage.getIcons().add(new Image(APP_LOGO));
        primaryStage.setScene(new Scene(root, 600, 400));
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InzinjeringOftApplication.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {

        	InzinjeringOftApplication ex = ctx.getBean(InzinjeringOftApplication.class);
            Application.launch(args);
        });
    }

}