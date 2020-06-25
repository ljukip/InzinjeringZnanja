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
import controller.NextAL;
import controller.SelectMedications;
import controller.SelectProcedures;

public class ProcedureMedicationPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JList<String> listMeds, listProcedures, listSelMeds, listSelProcedures;
	private DefaultListModel<String> meds, procedures, selMeds, selProcedures;
	private HashMap<String, Integer> hashMeds= new HashMap<String, Integer>();
	private HashMap<String, Integer> hashProcedures= new HashMap<String, Integer>();
	private JPanel chartMeds, chartProcedures;
	private JButton ok=new JButton("Continue");
	private JButton cnc=new JButton("Back");
	private JScrollPane scrollMeds, scrollProcedures, scrollSelMeds, scrollSelProcedures;

	
	public ProcedureMedicationPanel() {
		
		this.meds = new DefaultListModel<>();
		this.listMeds = new JList<>(meds);

		this.procedures = new DefaultListModel<>();
		this.listProcedures = new JList<>(procedures);
		
		this.selProcedures = new DefaultListModel<>();
		this.listSelProcedures = new JList<>(selProcedures);
		
		this.selMeds = new DefaultListModel<>();
		this.listSelMeds = new JList<>(selMeds);

		SpringLayout layout=new SpringLayout();
		this.setLayout(layout);
		
		this.listMeds.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.listMeds.setLayoutOrientation(JList.VERTICAL);
		this.listMeds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.listProcedures.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.listProcedures.setLayoutOrientation(JList.VERTICAL);
		this.listProcedures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.listSelMeds.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.listSelMeds.setLayoutOrientation(JList.VERTICAL);
		this.listSelMeds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.listSelProcedures.setFont(new Font("Calibri", Font.PLAIN, 16));
		this.listSelProcedures.setLayoutOrientation(JList.VERTICAL);
		this.listSelProcedures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//add listeners
		listMeds.addMouseListener(new SelectMedications());
		listProcedures.addMouseListener(new SelectProcedures ());
		
		scrollMeds= new JScrollPane();
		scrollProcedures= new JScrollPane();
		scrollSelMeds= new JScrollPane();
		scrollSelProcedures= new JScrollPane();
		
		scrollMeds.setViewportView(listMeds);
		scrollProcedures.setViewportView(listProcedures);
		scrollSelMeds.setViewportView(listSelMeds);
		scrollSelProcedures.setViewportView(listSelProcedures);
		
		chartMeds=new JPanel();
		chartProcedures= new JPanel();
		
		scrollMeds.setPreferredSize(new Dimension( 264,244));
		scrollProcedures.setPreferredSize(new Dimension( 264,244));
		scrollSelMeds.setPreferredSize(new Dimension( 264,244));
		scrollSelProcedures.setPreferredSize(new Dimension( 264,244));
		chartMeds.setPreferredSize(new Dimension(216,280));
		chartProcedures.setPreferredSize(new Dimension(216,280));
		
		layout.putConstraint(SpringLayout.WEST, scrollProcedures,
                11,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollProcedures,
                11,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollMeds,
                11,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollMeds,
                286,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollSelMeds,
                276,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollSelMeds,
                286,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollSelProcedures,
                276,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollSelProcedures,
                11,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, chartProcedures,
                556,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chartProcedures,
                0,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, chartMeds,
                556,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, chartMeds,
                286,
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
		
		this.add(chartMeds);
		this.add(chartProcedures);
		this.add(scrollMeds);
		this.add(scrollProcedures);
		this.add(scrollSelMeds);
		this.add(scrollSelProcedures);
		this.add(ok);
		this.add(cnc);
		
		
	}
	
	
	public void fillMeds()
	{
		meds.clear();

		for (Map.Entry<String, Integer> iter : hashMeds.entrySet())
		{
			meds.addElement(iter.getKey());
		}

	}

	public void fillProcedures()
	{
		procedures.clear();

		/*@SuppressWarnings("unused")
		Graph g = new Graph(hashMeds, 1);*/

		for (Map.Entry<String, Integer> iter : hashProcedures.entrySet())
		{
			procedures.addElement(iter.getKey());
		}

	}
	
	
	public void clear()
	{
		// TODO Auto-generated method stub

		this.selMeds.clear();
		this.selProcedures.clear();

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
	public JScrollPane getScrollMeds() {
		return scrollMeds;
	}
	public void setScrollMeds(JScrollPane scrollMeds) {
		this.scrollMeds = scrollMeds;
	}
	public JScrollPane getScrollMedsProcedures() {
		return scrollProcedures;
	}
	public void setScrollMedsProcedures(JScrollPane scrollMedsProcedures) {
		this.scrollProcedures = scrollMedsProcedures;
	}
	public JScrollPane getScrollMedsSelMeds() {
		return scrollSelMeds;
	}
	public void setScrollMedsSelMeds(JScrollPane scrollMedsSelMeds) {
		this.scrollSelMeds = scrollMedsSelMeds;
	}
	public JScrollPane getScrollMedsSelProcedures() {
		return scrollSelProcedures;
	}
	public void setScrollMedsSelProcedures(JScrollPane scrollMedsSelProcedures) {
		this.scrollSelProcedures = scrollMedsSelProcedures;
	}

	public JList<String> getListMeds() {
		return listMeds;
	}
	public void setListMeds(JList<String> listMeds) {
		this.listMeds = listMeds;
	}
	public JList<String> getListProcedures() {
		return listProcedures;
	}
	public void setListProcedures(JList<String> listProcedures) {
		this.listProcedures = listProcedures;
	}
	public JList<String> getListSelMeds() {
		return listSelMeds;
	}
	public void setListSelMeds(JList<String> listSelMeds) {
		this.listSelMeds = listSelMeds;
	}
	public JList<String> getListSelProcedures() {
		return listSelProcedures;
	}
	public void setListSelProcedures(JList<String> listSelProcedures) {
		this.listSelProcedures = listSelProcedures;
	}
	public DefaultListModel<String> getMeds() {
		return meds;
	}
	public void setMeds(DefaultListModel<String> meds) {
		this.meds = meds;
	}
	public DefaultListModel<String> getProcedures() {
		return procedures;
	}
	public void setProcedures(DefaultListModel<String> procedures) {
		this.procedures = procedures;
	}
	public DefaultListModel<String> getSelMeds() {
		return selMeds;
	}
	public void setSelMeds(DefaultListModel<String> selMeds) {
		this.selMeds = selMeds;
	}
	public DefaultListModel<String> getSelProcedures() {
		return selProcedures;
	}
	public void setSelProcedures(DefaultListModel<String> selProcedures) {
		this.selProcedures = selProcedures;
	}
	public HashMap<String, Integer> getHashMeds() {
		return hashMeds;
	}
	public void setHashMeds(HashMap<String, Integer> hashMeds) {
		this.hashMeds = hashMeds;
	}
	public HashMap<String, Integer> getHashProcedures() {
		return hashProcedures;
	}
	public void setHashProcedures(HashMap<String, Integer> hashProcedures) {
		this.hashProcedures = hashProcedures;
	}
	public JPanel getChartMeds() {
		return chartMeds;
	}
	public void setChartMeds(JPanel chartMeds) {
		this.chartMeds = chartMeds;
	}
	public JPanel getChartProcedures() {
		return chartProcedures;
	}
	public void setChartProcedures(JPanel chartProcedures) {
		this.chartProcedures = chartProcedures;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void graphInsert() {
		// TODO Auto-generated method stub
		BufferedImage image,image1;
		try
		{
			image = ImageIO.read(new File("medications.png"));
			Image tmp = image.getScaledInstance(266, 266, Image.SCALE_SMOOTH);
			BufferedImage bimg = new BufferedImage(266, 266, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d = bimg.createGraphics();
			g2d.drawImage(tmp, 0, 0, null);
			g2d.dispose();

			JLabel picLabel = new JLabel(new ImageIcon(image));
			chartMeds.removeAll();
			chartMeds.add(picLabel);
			
			image1 = ImageIO.read(new File("procedures.png"));
			Image tmp1 = image1.getScaledInstance(266, 266, Image.SCALE_SMOOTH);
			BufferedImage bimg1 = new BufferedImage(266, 266, BufferedImage.TYPE_INT_ARGB);

			Graphics2D g2d1 = bimg1.createGraphics();
			g2d1.drawImage(tmp1, 0, 0, null);
			g2d1.dispose();

			JLabel picLabel1 = new JLabel(new ImageIcon(image1));
			chartProcedures.removeAll();
			chartProcedures.add(picLabel1);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
