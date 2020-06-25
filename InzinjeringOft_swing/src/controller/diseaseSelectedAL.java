package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import view.MainFrame;


public class diseaseSelectedAL implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		

		if (e.getClickCount() == 1)
		{

			ArrayList<String> lista = MainFrame.getInstance().getData().getDiseaseSimptomes(MainFrame.getInstance().getPdp().getDiseases().getSelectedValue());

			ArrayList<String> selectedSymptoms = new ArrayList<>();

			DefaultListModel<String> dLm = MainFrame.getInstance().getPsp().getSelectedSymptoms();

			for (int i = 0; i < dLm.getSize(); i++)
			{
				selectedSymptoms.add(dLm.getElementAt(i));
			}
			//System.out.println(selectedSymptoms + "  slektovai simptomi");--radi
			

			lista.removeAll(selectedSymptoms);

			MainFrame.getInstance().getPdp().getExtraSymptoms().clear();

			for (String s : lista)
			{
				MainFrame.getInstance().getPdp().getExtraSymptoms().addElement(s);
			}

			MainFrame.getInstance().getPdp().setSelectedDisease(MainFrame.getInstance().getPdp().getDiseases().getSelectedValue());

			MainFrame.getInstance().getPdp().getOk().setEnabled(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
