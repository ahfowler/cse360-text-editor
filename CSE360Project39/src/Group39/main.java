package Group39;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class main {

	public static void main(String[] args) 
	{
		// JFrame
		JFrame f;
		
		// JButton
		JButton impor;
		JButton export;
		JButton quit;
		JButton help;
		
		
		// label to display text
		JLabel l;
		
		// text area
		JTextArea jt;
		JTextArea jt2;
		
		// create a new frame to store text field and button
		f = new JFrame("Text Edit");

		// create a new button
		impor = new JButton("Import");
		export = new JButton("Export");
		quit = new JButton("Quit");
		help = new JButton("Help");
				
		// create a text area, specifying the rows and columns
		jt = new JTextArea(20, 20);
		jt2 = new JTextArea(20, 20);	
		
		JPanel p = new JPanel();
		
		// add the text area and button to panel
		p.add(jt);
		p.add(jt2);
		p.add(impor);
		p.add(export);
		p.add(help);
		p.add(quit);
		
		
		f.add(p);
		// set the size of frame
		f.setSize(300, 300);
		
		f.show();

	}

}
