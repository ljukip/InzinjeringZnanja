package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Collections;
import model.Appointment;
import model.Patient;
import view.MainFrame;
import view.PatientView;

public class PatientViewController extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		DefaultMutableTreeNode element = (DefaultMutableTreeNode) MainFrame.getInstance().getTree()
				.getLastSelectedPathComponent();
		Object o = element.getUserObject();

		if (o instanceof Patient)
		{

			MainFrame.getInstance().getPanel().removeAll();

			MainFrame.getInstance().getPanel().add(new PatientView((Patient) o, null));

			MainFrame.getInstance().getPanel().revalidate();
			MainFrame.getInstance().getPanel().repaint();
		}

		else if (o instanceof Appointment)
		{
			Patient pa = null;

			for (Patient patient : Collections.getInstance().getPatientList())
			{
				for (Appointment app : patient.getAppointments())
				{
					if (patient.equals(o))
					{
						pa = patient;
					}
				}
			}

			MainFrame.getInstance().getPanel().removeAll();

			PatientView view = new PatientView(pa, (Appointment) o);

			view.getRight().revalidate();
			view.getRight().repaint();

			MainFrame.getInstance().getPanel().add(view);

			MainFrame.getInstance().getPanel().revalidate();
			MainFrame.getInstance().getPanel().repaint();

		}

	}

}
