package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.AddPatient;

public class ToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  JButton n,r,p;
	
	
	public ToolBar () {
		//precice
		KeyStroke keyAddP = KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK);
		Action performAddP = new AbstractAction() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		         System.out.println("AddPatient");
		    }
		}; 
		p = new JButton(performAddP);
		p.getActionMap().put("performAddP", performAddP);
		p.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyAddP, "performAddP");
		
		//slike
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/633_-_Create_User-512.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		
		//dodaj dugmice
		n = new JButton ("Start an appointment");
		r= new JButton ("Redo");
		p= new JButton ();
		p.setIcon(new ImageIcon(newimg));
		p.setToolTipText("New patient");
		p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(p);
		add(n);
		add(r);
		
		//dodaj AL
		AddPatient ap=new AddPatient();
		p.addActionListener(ap);
		
		setFloatable(true);
		setBackground(new Color(238, 213, 242));
		
		
		
	}

}
