import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*;

import java.awt.event.*;

import javax.swing.plaf.metal.*;

import javax.swing.text.*;

class TextEditor extends JFrame {

	// Text component

	JTextArea t;
	JTextPane p;

	// Frame

	JFrame f;

	// Constructor

	TextEditor()

	{

		// Create a frame

		f = new JFrame();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(2,1,5,5));

		try {

			// Set metl look and feel

			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// Set theme to ocean

			MetalLookAndFeel.setCurrentTheme(new OceanTheme());

		}

		catch (Exception e) {

		}

		// Text component

		t = new JTextArea();

		t.setText("-r\n"
				+ "This is a right-justified sentence.\n"
				+ "-c\n"
				+ "This is a centered sentence.\n"
				+ "-l\n"
				+ "This is a left justified sentence.\n"
				+ "-t\n"
				+ "This is a title.\n"
				+ "-d\n"
				+ "-s\n"
				+ "-i\n"
				+ "-b\n"
				+ "-2\n"
				+ "-1\n"
				+ "-e\n");

		t.setLineWrap(true);

		t.setWrapStyleWord(true);

		t.setMargin(new Insets(10, 10, 10, 10));

		t.setEditable(true);

		JScrollPane scroll = new JScrollPane(t);

		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		 JTextPane p = new JTextPane();
	        StyledDocument doc = p.getStyledDocument();

	        SimpleAttributeSet center = new SimpleAttributeSet();
	        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

	        SimpleAttributeSet right = new SimpleAttributeSet();
	        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
	        
	        SimpleAttributeSet left = new SimpleAttributeSet();
	        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);

	        try
	        {
//	            doc.insertString(doc.getLength(), "Title\n\n", center);
//	            doc.setParagraphAttributes(0, doc.getLength(), center, false);
	            
//	            int currentLength = doc.getLength();
//	            
//	            doc.insertString(doc.getLength(), "Gen Z has finally snapped over climate change and financial inequality.\n\n", right);
//	            doc.setParagraphAttributes(currentLength, doc.getLength(), right, false);
//	            
//	            currentLength = doc.getLength();
//	            
//	            doc.insertString(doc.getLength(), "In a viral audio clip on TikTok, a white-haired man in a baseball cap and polo shirt declares, “The millennials and Generation Z have the Peter Pan syndrome, they don’t ever want to grow up.” Thousands of teens have responded through remixed reaction videos and art projects with a simple phrase: “ok boomer.” “Ok boomer” has become Generation Z’s endlessly repeated retort to the problem of older people who just don’t get it, a rallying cry for millions of fed up kids. Teenagers use it to reply to cringey YouTube videos, Donald Trump tweets, and basically any person over 30 who says something condescending about young people — and the issues that matter to them.\n", right);
//	            doc.setParagraphAttributes(currentLength, doc.getLength(), left, false);
	        }
	        catch(Exception e) {}
	        
	        p.setMargin(new Insets(10,10,10,10));
	        //p.setBounds(10, 320, 580, 300);
		
		

		// Create a menubar

		JMenuBar mb = new JMenuBar();

		// Create a menu for menu

		JMenu m1 = new JMenu("File");
		JMenu m2 = new JMenu("Run");

		// Create menu items

		JMenuItem mi1 = new JMenuItem("Import File");

		JMenuItem mi2 = new JMenuItem("Export File");
		
		JMenuItem m2p = new JMenuItem("Process");
		JMenuItem m2c = new JMenuItem("Clear");
		
		JMenuItem help = new JMenuItem("Help");

		// Add action listener

//		mi1.addActionListener(this);
//
//		mi2.addActionListener(this);

		m1.add(mi1);

		m1.add(mi2);
		
		m2.add(m2p);
		m2.add(m2c);

		mb.add(m1);
		mb.add(m2);
		mb.add(help);

		f.setJMenuBar(mb);
		
		panel.add(scroll);
		
        panel.add(p);
        
        f.add(panel);
        
		f.setSize(600, 700);
		f.setLocationRelativeTo(null);

		f.show();
		
		JOptionPane.showMessageDialog(f, "Hello!\n"
				+ "Please import a valid text file to get started.\n"
				+ "For further assistance, click 'Help'");
		
