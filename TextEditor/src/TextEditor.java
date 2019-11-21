import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import java.io.*;

import java.awt.event.*;

import javax.swing.plaf.metal.*;

import javax.swing.text.*;

class TextEditor extends JFrame {

	// Text component

	JTextArea t;
	JTextArea p;

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
				+ "-l\n"
				+ "-d\n"
				+ "Hopefully, this sentence will be long enough to demonstrate that when text exceeds a line in the file, that the next line will be blank to simulate double spacing.\n"
				+ "-s\n"
				+ "This sentence should show that the spacing has defaulted back to single space. There should be no breaks between these lines.\n"
				+ "-i\n"
				+ "This sentence should be indented.\n"
				+ "-b\n"
				+ "This is an example of a block of text. Not only are there 10 spaces preceeding each line of text, but there is actually no breaks in between words.\n"
				+ "-2\n"
				+ "This is going to be the hardest to code! I don't even know how to fake a solution to this one.\n"
				+ "-1\n"
				+ "Yay! It's finally back to normal where everything is nice and has one column.\n"
				+ "-e\n");

		t.setLineWrap(true);

		t.setWrapStyleWord(true);

		t.setMargin(new Insets(10, 10, 10, 10));

		t.setEditable(true);

		JScrollPane topScroll = new JScrollPane(t);
		topScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		JTextArea p = new JTextArea();
		Font font = new Font( "Monospaced", Font.PLAIN, 12 );
		p.setFont(font);
		p.setText("                                             This is a right-justified sentence.\n"
				+ "This          is                 a              centered               sentence.\n"
				+ "This is a left justified sentence.\n"
				+ "                                This is a title.                                \n"
				+ "Hopefully, this sentence will be long enough to demonstrate that when text\n\nexceeds a line in the file, that the next line will be blank to simulate double\n\nspacing.\n"
				+ "This sentence should show that the spacing has defaulted back to single space.\nThere should be no breaks between these lines.\n"
				+ "     This sentence should be indented.\n"
				+ "          This is an example of a block of text. Not only are there 10 spaces\n          preceeding each line of text, but there is actually no breaks in\n          between words.\n"
				+ "This is going to be the hardest to          a solution to this one.\ncode! I don't even know how to fake          \n"
				+ "Yay! It's finally back to normal where everything is nice and has one column.\n"
				+ "\n");

//		p.setLineWrap(true);
//		p.setWrapStyleWord(true);
		p.setMargin(new Insets(10, 10, 10, 10));
		p.setEditable(false);
	    p.setMargin(new Insets(10,10,10,10));
	    
	    JScrollPane bottomScroll = new JScrollPane(p);		
		

		// Create a menubar

		JMenuBar mb = new JMenuBar();

		// Create a menu for menu

		JMenu m1 = new JMenu("File");
		JMenu m2 = new JMenu("Run");

		// Create menu items

		JMenuItem mi1 = new JMenuItem("Import File");

		JMenuItem mi2 = new JMenuItem("Export File");
		
		JMenuItem m2p = new JMenuItem("Process File");
		JMenuItem m2c = new JMenuItem("Clear File");
		JMenuItem m2e = new JMenuItem("Print Error Log");
		
		JMenuItem help = new JMenuItem("Help");

		// Add action listener

//		mi1.addActionListener(this);
//
//		mi2.addActionListener(this);

		m1.add(mi1);

		m1.add(mi2);
		
		m2.add(m2p);
		m2.add(m2c);
		m2.add(m2e);

		mb.add(m1);
		mb.add(m2);
		mb.add(help);

		f.setJMenuBar(mb);
		
		panel.add(topScroll);
		
        panel.add(bottomScroll);
        
        f.add(panel);
        
		f.setSize(620, 700);
		f.setLocationRelativeTo(null);

		f.show();
		
//		JOptionPane.showMessageDialog(f, "Hello!\n"
//				+ "Please import a valid text file to get started.\n"
//				+ "For further assistance, click 'Help'");
//		
//		JOptionPane.showMessageDialog(f,
//			    "Invalid command found.\n"
//			    + "Unable to import file.\n"
//			    + "Please refer to 'Help' for valid commands.",
//			    "File Error",
//			    JOptionPane.ERROR_MESSAGE);
		
//		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		int r = j.showOpenDialog(null);
		
		JOptionPane.showMessageDialog(f,
			    "Command Manual\n\n"
			    + "-l | Justify text to the left.\n"
			    + "-r | Justify text to the right.\n"
			    + "-c | Justify text to the left and right.\n"
			    + "-t | Align text to the center, no justification.\n"
			    + "-d | Change line spacing to double.\n"
			    + "-s | Change line spacing to single.\n"
			    + "-i | Add indents to text. (Forces left justification)\n"
			    + "-b | Make texts in blocks. (Forces left justification)\n"
			    + "-2 | Make texts in two columns. (Not indented)\n"
			    + "-1 | Make texts in one column. (Not indented)\n"
			    + "-e | Blank line.\n",
			    "Help",
			    JOptionPane.PLAIN_MESSAGE);

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