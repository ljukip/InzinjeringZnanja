package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controller.BackAL;
import controller.NextAL;

public class SubmitChartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label,title;
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	JButton ok=new JButton("Submit");
	JButton cnc=new JButton("Back");
	
	public SubmitChartPanel(HashMap<String, String> mapa){
		SpringLayout layout=new SpringLayout();
		this.setLayout(layout);
		
		
		String text1 = "<H1 style='text-align: center;'>Chart for submition</H1><br>";
		
		String text = "<b>Patient:</b><br>" + mapa.get("Patient:") + "<br>";
		text = text.concat("<b>Reported symptoms:</b><br> ").concat(mapa.get("Reported symptoms:")).concat("<br><br>");
		text = text.concat("<b>Diagnosed with:</b> <br>").concat(mapa.get("Diagnosed with:")).concat("<br><br>");
		text = text.concat("<b>Additional procedures recomended:</b><br>").concat(mapa.get("Additional procedures recomended:")).concat("<br><br>");;
		text = text.concat("<b>Therapy prescribed:</b><br>").concat(mapa.get("Therapy prescribed:"));

		this.title = new JLabel("<html>" + text1 + "</html>");
		this.label = new JLabel("<html>" + text + "</html>");

		JScrollPane scroll=new JScrollPane(label);
		scroll.setBackground(new Color(227, 218, 224));

		label.setFont(new Font("Calibri", Font.PLAIN, 21));
		title.setFont(new Font("Calibri", Font.PLAIN, 36));
		label.setVerticalAlignment(JLabel.TOP);
		label.setVerticalTextPosition(JLabel.TOP); //600400
		
		scroll.setPreferredSize(new Dimension(640,416));
		title.setPreferredSize(new Dimension(640,86));
		scroll.setViewportView(label);
		
		layout.putConstraint(SpringLayout.WEST, title,
                266,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, title,
                11,
                SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scroll,
                60,
                SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll,
                56,
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

		this.add(title);
		this.add(scroll);
		this.add(ok);
		this.add(cnc);

		
		
	}

}
