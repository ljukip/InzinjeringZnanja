package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import controller.BackAL;
import controller.NextAL;
import controller.selectSymptom;
import controller.unselectSymptom;
import model.Patient;

public class PatientsSymptomsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	private JList<String> listAllSymptoms;
	private JList<String> listSelectedSymptoms;
	private DefaultListModel<String> allSymptoms;
	private DefaultListModel<String> selectedSymptoms;
	private JScrollPane listScrollerAll;
	private JScrollPane listScrollerSelected;
	private JScrollPane scrollReport;
	private JPanel label;
	public static String text;
	private static JLabel txt;
	private JLabel reportTitle=new JLabel("Patient report:");
	private JLabel report=new JLabel("Patient report:");
	public static boolean submit=false;
	private JButton ok=new JButton("Continue");
	private SpringLayout layout=new SpringLayout();
	private JButton cnc=new JButton("Cancel");
	
	public PatientsSymptomsPanel(){
		
		allSymptoms =new DefaultListModel<String>();
		selectedSymptoms=new DefaultListModel<String>();
		listAllSymptoms=new JList(allSymptoms);
		listSelectedSymptoms=new JList(selectedSymptoms);
		listScrollerSelected=new JScrollPane();
		scrollReport = new JScrollPane();
		
		this.setLayout(layout);
		
		//izgled listi
		listAllSymptoms.setFont(new Font("Calibri", Font.PLAIN, 16));
		listAllSymptoms.setLayoutOrientation(JList.VERTICAL);
		listAllSymptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//listAllSymptoms.setBackground(Color.black);
		listScrollerAll=new JScrollPane(listAllSymptoms, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listScrollerAll.setViewportView(listAllSymptoms);
		
		listSelectedSymptoms.setFont(new Font("Calibri", Font.PLAIN, 16));
		listSelectedSymptoms.setLayoutOrientation(JList.VERTICAL);
		listSelectedSymptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//listSelectedSymptoms.setBackground(Color.white);
		listScrollerSelected.setViewportView(listSelectedSymptoms);
		
		//listeneri, kada se klikne na simptom doda se u izabrane,kada se klikne na izabrani,brise se
		listAllSymptoms.addMouseListener(new selectSymptom());
		listSelectedSymptoms.addMouseListener(new unselectSymptom());
		
		JLabel labelAll=new JLabel("Please select symptomps:");
		JLabel labelSelect=new JLabel("Selected symptomps are:");
		labelSelect.setFont(new Font("Calibri", Font.BOLD, 21));
		labelAll.setFont(new Font("Calibri", Font.BOLD, 21));
		
		label=new JPanel();
		label.setLayout(layout);
		text="Patient hasnt reported any symptoms";
		System.out.println(text);
		report=new JLabel(this.getText());
		report.setFont(new Font("Calibri", Font.PLAIN, 16));
		reportTitle.setFont(new Font("Calibri", Font.BOLD, 16));

		listScrollerAll.setPreferredSize(new Dimension( 380,340));
		listScrollerSelected.setPreferredSize(new Dimension(380,340));
		scrollReport.setPreferredSize(new Dimension(440,116));
		

		ok.setEnabled(false);
		
		JButton reportB=new JButton ("report symptoms");
		reportB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				text="<html>Patient " + patient.getFirstName() +" "+ patient.getLastName()+
						" has reported:<br/>" 
						+ selectedSymptoms.toString()+"<html>";
				JLabel temp=new JLabel(text);
				MainFrame.getInstance().getPsp().setReport(temp);
				submit=true;
				ok.setEnabled(true);
				MainFrame.getInstance().getPsp().revalidate();
				MainFrame.getInstance().getPsp().repaint();
				
			}
			
		});
		
		layout.putConstraint(SpringLayout.WEST, labelAll,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labelAll,
                11,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, labelSelect,
                420,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labelSelect,
                11,
                SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, listScrollerAll,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, listScrollerAll,
                40,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, listScrollerSelected,
                420,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, listScrollerSelected,
                40,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, reportTitle,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, reportTitle,
                400,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollReport,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollReport,
                421,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, reportB,
                690,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, reportB,
                400,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ok,
                740,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ok,
                600,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cnc,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cnc,
                600,
                SpringLayout.NORTH, this);
		
		cnc.addActionListener(new BackAL());
		ok.addActionListener(new NextAL());
		
		this.add(listScrollerAll);
		this.add(listScrollerSelected);
		this.add(labelAll);
		this.add(labelSelect);
		this.add(reportTitle);
		this.add(scrollReport);
		this.add(reportB);
		this.add(ok);
		this.add(cnc);
		
		
		
		
	}
	public JLabel getReport() {
		return report;
	}
	public void setReport(JLabel report) {
		this.remove(report);
		this.report = report;
		this.remove(scrollReport);
		scrollReport=new JScrollPane(report);
		
		scrollReport.setPreferredSize(new Dimension( 440,96));
		this.layout.putConstraint(SpringLayout.WEST, scrollReport,
                20,
                SpringLayout.WEST, this);
		this.layout.putConstraint(SpringLayout.NORTH, scrollReport,
                440,
                SpringLayout.NORTH, this);
		this.add(scrollReport);
		this.revalidate();
		this.repaint();
	}
	public void inputSymptoms(ArrayList<String> list)
	{
		for (String s : list)
			allSymptoms.addElement(s);

	}

	
	public boolean addSelectedSymptom(String s) {
		//ako je vec izabran,preskoci,u suprotnom dodaj
		if (selectedSymptoms.contains(s))
			return false;
		else {
		selectedSymptoms.addElement(s);
		}
		this.revalidate();
		this.repaint();
		
		//dodaj izvestaj

		return true;
	}
	
	public boolean removeSelectedSymptom(String s) {
		if (selectedSymptoms.contains(s)) {
			selectedSymptoms.removeElement(s);
			this.revalidate();
			this.repaint();

			return true;
		}
		
		return false;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void clearSymptoms() {
		// TODO Auto-generated method stub
		
	}
	public JList<String> getListAllSymptoms() {
		return listAllSymptoms;
	}

	public void setListAllSymptoms(JList<String> listAllSymptoms) {
		this.listAllSymptoms = listAllSymptoms;
	}

	public JList<String> getListSelectedSymptoms() {
		return listSelectedSymptoms;
	}

	public void setListSelectedSymptoms(JList<String> listSelectedSymptoms) {
		this.listSelectedSymptoms = listSelectedSymptoms;
	}

	public DefaultListModel<String> getAllSymptoms() {
		return allSymptoms;
	}

	public void setAllSymptoms(DefaultListModel<String> allSymptoms) {
		this.allSymptoms = allSymptoms;
	}

	public DefaultListModel<String> getSelectedSymptoms() {
		return selectedSymptoms;
	}

	public void setSelectedSymptoms(DefaultListModel<String> selectedSymptoms) {
		this.selectedSymptoms = selectedSymptoms;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public JLabel getTxt() {
		return txt;
	}
	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public void replaceTxt(String txt) {
		this.text = txt;
		this.txt.revalidate();
		this.txt.repaint();
	}
	public JButton getOk() {
		return ok;
	}
	public void setOk(JButton ok) {
		this.ok = ok;
	}
	public JButton getCnc() {
		return cnc;
	}
	public void setCnc(JButton cnc) {
		this.cnc = cnc;
	}

}
