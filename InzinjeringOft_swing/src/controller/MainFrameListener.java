package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import app.Collections;
import model.Patient;
import view.MainFrame;

public class MainFrameListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		int temp = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
				"Are you sure you want to close the app?", "EXIT?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (temp != JOptionPane.YES_OPTION)
		{

			MainFrame.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		else
		{

			String path = "data/patients.txt";

			try
			{

				FileOutputStream fileOut = new FileOutputStream(path);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(Collections.getInstance().getPatientList());

				out.close();
				fileOut.close();
				System.out.println("\nSerialization Successful");

			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			System.exit(0);
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
