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
import controller.NewAppointment;

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
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/pat1.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH); 
		
		ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/images/doc2.png")); // load the image to a imageIcon
		Image image1 = imageIcon1.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/images/app2.png")); // load the image to a imageIcon
		Image image2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(34, 34,  java.awt.Image.SCALE_SMOOTH);
		
		//dodaj dugmice
		n = new JButton ();
		r= new JButton ();
		p= new JButton ();
		
		p.setIcon(new ImageIcon(newimg));
		p.setToolTipText("New patient");
		p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		n.setIcon(new ImageIcon(newimg1));
		n.setToolTipText("Start an appointment");
		n.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		r.setIcon(new ImageIcon(newimg2));
		r.setToolTipText("Start a CASE appointment");
		r.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		add(p);
		add(n);
		add(r);
		
		//dodaj AL
		AddPatient ap=new AddPatient();
		p.addActionListener(ap);
		
		NewAppointment np=new NewAppointment();
		n.addActionListener(np);
		
		setFloatable(true);
		setBackground(new Color(238, 213, 242));
		
		
		
	}

}
