package controller;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.RandomAccess;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.tree.DefaultMutableTreeNode;

import com.toedter.calendar.JCalendar;

import app.Collections;
import enums.Genders;
import enums.Race;
import model.Patient;
import view.MainFrame;

public class AddPatient implements ActionListener{
	Patient p;
	
	JLabel namel, surnamel,jmbgl,adressl,cityl,phonel,emaill,datel, genderl,racel;
	JTextField name, surname,jmbg,adress,city,phone,email;
	JCalendar date;
	JButton ok,cnc;
	JComboBox gender,race;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame dodaj= new JFrame("New patient");
		dodaj.setSize(466, 644);
		dodaj.setLocationRelativeTo(MainFrame.getInstance());
		SpringLayout layout = new SpringLayout();
		dodaj.setLayout(layout);
		
		
		namel = new JLabel("First name:");
		surnamel=new JLabel("Last name:");
		jmbgl= new JLabel ("JMBG:");
		adressl=new JLabel ("Adress:");
		cityl=new JLabel("City:");
		phonel=new JLabel("Phone number:");
		emaill=new JLabel("Email:");
		datel=new JLabel("Date of birth:");
		genderl=new JLabel ("Gender:");
		racel=new JLabel("Race:");
		
		name = new JTextField();
		surname=new JTextField();
		jmbg= new JTextField ();
		adress=new JTextField ();
		city=new JTextField();
		phone=new JTextField();
		email=new JTextField();
		
		String sG[] = {Genders.female.name(),Genders.male.name(),Genders.prefer_not_to_disclose.name()};
		gender=new JComboBox(sG);
		String sR[]= {Race.negroid.name(),Race.australoid.name(),Race.capoid.name(),Race.caucasoid.name(),Race.mongoloid.name()};
		race=new JComboBox(sR);
		race.setEditable(true);
		race.setEnabled(true);
		
		date=new JCalendar();
		
		name.setPreferredSize( new Dimension( 316, 26 ) );
		surname.setPreferredSize( new Dimension( 316, 26 ) );
		jmbg.setPreferredSize( new Dimension( 316, 26 ) );
		adress.setPreferredSize( new Dimension( 316, 26 ) );
		city.setPreferredSize( new Dimension( 316, 26 ) );
		phone.setPreferredSize( new Dimension( 316, 26 ) );
		email.setPreferredSize( new Dimension( 316, 26 ) );
		date.setPreferredSize( new Dimension( 316, 166 ) );
		gender.setPreferredSize( new Dimension( 316, 26 ) );
		race.setPreferredSize( new Dimension( 316, 26 ) );
		
		layout.putConstraint(SpringLayout.WEST, namel,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, namel,
                20,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, surnamel,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, surnamel,
                60,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, jmbgl,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, jmbgl,
                100,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, adressl,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, adressl,
                140,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, cityl,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, cityl,
                180,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, phonel,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, phonel,
                180,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, emaill,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, emaill,
                220,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, racel,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, racel,
                260,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, genderl,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, genderl,
                300,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, datel,
                20,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, datel,
                340,
                SpringLayout.NORTH, dodaj);
		//pozicije text polja
		layout.putConstraint(SpringLayout.WEST, name,
                96,
                SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, name,
		                20,
		                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, surname,
				96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, surname,
		        60,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, jmbg,
				96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, jmbg,
		        100,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, adress,
		        96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, adress,
		        140,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, city,
				96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, city,
		        180,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, phone,
				96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, phone,
		        180,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, email,
				96,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, email,
		        220,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, race,
                126,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, race,
                260,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, gender,
                126,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, gender,
                300,
                SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, date,
                126,
                SpringLayout.WEST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, date,
                340,
                SpringLayout.NORTH, dodaj);
		
		ok=new JButton("OK");
		cnc=new JButton ("Cancel");
		
		layout.putConstraint(SpringLayout.WEST, cnc,
				20,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, cnc,
		        544,
		        SpringLayout.NORTH, dodaj);
		layout.putConstraint(SpringLayout.WEST, ok,
				366,
		        SpringLayout.EAST, dodaj);
		layout.putConstraint(SpringLayout.NORTH, ok,
		        544,
		        SpringLayout.NORTH, dodaj);
		
		dodaj.add(namel);
		dodaj.add(name);
		dodaj.add(surname);
		dodaj.add(surnamel);
		dodaj.add(jmbgl);
		dodaj.add(jmbg);
		dodaj.add(adressl);
		dodaj.add(adress);
		dodaj.add(phonel);
		dodaj.add(phone);
		dodaj.add(emaill);
		dodaj.add(email);
		dodaj.add(racel);
		dodaj.add(race);
		dodaj.add(genderl);
		dodaj.add(gender);
		dodaj.add(datel);
		dodaj.add(date);
		dodaj.add(ok);
		dodaj.add(cnc);
		
		dodaj.setVisible(true);
		dodaj.setDefaultCloseOperation(1);
		
		cnc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodaj.dispose();
				
			}
			
		});
		
		AbstractAction buttonPressed = new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (name.getText().equals("") || surname.getText().equals("")|| jmbg.getText().equals(""))
				{
					dodaj.setVisible(false);

					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Please fill in the necessary fields!", "Error",
							JOptionPane.WARNING_MESSAGE);

					dodaj.setVisible(true);
				}
				else
				{
					Genders g;
					if (gender.getSelectedItem().equals(Genders.male.name()))
					{
						g = Genders.male;
					}
					else if (gender.getSelectedItem().equals(Genders.female.name()))
					{
						g = Genders.female;
					}
					else {
						g=Genders.prefer_not_to_disclose;
					}
					Race r;
					if (race.getSelectedItem().equals(Race.australoid.name())) {r=Race.australoid;}
					else if (race.getSelectedItem().equals(Race.capoid.name())) {r=Race.capoid;}
					else if (race.getSelectedItem().equals(Race.caucasoid.name())) {r=Race.caucasoid;}
					else if (race.getSelectedItem().equals(Race.mongoloid.name())) {r=Race.mongoloid;}
					else {r=Race.negroid;}

					DefaultMutableTreeNode element = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeModel()
							.getRoot();
					System.out.println(g+" "+r.name());

					Patient newP = new Patient(name.getText(), surname.getText(), g,r,jmbg.getText(),adress.getText(), date.getDate(), phone.getText(), email.getText(),city.getText());

					MainFrame.getInstance().getTreeModel().insertNodeInto(new DefaultMutableTreeNode(newP), element,
							element.getChildCount());

					Collections.getInstance().add(newP);

					dodaj.dispose();
				
				}
			}
		};
			
		

		ok.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0), "Enter_pressed");
		ok.getActionMap().put("Enter_pressed", buttonPressed);
		ok.addActionListener(buttonPressed);
		cnc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
}
}
