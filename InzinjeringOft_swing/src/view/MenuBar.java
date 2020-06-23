package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JMenuItem save;
	public JMenuItem open;
	public JMenuItem redo;
	public JMenuItem undo;
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(218, 242, 241));
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
	
	public MenuBar () {
	
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		
		save = new JMenuItem("Save");
		open = new JMenuItem ("Open");
		file.add(save);
		file.add(open);
		save.setBackground(new Color(218, 242, 241));
		open.setBackground(new Color(218, 242, 241));
		
		undo = new JMenuItem ("Undo");
		redo = new JMenuItem ("Redo");
		edit.add(undo);
		edit.add(redo);
		undo.setBackground(new Color(218, 242, 241));
		redo.setBackground(new Color(218, 242, 241));
		
		add(file);
		add(edit);
		
		JMenu help = new JMenu ("Help");
		add(Box.createGlue());
		add(help);
		
		
		
		
	}
	

}
