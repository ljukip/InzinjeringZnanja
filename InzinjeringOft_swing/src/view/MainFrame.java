package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import app.Collections;
import controller.LoadData;
import controller.MainFrameListener;
import controller.PatientViewController;
import model.Appointment;
import model.Disease;
import model.Medication;
import model.Patient;



public class MainFrame extends JFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static MainFrame instance;
		public ToolBar toolBar;
		public MenuBar menuBar;
		public StatusBar statusBar;
		
		private JTree tree;
		private DefaultTreeModel treeModel;
		private Collections charts;
		private Disease disease;
		private ArrayList <Medication> meds;
		private ArrayList <Appointment> app;
		DefaultMutableTreeNode workspace;
		JPanel leftPanel,rightPanel,centerPanel;
		private PatientsSymptomsPanel psp;
		private PosibleDiseasesPanel pdp;
		private ProcedureMedicationPanel pmp;
		private SubmitChartPanel scp;

		public static String reportText;
		public static Boolean isCase=false;
		
		private LoadData data;
		private HashMap<String, Double> MapCbrDiseases;


		public MainFrame()  {
			
			setMapCbrDiseases(new HashMap<>());
			meds=new ArrayList <Medication>();
			app=new ArrayList <Appointment>();
			
			setDisease(new Disease());
			setData(new LoadData());
			
			this.addWindowListener(new MainFrameListener());//serijalizacija
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			setSize(1144,741);
			setTitle("InzinjeringOft");

			setLocationRelativeTo(null);
			
			JPanel main = new JPanel();
			main.setLayout(new BorderLayout());
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			
			menuBar = new MenuBar();
			toolBar =new ToolBar();
			
			
			panel.add(menuBar,BorderLayout.NORTH);
			panel.add(toolBar, BorderLayout.SOUTH);
			   
			
			main.add(panel, BorderLayout.NORTH);
			main.setBackground(new Color(248,209, 228));
			
			leftPanel = new JPanel();
			rightPanel = new JPanel();
			centerPanel= new JPanel();
			int lPw = (int) (Math.round(getWidth() * 0.26));
			int rPw = (int) (Math.round(getWidth() * 0.26));
			
				ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/Blue_eye_icon.png"));
				Image img = imageIcon.getImage(); // transform it 
	    		Image newimg = img.getScaledInstance(564, 564,  java.awt.Image.SCALE_SMOOTH);
	            JLabel picLabel = new JLabel(new ImageIcon(newimg));
	            JLabel txtLabel = new JLabel("InzinjeringOft",SwingConstants.CENTER);
	            txtLabel.setSize(600, 400);
	            txtLabel.setFont(new Font("Calibri", Font.BOLD, 60));
	            centerPanel.setLayout(new BorderLayout());
				centerPanel.add(picLabel,BorderLayout.CENTER);
				centerPanel.add(txtLabel,BorderLayout.NORTH);
			
			
			main.setLayout(new BorderLayout());
			leftPanel.setPreferredSize(new Dimension(lPw, getHeight()));//za prikaz
			rightPanel.setPreferredSize(new Dimension(rPw, getHeight())); //za stablo
			//rightPanel.setBackground(new Color(226,255, 253)); 
			leftPanel.setBackground(new Color(248,209, 228));
			
			//stablo kartona
			charts = Collections.getInstance();

			workspace = new DefaultMutableTreeNode(charts);
			treeModel = new DefaultTreeModel(workspace);
			tree = new JTree(treeModel);
			tree.setCellRenderer(new TreeRenderer());
			tree.setShowsRootHandles(true);
			
			treeModel.addTreeModelListener(new TreeModelListener()
			{

				@Override
				public void treeStructureChanged(TreeModelEvent e)
				{
					expandAllNodes(tree, 0, tree.getRowCount());
					tree.revalidate();
					tree.repaint();
				}

				@Override
				public void treeNodesRemoved(TreeModelEvent e)
				{
					// TODO Auto-generated method stub
					expandAllNodes(tree, 0, tree.getRowCount());
					tree.revalidate();
					tree.repaint();
				}

				@Override
				public void treeNodesInserted(TreeModelEvent e)
				{
					// TODO Auto-generated method stub
					expandAllNodes(tree, 0, tree.getRowCount());
					tree.repaint();
					tree.revalidate();
				}

				@Override
				public void treeNodesChanged(TreeModelEvent e)
				{
					expandAllNodes(tree, 0, tree.getRowCount());
					tree.revalidate();
					tree.repaint();

				}
			});
			
			tree.addMouseListener(new PatientViewController()); //dvoklikna cvor, otvori Patienta
			DefaultMutableTreeNode element = (DefaultMutableTreeNode) getTreeModel().getRoot();
			for (Patient temp : Collections.getInstance().getPatientList())
			{
				getTreeModel().insertNodeInto(new DefaultMutableTreeNode(temp), element, element.getChildCount());

			}
			int PatientNum = element.getChildCount();

			for (int i = 0; i < PatientNum; i++)
			{
				DefaultMutableTreeNode Patient = (DefaultMutableTreeNode) element.getChildAt(i);
				Patient patient = (Patient) Patient.getUserObject();
				for (model.Appointment pp : patient.getAppointments())
				{
					getTreeModel().insertNodeInto(new DefaultMutableTreeNode(pp), Patient, Patient.getChildCount());
				}
			}
			tree.setBackground(new Color(226, 255, 253));
			JScrollPane scroll = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			scroll.setPreferredSize(new Dimension(rPw, getHeight()));
			scroll.setBackground(new Color(226, 255, 253));
			//rightPanel.add(scroll);
			
			//main.add(leftPanel,BorderLayout.WEST);
			main.add(centerPanel,BorderLayout.CENTER);
			main.add(scroll,BorderLayout.EAST);
			
			ToolBar tB = new ToolBar();
			this.add(tB, BorderLayout.NORTH);
			
			setPsp(new PatientsSymptomsPanel());
			setPdp(new PosibleDiseasesPanel());
			setPmp(new ProcedureMedicationPanel());
			//setScp(new SubmitChartPanel());
			
			add(main);
			
		
			
			
		}


		public DefaultTreeModel getTreeModel() {
			// TODO Auto-generated method stub
			return treeModel;
		}


		public static MainFrame getInstance() {
			if (instance == null)
			{
				instance = new MainFrame();
			}
			return instance;
		}
		public JTree getTree()
		{
			return tree;
		}

		public void setTree(JTree tree)
		{
			this.tree = tree;
		}
		
		public DefaultMutableTreeNode getWorkspace()
		{
			return workspace;
		}

		public void setWorkspace(DefaultMutableTreeNode workspace)
		{
			this.workspace = workspace;
		}
		
		public void setTreeModel(DefaultTreeModel treeModel)
		{
			this.treeModel = treeModel;
		}
		
		public void expandAllNodes(JTree tree, int startingIndex, int rowCount)
		{
			for (int i = startingIndex; i < rowCount; ++i)
			{
				tree.expandRow(i);
			}

			if (tree.getRowCount() != rowCount)
			{
				expandAllNodes(tree, rowCount, tree.getRowCount());
			}
		}


		public JPanel getPanel() {
			return centerPanel;
		}
		public void setPanel(JPanel panel) {
			this.centerPanel=panel;
		}


		public Disease getDisease() {
			return disease;
		}


		public void setDisease(Disease disease) {
			this.disease = disease;
		}


		public PatientsSymptomsPanel getPsp() {
			return psp;
		}


		public void setPsp(PatientsSymptomsPanel psp) {
			this.psp = psp;
		}


		public LoadData getData() {
			return data;
		}


		public void setData(LoadData data) {
			this.data = data;
		}


		public PosibleDiseasesPanel getPdp() {
			return pdp;
		}


		public void setPdp(PosibleDiseasesPanel pdp) {
			this.pdp = pdp;
		}


		public ProcedureMedicationPanel getPmp() {
			return pmp;
		}


		public void setPmp(ProcedureMedicationPanel pmp) {
			this.pmp = pmp;
		}


		public SubmitChartPanel getScp() {
			return scp;
		}


		public void setScp(SubmitChartPanel scp) {
			this.scp = scp;
		}


		public HashMap<String, Double> getMapCbrDiseases() {
			return MapCbrDiseases;
		}


		public void setMapCbrDiseases(HashMap<String, Double> MapCbrDiseases) {
			this.MapCbrDiseases = MapCbrDiseases;
		}


		public ArrayList<Medication> getMeds() {
			return meds;
		}


		public void setMeds(ArrayList<Medication> meds) {
			this.meds = meds;
		}


		public ArrayList <Appointment> getApp() {
			return app;
		}


		public void setApp(ArrayList <Appointment> app) {
			this.app = app;
		}
		
		
		
	}
