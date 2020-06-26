package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Appointment;
import model.Disease;
import model.Patient;
import view.MainFrame;
import view.PatientsSymptomsPanel;

public class NewCaseAppointment implements ActionListener{
	
	Patient patient;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//notify its case
		MainFrame.isCase=true;
		//kad se case zavrsi, vrati na false
		MainFrame.getInstance().setDisease(new Disease());;

		DefaultMutableTreeNode element = (DefaultMutableTreeNode) MainFrame.getInstance().getTree()
				.getLastSelectedPathComponent();

		if (element == null)
		{
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Patient not selected!", "Error1!",
					JOptionPane.WARNING_MESSAGE);
			return;
			/*JFrame listFrame=new JFrame("Patient selection");
			listFrame.setSize(466, 444);
			listFrame.setLocationRelativeTo(MainFrame.getInstance());
			listFrame.setLayout(new BorderLayout());
			String[] patients=new String[100];
			//dodajemo string za svakog pacijenta,ime,prezime,jmbg
			for (int i=0; i<Collections.getInstance().getPatientList().size(); i++) {
				patients[i]=Collections.getInstance().getPatientList().get(i).getFirstName();
			}
			
			JList list=new JList(patients);
			JButton ok=new JButton ("continue");
			JButton cnc=new JButton ("cancel");
			cnc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					
					listFrame.dispose();
				}
			});
			ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String patName=list.getSelectedValue().toString();
					for (int i=0; i<Collections.getInstance().getPatientList().size(); i++) {
						if (Collections.getInstance().getPatientList().get(i).getFirstName().equals(patName)) 
						{
							patient=Collections.getInstance().getPatientList().get(i);
							
						}
					}
					MainFrame.getInstance().getPsp().setPatient(patient);
					MainFrame.getInstance().getPanel().removeAll();
					PatientsSymptomsPanel view = MainFrame.getInstance().getPsp();
					MainFrame.getInstance().getPanel().add(view);
					MainFrame.getInstance().getPanel().revalidate();
					MainFrame.getInstance().getPanel().repaint();
					
					listFrame.dispose();
				}
			});
			
			JPanel dugmici=new JPanel();
			listFrame.add(list,BorderLayout.CENTER);
			dugmici.add(cnc);
			dugmici.add(ok);
			listFrame.add(dugmici,BorderLayout.SOUTH);
			listFrame.setVisible(true);
			
			*/
		}
		Object o = element.getUserObject();

		if (o instanceof Patient)
		{
			patient=(Patient) o;
			System.out.println(patient.getFirstName());
			MainFrame.getInstance().getPsp().setPatient(patient);
			MainFrame.getInstance().getPanel().removeAll();
			PatientsSymptomsPanel view = MainFrame.getInstance().getPsp();
			MainFrame.getInstance().getPanel().add(view);
			MainFrame.getInstance().getPanel().revalidate();
			MainFrame.getInstance().getPanel().repaint();
		}
		else if (o instanceof Appointment)
		{

			DefaultMutableTreeNode parent = (DefaultMutableTreeNode) element.getParent();

			MainFrame.getInstance().getPsp().setPatient((Patient) parent.getUserObject());
		}
		else
		{
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Wrong selection", "Error!",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// TODO Auto-generated method stub
		//MainFrame.getInstance().setRegime(Regime.RBR);

		MainFrame.getInstance().getPsp().clearSymptoms();
		//MainFrame.getInstance().getPp2().ocistiMe();

		/*MainFrame.getInstance().getPsp().setText(MainFrame.getInstance().getPsp().getText()
				.replace("[ime mentola]", MainFrame.getInstance().getPsp().getPatient().toString()));

		*/
		ArrayList<String> symptoms=MainFrame.getInstance().getData().getSymptoms();
		MainFrame.getInstance().getPsp().inputSymptoms(symptoms);
		
		MainFrame.getInstance().getPanel().removeAll();
		PatientsSymptomsPanel view = MainFrame.getInstance().getPsp();
		MainFrame.getInstance().getPanel().add(view);
		MainFrame.getInstance().getPanel().revalidate();
		MainFrame.getInstance().getPanel().repaint();
		
	}

}
