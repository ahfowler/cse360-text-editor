/**
 *  @author Azaria Fowler
 *  @author Taylor Gordon  
 *  @author Laura Karp
 *  @author Liang Wang
 *  
 *	Class ID: 70642 - CSE 360 - Wednesday 
 *  Team Number: 39
 *  Group Project 
 * 
 *  [Insert Description here] 
 *  
 *  @version 1.0 November 22, 2019
 **/

import java.awt.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 
class TextEditor extends JFrame implements ActionListener { 

	// Frame Object
	JFrame frameOne; 

	// Text Viewer Objects 
	JTextArea topText; //input viewer
	JTextArea bottomText;  //output viewer 

	/**
	 * Constructor for the editor class 
	 */
	TextEditor() 
	{ 
		//create frame
		frameOne = new JFrame("360 Text Editor"); 
		//exits program when window is closed
		frameOne.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(2,1,5,5));


		//set GUI theme
		try 
		{ 
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
			MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
		} 
		catch (Exception e) 
		{ 
		} 

		// Create text boxes 
		topText = new JTextArea(); 
		bottomText = new JTextArea();

		topText.setLineWrap(true);

		topText.setWrapStyleWord(true);

		topText.setMargin(new Insets(10, 10, 10, 10));

		topText.setEditable(false);

		JScrollPane scroll = new JScrollPane(topText);

		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JTextPane panelOne = new JTextPane();
		StyledDocument doc = panelOne.getStyledDocument();

		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

		SimpleAttributeSet right = new SimpleAttributeSet();
		StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

		SimpleAttributeSet left = new SimpleAttributeSet();
		StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);

//		try
//		{
//			
//		}
//		catch(Exception e) 
//		{
//			
//		}
		
		panelOne.setMargin(new Insets(10,10,10,10));
		//p.setBounds(10, 320, 580, 300);

		// Create a menu bar 
		JMenuBar menuBar = new JMenuBar();

		// Create a menu bar options option 
		JMenu fileOpt = new JMenu("File"); 
		JMenu runOpt = new JMenu("Run"); 
		JMenu helpOpt = new JMenu("Help"); 

		menuBar.add(fileOpt); 
		menuBar.add(runOpt); 
		menuBar.add(helpOpt); 

		// Create menu items 
		JMenuItem fImport = new JMenuItem("Import"); 
		JMenuItem fExport = new JMenuItem("Export"); 
		JMenuItem rClear = new JMenuItem("Clear");
		JMenuItem rProcess = new JMenuItem("Process");
		JMenuItem hHelp = new JMenuItem("Flag Guide");

		fImport.addActionListener(this); 
		fExport.addActionListener(this); 
		rClear.addActionListener(this); 
		rProcess.addActionListener(this); 
		hHelp.addActionListener(this); 

		fileOpt.add(fImport); 
		fileOpt.add(fExport); 
		runOpt.add(rClear);
		runOpt.add(rProcess);
		helpOpt.add(hHelp);

		
		// Controls and sets frame formatting 
		frameOne.setJMenuBar(menuBar);

		panel.add(scroll);

		panel.add(panelOne);

		frameOne.add(panel);

		frameOne.setSize(600, 700);
		frameOne.setLocationRelativeTo(null);

		frameOne.show();

		JOptionPane.showMessageDialog(frameOne, "Hello!\n"
				+ "Please import a valid text file to get started.\n"
				+ "For further assistance, click 'Help'");

	} 

	/**
	 * Invoked when an action occurs. Interacts with the ActionListener class
	 * @param event the event to be processed
	 */
	public void actionPerformed(ActionEvent event) 
	{ 
		String select = event.getActionCommand(); 

		if (select.equals("Export")) 
		{ 

			//Create file selection object 
			JFileChooser selectExp = new JFileChooser("f:"); 

			int saveE = selectExp.showSaveDialog(null); 

			if (saveE == JFileChooser.APPROVE_OPTION) 
			{ 

				File label = new File(selectExp.getSelectedFile().
						getAbsolutePath()); 

				try 
				{ 
					//write files 
					FileWriter writer = new FileWriter(label, false); 
					BufferedWriter wfile = new BufferedWriter(writer); 

					wfile.write(topText.getText()); 
					wfile.flush(); 
					wfile.close(); 
				} 
				catch (Exception evt) 
				{ 
					JOptionPane.showMessageDialog(frameOne, evt.getMessage()); 
				} 
			} 
			else
				//cancel option text 
				JOptionPane.showMessageDialog(frameOne, 
						"A file was not exported"); 
		} 
		else if (select.equals("Import")) 
		{ 
			JFileChooser selectImp = new JFileChooser("f:"); 

			int saveI = selectImp.showOpenDialog(null); 

			//if a file is selected 
			if (saveI == JFileChooser.APPROVE_OPTION) 
			{ 	
				//obtain file path 
				File fileIn = new File(selectImp.getSelectedFile().getAbsolutePath()); 

				try { 
					FileReader fRead = new FileReader(fileIn); 
					BufferedReader bread = new BufferedReader(fRead); 

					//obtain file name input 
					String nameStr = bread.readLine(); 
					String str1 = "";

					while ((str1 = bread.readLine()) != null) 
					{ 
						nameStr = nameStr + "\n" + str1; 
					} 
					//set name 
					topText.setText(nameStr); 
				} 
				catch (Exception evt) 
				{ 
					JOptionPane.showMessageDialog(frameOne, evt.getMessage()); 
				} 
			} 
			else
				JOptionPane.showMessageDialog(frameOne, "A file was not imported"); 
		} 
		else if (select.equals("Clear")) { 
			topText.setText(""); 
		} 
	} 

	// Main class 
	public static void main(String args[]) 
	{ 
		TextEditor editor = new TextEditor(); 
	} 
} 
