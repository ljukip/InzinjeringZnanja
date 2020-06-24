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
	private JPanel label;
	public static String text;
	private static JLabel txt;
	private JLabel report=new JLabel("Patient report:");
	public static boolean submit=false;
	
	public PatientsSymptomsPanel(){
		
		allSymptoms =new DefaultListModel<String>();
		selectedSymptoms=new DefaultListModel<String>();
		listAllSymptoms=new JList(allSymptoms);
		listSelectedSymptoms=new JList(selectedSymptoms);
		listScrollerSelected=new JScrollPane();
		
		SpringLayout layout=new SpringLayout();
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
		txt=new JLabel(text);
		txt.setFont(new Font("Calibri", Font.PLAIN, 16));
		System.out.println(text);
		report.setFont(new Font("Calibri", Font.BOLD, 21));

		listScrollerAll.setPreferredSize(new Dimension( 380,340));
		listScrollerSelected.setPreferredSize(new Dimension(380,340));
		

		JButton ok=new JButton("Continue");
		JButton cnc=new JButton("Cancel");
		ok.setEnabled(false);
		
		JButton reportB=new JButton ("report symptoms");
		reportB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				text="Patient " + patient.getFirstName() +" "+ patient.getLastName()+
						" is experiencing the following symptoms:" 
						+ selectedSymptoms.toString();
				MainFrame.getInstance().reportText=text;
				
				txt.setText(text);
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
		layout.putConstraint(SpringLayout.WEST, txt,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, txt,
                440,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, report,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, report,
                400,
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
		this.add(txt);
		this.add(report);
		this.add(reportB);
		this.add(ok);
		this.add(cnc);
		
		
		
		
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
		selectedSymptoms.addElement(s);
		
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
}
