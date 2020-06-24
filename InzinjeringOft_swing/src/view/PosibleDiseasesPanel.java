package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

public class PosibleDiseasesPanel extends JPanel{
	
	
	private DefaultListModel posibleDiseases;
	private JList diseases;
	private DefaultListModel extraSymptoms;
	private JList symptoms;
	private JScrollPane scrollReport;
	private JScrollPane scrollExtraSymptoms;
	private JScrollPane ScrolListDiseases;
	
	private HashMap<String, Double> hashDiseases = new HashMap<String, Double>();
	private JLabel report;
	public static String text;

	public PosibleDiseasesPanel() {
		
		this.posibleDiseases = new DefaultListModel<>();
		this.diseases = new JList<>(posibleDiseases);
		System.out.println(posibleDiseases + "radi ubacivanje");

		this.extraSymptoms = new DefaultListModel<>();
		this.symptoms = new JList<>(extraSymptoms);

		SpringLayout layout=new SpringLayout();
		this.setLayout(layout);
		
		this.diseases.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.diseases.setLayoutOrientation(JList.VERTICAL);
		this.diseases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.symptoms.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.symptoms.setLayoutOrientation(JList.VERTICAL);
		this.symptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ScrolListDiseases = new JScrollPane();
		ScrolListDiseases.setViewportView(diseases);
		
		scrollReport = new JScrollPane();
		scrollExtraSymptoms= new JScrollPane();

		ScrolListDiseases.setPreferredSize(new Dimension( 266,340));
		scrollReport.setPreferredSize(new Dimension(640,116));
		scrollExtraSymptoms.setPreferredSize(new Dimension(266,340));
		scrollExtraSymptoms.setViewportView(symptoms);
		
		//setText(PatientsSymptomsPanel.text);
		report=new JLabel(text);
		report.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		layout.putConstraint(SpringLayout.WEST, ScrolListDiseases,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, ScrolListDiseases,
                11,
                SpringLayout.NORTH, this);
		/*layout.putConstraint(SpringLayout.WEST, labelSelect,
                420,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, labelSelect,
                11,
                SpringLayout.NORTH, this);
		*/
		layout.putConstraint(SpringLayout.WEST, report,
                20,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, report,
                440,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollExtraSymptoms,
                296,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollExtraSymptoms,
                11,
                SpringLayout.NORTH, this);
		
		this.add(ScrolListDiseases);
		this.add(report);
		this.add(scrollExtraSymptoms);
		
		
		
		
		
	}
	
	public DefaultListModel getPosibleDiseases() {
		return posibleDiseases;
	}

	public void setPosibleDiseases(DefaultListModel posibleDiseases) {
		this.posibleDiseases = posibleDiseases;
	}

	public JList getDiseases() {
		return diseases;
	}

	public void setDiseases(JList diseases) {
		this.diseases = diseases;
	}

	public DefaultListModel getExtraSymptoms() {
		return extraSymptoms;
	}

	public void setExtraSymptoms(DefaultListModel extraSymptoms) {
		this.extraSymptoms = extraSymptoms;
	}

	public JList getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(JList symptoms) {
		this.symptoms = symptoms;
	}

	public JScrollPane getScrollReport() {
		return scrollReport;
	}

	public void setScrollReport(JScrollPane scrollReport) {
		this.scrollReport = scrollReport;
	}

	public JScrollPane getScrollExtraSymptoms() {
		return scrollExtraSymptoms;
	}

	public void setScrollExtraSymptoms(JScrollPane scrollExtraSymptoms) {
		this.scrollExtraSymptoms = scrollExtraSymptoms;
	}

	public JScrollPane getScrolListDiseases() {
		return ScrolListDiseases;
	}

	public void setScrolListDiseases(JScrollPane scrolListDiseases) {
		ScrolListDiseases = scrolListDiseases;
	}

	public HashMap<String, Double> getHashDiseases() {
		return hashDiseases;
	}

	public void setHashDiseases(HashMap<String, Double> hashDiseases) {
		this.hashDiseases = hashDiseases;
	}
	public void fillHasDiseases()
	{
		// TODO Auto-generated method stub

		for (Map.Entry<String, Double> iter : hashDiseases.entrySet())
		{
			posibleDiseases.addElement(iter.getKey());
		}

	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
