package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.toedter.calendar.JCalendar;

import controller.PatientViewController;
import enums.Genders;
import enums.Race;
import model.Appointment;
import model.Patient;



public class PatientView extends JPanel{
	private JPanel right, left,top;
	private static boolean allow=false;
	private Genders gender;

	public PatientView(Patient p, Appointment pp)
	{
		this.setLayout(new BorderLayout());
		
		left = new JPanel();
		right = new JPanel();
		top=new JPanel();


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth()/2;
		double height = screenSize.getHeight()/3*2;
		int w, h;
		w = (int) width;
		h = (int) height;

		int rPw = (int) (Math.round(w * 0.49));

		left.setPreferredSize(new Dimension(rPw, h));
		right.setPreferredSize(new Dimension(w, h));
		top.setPreferredSize(new Dimension(w, h/9));

		SpringLayout layout = new SpringLayout();
		left.setLayout(layout);
		right.setLayout(layout);
		top.setLayout(layout);

		JLabel full,namel, surnamel,jmbgl,adressl,cityl,phonel,emaill,datel, genderl,racel;
		JTextField name, surname,jmbg,adress,city,phone,email;
		JComboBox gender,race;
		JCalendar date;
		
		full=new JLabel(p.getFirstName() + " " + p.getLastName());
		full.setFont(new Font("Calibri", Font.BOLD, 26));
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

		name = new JTextField(p.getFirstName());
		surname=new JTextField(p.getLastName());
		jmbg= new JTextField (p.getJmbg());
		adress=new JTextField (p.getAddress());
		city=new JTextField(p.getCity());
		phone=new JTextField(p.getPhoneNumber());
		email=new JTextField(p.getEmail());
		
		String sG[] = {Genders.female.name(),Genders.male.name(),Genders.prefer_not_to_disclose.name()};
		gender=new JComboBox(sG);
		String sR[]= {Race.negroid.name(),Race.australoid.name(),Race.capoid.name(),Race.caucasoid.name(),Race.mongoloid.name()};
		race=new JComboBox(sR);
		gender.setSelectedItem(p.getGender().name());
		race.setSelectedItem(p.getRace().name());
		
		if (allow==false) {
			name.setEditable(false);
			surname.setEditable(false);
			jmbg.setEditable(false);
			adress.setEditable(false);
			city.setEditable(false);
			phone.setEditable(false);
			email.setEditable(false);
			gender.setEditable(false);
			race.setEditable(false);
			gender.disable();
			race.enable(false);
		}
		else {
			name.setEditable(true);
			surname.setEditable(true);
			jmbg.setEditable(true);
			adress.setEditable(true);
			city.setEditable(true);
			phone.setEditable(true);
			email.setEditable(true);
			gender.setEditable(true);
			race.setEditable(true);
		}
		
		date = new JCalendar();

		date.setDate(p.getDateOfBirth());
		date.enableInputMethods(false);
		
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
		
		JButton edit=new JButton ("Edit patient information");
		
		
		layout.putConstraint(SpringLayout.WEST, namel,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, namel,
                20,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, surnamel,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, surnamel,
                60,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, jmbgl,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, jmbgl,
                100,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, adressl,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, adressl,
                140,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, cityl,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, cityl,
                180,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, phonel,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, phonel,
                180,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, emaill,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, emaill,
                220,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, racel,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, racel,
                260,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, genderl,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, genderl,
                300,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, datel,
                20,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, datel,
                340,
                SpringLayout.NORTH, left);
		//pozicije text polja
		layout.putConstraint(SpringLayout.WEST, name,
                126,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, name,
		                20,
		                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, surname,
				126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, surname,
		        60,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, jmbg,
				126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, jmbg,
		        100,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, adress,
		        126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, adress,
		        140,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, city,
				126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, city,
		        180,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, phone,
				126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, phone,
		        180,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, email,
				126,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, email,
		        220,
		        SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, race,
                126,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, race,
                260,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, gender,
                126,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, gender,
                300,
                SpringLayout.NORTH, left);
		layout.putConstraint(SpringLayout.WEST, date,
                126,
                SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, date,
                340,
                SpringLayout.NORTH, left);
		
		layout.putConstraint(SpringLayout.WEST, edit,
				64,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, edit,
		        544,
		        SpringLayout.NORTH, left);
		JButton submit=new JButton("Submit");
		layout.putConstraint(SpringLayout.WEST, submit,
				64,
		        SpringLayout.WEST, left);
		layout.putConstraint(SpringLayout.NORTH, submit,
		        544,
		        SpringLayout.NORTH, left);
		
		
		layout.putConstraint(SpringLayout.WEST, full,
                20,
                SpringLayout.WEST, top);
		layout.putConstraint(SpringLayout.NORTH, full,
                20,
                SpringLayout.NORTH, top);
		
		
		top.add(full);
		left.add(namel);
		left.add(name);
		left.add(surname);
		left.add(surnamel);
		left.add(jmbgl);
		left.add(jmbg);
		left.add(adressl);
		left.add(adress);
		left.add(phonel);
		left.add(phone);
		left.add(emaill);
		left.add(email);
		left.add(racel);
		left.add(race);
		left.add(genderl);
		left.add(gender);
		left.add(datel);
		left.add(date);
		if (allow==false) {
			left.add(edit);
		}
		else {left.add(submit);}
		
		
		AbstractAction buttonPressedEdit = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				allow=true;
				
			}
			
		};
		AbstractAction buttonPressedSubmit = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				allow=false;
				Genders g= Genders.male;
				/*if (gender.getSelectedItem()==Genders.male)
				{
					g = Genders.male;
				}
				else if (gender.getSelectedItem()==Genders.female)
				{
					g = Genders.female;
				}
				else {
					g=Genders.prefer_not_to_disclose;
				}*/
				System.out.println(g.name());
				p.setGender(g);
				System.out.println(p.getGender().name());
				
				Race r;
				if (race.getSelectedItem()==Race.australoid) {r=Race.australoid;}
				else if (race.getSelectedItem()==Race.capoid) {r=Race.capoid;}
				else if (race.getSelectedItem()==Race.caucasoid) {r=Race.caucasoid;}
				else if (race.getSelectedItem()==Race.mongoloid) {r=Race.mongoloid;}
				else {r=Race.negroid;}
				p.setPatient(name.getText(), surname.getText(), g,r,jmbg.getText(),adress.getText(), date.getDate(), phone.getText(), email.getText(),city.getText());
				
			}
			
		};

		edit.addActionListener(buttonPressedEdit);
		edit.addMouseListener(new PatientViewController());
		submit.addActionListener(buttonPressedSubmit);
		submit.addMouseListener(new PatientViewController());
		edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		if (pp != null)//ne radi da ispisuje preglede
		{

			JLabel label = new JLabel();
			label.setFont(new Font("Calibri", Font.BOLD, 30));
			label.setForeground(Color.white);
			label.setVerticalAlignment(JLabel.TOP);
			label.setVerticalTextPosition(JLabel.TOP);
			right.add(label);
		}
		
		
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(top,BorderLayout.NORTH);
		left.setVisible(true);
		right.setVisible(true);
		top.setVisible(true);

	}
	public JPanel getRight()
	{
		return right;
	}

	public void setRight(JPanel right)
	{
		this.right = right;
	}
	public JPanel getLeft()
	{
		return left;
	}

	public void setleft(JPanel left)
	{
		this.left = left;
	}
}
