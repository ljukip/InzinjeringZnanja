package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import controller.BackAL;
import controller.ExtraSymptomsSelectedAL;
import controller.NextAL;
import controller.diseaseSelectedAL;

public class PosibleDiseasesPanel extends JPanel{
	
	
	private DefaultListModel<String> posibleDiseases;
	private JList<String> diseases;
	private DefaultListModel<String> extraSymptoms;
	private JList<String> symptoms;
	private JScrollPane scrollReport;
	private JScrollPane scrollExtraSymptoms;
	private JScrollPane ScrolListDiseases;
	private SpringLayout layout=new SpringLayout();
	
	private HashMap<String, Double> hashDiseases = new HashMap<String, Double>();
	private JLabel report;
	private String text="";
	private String selectedDisease;
	private JPanel graphPanel;
	private JButton ok=new JButton("Continue");
	private JButton cnc=new JButton("Back");

	public PosibleDiseasesPanel() {
		
		this.posibleDiseases = new DefaultListModel<>();
		this.diseases = new JList<>(posibleDiseases);

		this.extraSymptoms = new DefaultListModel<>();
		this.symptoms = new JList<>(extraSymptoms);

		this.setLayout(layout);
		
		this.diseases.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.diseases.setLayoutOrientation(JList.VERTICAL);
		this.diseases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.symptoms.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.symptoms.setLayoutOrientation(JList.VERTICAL);
		this.symptoms.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		diseases.addMouseListener(new diseaseSelectedAL());
		symptoms.addMouseListener(new ExtraSymptomsSelectedAL ());

		ScrolListDiseases = new JScrollPane();
		ScrolListDiseases.setViewportView(diseases);
		
		scrollReport = new JScrollPane();
		scrollExtraSymptoms= new JScrollPane();
		graphPanel= new JPanel();

		ScrolListDiseases.setPreferredSize(new Dimension( 244,340));
		scrollReport.setPreferredSize(new Dimension(440,116));
		scrollExtraSymptoms.setPreferredSize(new Dimension(244,340));
		scrollExtraSymptoms.setViewportView(symptoms);
		graphPanel.setPreferredSize(new Dimension(436,560));
		
		//setText(PatientsSymptomsPanel.text);
		report=new JLabel(this.getText());
		report.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		if(diseases.isSelectionEmpty()==true) {ok.setEnabled(false);}
		else {ok.setEnabled(true);}
		
		layout.putConstraint(SpringLayout.WEST, ScrolListDiseases,
                11,
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
		layout.putConstraint(SpringLayout.WEST, scrollReport,
                11,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollReport,
                440,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollExtraSymptoms,
                256,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollExtraSymptoms,
                11,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, graphPanel,
                466,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, graphPanel,
                11,
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
		
		this.add(ScrolListDiseases);
		this.add(scrollExtraSymptoms);
		this.add(scrollReport);
		this.add(graphPanel);
		this.add(ok);
		this.add(cnc);
		
		
		
		
		
	}
	
	public DefaultListModel getPosibleDiseases() {
		return posibleDiseases;
	}

	public void setPosibleDiseases(DefaultListModel posibleDiseases) {
		this.posibleDiseases = posibleDiseases;
	}

	public JList<String> getDiseases() {
		return diseases;
	}

	public void setDiseases(JList<String> diseases) {
		this.diseases = diseases;
	}

	public DefaultListModel getExtraSymptoms() {
		return extraSymptoms;
	}

	public void setExtraSymptoms(DefaultListModel extraSymptoms) {
		this.extraSymptoms = extraSymptoms;
	}

	public JList<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(JList<String> symptoms) {
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

	public String getSelectedDisease() {
		return selectedDisease;
	}

	public void setSelectedDisease(String selectedDisease) {
		this.selectedDisease = selectedDisease;
	}
	
	public void graphInsert()
	{
		// TODO Auto-generated method stub
		BufferedImage image;
		try
		{
			image = ImageIO.read(new File("InzinjeringOft_Chart.png"));
			Image tmp = image.getScaledInstance(266, 266, Image.SCALE_SMOOTH);
			BufferedImage bimg = new BufferedImage(266, 266, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = bimg.createGraphics();
			g2d.drawImage(tmp, 0, 0, null);
			g2d.dispose();

			JLabel picLabel = new JLabel(new ImageIcon(image));
			graphPanel.removeAll();
			graphPanel.add(picLabel);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	public void Clear() {
			// TODO Auto-generated method stub
			this.graphPanel.removeAll();
			this.posibleDiseases.clear();
			this.extraSymptoms.clear();
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
