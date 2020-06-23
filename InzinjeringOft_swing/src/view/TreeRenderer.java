package view;

import java.awt.Component;
import java.awt.Image;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import app.Collections;
import model.Appointment;
import model.Patient;

public class TreeRenderer extends DefaultTreeCellRenderer{
	private static final long serialVersionUID = 6126281402028638784L;
	private ImageIcon charts =new ImageIcon( getClass().getResource("/images/trans1.png") );
	private ImageIcon chart = new ImageIcon(getClass().getResource("/images/patient.png"));
	private ImageIcon appointment = new ImageIcon("images/doctor.png");
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			Object o = node.getUserObject();
			// do ovoga ne bi trebalo da dodje, ako je stablo pazljivo kreirano
			if (o == null) {
				return this;
			}
			if (o instanceof Collections)
			{
				setText("Charts");
				ImageIcon imageIcon = charts; // load the image to a imageIcon
				Image image = imageIcon.getImage(); // transform it 
				Image newimg = image.getScaledInstance(46, 46,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				setIcon(new ImageIcon(newimg));
			}
			else if (o instanceof Patient)
			{
				setIcon(chart);
				ImageIcon imageIcon = chart; 
				Image image = imageIcon.getImage(); // transform it 
				Image newimg = image.getScaledInstance(26, 26,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				setIcon(new ImageIcon(newimg));
				Patient p=(Patient) o;
				setText(p.getFirstName() + "  " + p.getLastName());
			}
			else if (o instanceof Appointment)
			{
				Appointment oo = (Appointment) o;
				setText(oo.toString());
				setIcon(appointment);
			}
		}
		return this;
	}

}