//		JOptionPane.showMessageDialog(f,
//			    "Invalid command found.\n"
//			    + "Unable to import file.\n"
//			    + "Please refer to 'Help' for valid commands.",
//			    "File Error",
//			    JOptionPane.ERROR_MESSAGE);

	}

//	// If a button is pressed
//
//	public void actionPerformed(ActionEvent e)
//
//	{
//
//		String s = e.getActionCommand();
//
//		if (s.equals("cut")) {
//
//			t.cut();
//
//		}
//
//		else if (s.equals("copy")) {
//
//			t.copy();
//
//		}
//
//		else if (s.equals("paste")) {
//
//			t.paste();
//
//		}
//
//		else if (s.equals("Save")) {
//
//			// Create an object of JFileChooser class
//
//			JFileChooser j = new JFileChooser("f:");
//
//			// Invoke the showsSaveDialog function to show the save dialog
//
//			int r = j.showSaveDialog(null);
//
//			if (r == JFileChooser.APPROVE_OPTION) {
//
//				// Set the label to the path of the selected directory
//
//				File fi = new File(j.getSelectedFile().getAbsolutePath());
//
//				try {
//
//					// Create a file writer
//
//					FileWriter wr = new FileWriter(fi, false);
//
//					// Create buffered writer to write
//
//					BufferedWriter w = new BufferedWriter(wr);
//
//					// Write
//
//					w.write(t.getText());
//
//					w.flush();
//
//					w.close();
//
//				}
//
//				catch (Exception evt) {
//
//					JOptionPane.showMessageDialog(f, evt.getMessage());
//
//				}
//
//			}
//
//			// If the user cancelled the operation
//
//			else
//
//				JOptionPane.showMessageDialog(f, "the user cancelled the operation");
//
//		}
//
//		else if (s.equals("Print")) {
//
//			try {
//
//				// print the file
//
//				t.print();
//
//			}
//
//			catch (Exception evt) {
//
//				JOptionPane.showMessageDialog(f, evt.getMessage());
//
//			}
//
//		}
//
//		else if (s.equals("Open")) {
//
//			// Create an object of JFileChooser class
//
//			JFileChooser j = new JFileChooser("f:");
//
//			// Invoke the showsOpenDialog function to show the save dialog
//
//			int r = j.showOpenDialog(null);
//
//			// If the user selects a file
//
//			if (r == JFileChooser.APPROVE_OPTION) {
//
//				// Set the label to the path of the selected directory
//
//				File fi = new File(j.getSelectedFile().getAbsolutePath());
//
//				try {
//
//					// String
//
//					String s1 = "", sl = "";
//
//					// File reader
//
//					FileReader fr = new FileReader(fi);
//
//					// Buffered reader
//
//					BufferedReader br = new BufferedReader(fr);
//
//					// Initilize sl
//
//					sl = br.readLine();
//
//					// Take the input from the file
//
//					while ((s1 = br.readLine()) != null) {
//
//						sl = sl + "\n" + s1;
//
//					}
//
//					// Set the text
//
//					t.setText(sl);
//
//				}
//
//				catch (Exception evt) {
//
//					JOptionPane.showMessageDialog(f, evt.getMessage());
//
//				}
//
//			}
//
//			// If the user cancelled the operation
//
//			else
//
//				JOptionPane.showMessageDialog(f, "the user cancelled the operation");
//
//		}
//
//		else if (s.equals("New")) {
//
//			t.setText("");
//
//		}
//
//		else if (s.equals("close")) {
//
//			f.setVisible(false);
//
//		}
//
//	}

	// Main class

	public static void main(String args[])

	{

		TextEditor e = new TextEditor();

	}

}