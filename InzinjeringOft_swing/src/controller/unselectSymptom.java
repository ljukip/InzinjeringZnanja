package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.MainFrame;


public class unselectSymptom implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2)
		{
			int selectedOption = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to remove the symptom?", 
                    "Unselect", 
                    JOptionPane.YES_NO_OPTION); 
				if (selectedOption == JOptionPane.YES_OPTION) {
					//selektovanu vrednost iz liste selektovanih simptoma saljemo da se ukloni
					MainFrame.getInstance().getPsp().removeSelectedSymptom(MainFrame.getInstance().getPsp().getListSelectedSymptoms().getSelectedValue());

				}
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
