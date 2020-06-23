package InzinjeringOft.controller;


import java.awt.Image;
import java.io.FileInputStream;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Controller {
	
    @FXML
    private BorderPane patientList;
    

    public void initialize() {
        Font font = Font.font("Verdana", FontWeight.BOLD, 25);
        Text inz = new Text("Inzinjering");
        inz.setFill(Color.CADETBLUE);
        inz.setFont(font);

        Text oft = new Text("Oft");
        oft.setFont(font);
        oft.setFill(Color.INDIANRED);

    }
    
}
