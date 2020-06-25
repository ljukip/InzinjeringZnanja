package app;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.UIManager;

import model.Patient;
import view.MainFrame;

import com.jtattoo.plaf.smart.SmartLookAndFeel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        
			Properties props = new Properties();
            
            props.put("logoString", "InzinjeringOft"); 
            props.put("licenseKey", "INSERT YOUR LICENSE KEY HERE");
            
            props.put("selectionBackgroundColor", "190 230 227"); 
            //props.put("selectionBackgroundColor", "255 247 253");
            props.put("menuSelectionBackgroundColor", "226 255 253"); 
            
            props.put("controlColor", "255 247 253");
            props.put("controlColorLight", "255 247 253");
            props.put("controlColorDark", "226 255 253"); 

            props.put("buttonColor", "226 255 253");
            props.put("buttonForegroundColor", "53 5 61");
            props.put("buttonColorLight", "255 247 253");
            props.put("buttonColorDark", "255 247 253");

            props.put("rolloverColor", "255 247 253"); 
            props.put("rolloverColorLight", "255 247 253"); 
            props.put("rolloverColorDark", "226 255 253"); 

            props.put("windowTitleForegroundColor", "255 247 253");
            props.put("windowTitleBackgroundColor", "255 247 253"); 
            props.put("windowTitleColorLight", "255 247 253"); 
            props.put("windowTitleColorDark", "238 213 242"); 
            props.put("windowBorderColor", "255 247 253");
            props.put("logoString", "InzinjeringOft");
            
            props.put("foregroundColor", "53 5 61");
            props.put("backgroundColor", "255 237 246");
            props.put("backgroundPattern", "on");
            props.put("inputForegroundColor", "53 5 61");
            props.put("inputBackgroundColor", "226 255 253");
            props.put("frameColor", "255 247 253");
            props.put("gridColor", "226 255 253");
            props.put("focusColor", "190 230 227");
            props.put("windowIconRolloverColor", "226 255 253");
            props.put("windowInactiveTitleColor", "226 255 253");
            props.put("menuForegroundColor", "53 5 61");
            props.put("menuBackgroundColor", "255 247 253");
            props.put("menuSelectionBackgroundColor", "234 255 254");
            props.put("menuColorLight", "255 247 253");
            props.put("menuSelectionForegroundColor", "53 5 61");
            props.put("toolbarDecorated","on");
            //props.put("toolbarForegroundColor", "238 213 242");
            props.put("toolbarBackgroundColor","238 213 242");
           // props.put("tabAreaBackgroundColor", "255 247 253");
            props.put("desktopColor", "255 247 253");
	            
	            // set your theme
	            SmartLookAndFeel.setCurrentTheme(props);
	    		
			 UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
	    } 
	    catch (Exception e) {
	       System.out.println("Look and feel error");
	    }
		 
		 UIManager.put("Panel.background", new Color(227, 218, 224));

		String path = "data/patients.txt";
		try
		{
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			try
			{
				@SuppressWarnings("unchecked")
				ArrayList<Patient> patients = (ArrayList<Patient>) in.readObject();

				Collections.getInstance().setPatientList(patients);
			}
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fileIn.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		MainFrame mf = MainFrame.getInstance();
		try {
            URL resource = mf.getClass().getResource("/images/Blue_eye_icon.png");
            BufferedImage image = ImageIO.read(resource);
            mf.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
		mf.setVisible(true);

	}

}
