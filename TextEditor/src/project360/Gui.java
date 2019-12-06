package project360;

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
 *  360 Text Editor - A program that creates a formatted text file given a 
 *  document with user created formatting flags. 
 *  
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

/**
 * Gui Class - Creates a GUI object for the 360 Text Editor application
 */
class Gui extends JFrame implements ActionListener
{
	static String textStr = ""; // hold user text
	static boolean imported = false; // true if a file has been imported
	static TextModifier modedText;

	// Frame Objects
	JFrame frameOne;

	// Text Viewer Objects
	JTextArea topText; // input viewer
	JTextArea bottomText; // output viewer

	/**
	 * Constructor for the Gui class
	 */
	Gui()
	{
		// create frame
		frameOne = new JFrame("360 Text Editor");
		// exits program when window is closed
		frameOne.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		// set GUI theme
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch (Exception e)
		{
		}

		// Create text boxes
		topText = new JTextArea();
		bottomText = new JTextArea();

		topText.setLineWrap(true);
		topText.setWrapStyleWord(true);
		topText.setMargin(new Insets(10, 10, 10, 10));
		topText.setEditable(true);

		JScrollPane scroll = new JScrollPane(topText);

		bottomText.setLineWrap(true);
		bottomText.setWrapStyleWord(true);
		bottomText.setMargin(new Insets(55, 55, 55, 55));
		bottomText.setEditable(false);
		bottomText.setFont(new Font("monospaced", Font.PLAIN, 10));

		JScrollPane scrollb = new JScrollPane(bottomText);

		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollb.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JTextPane panelOne = new JTextPane();
		StyledDocument doc = panelOne.getStyledDocument();

		JTextPane panelTwo = new JTextPane();
		StyledDocument doc2 = panelOne.getStyledDocument();

		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

		SimpleAttributeSet right = new SimpleAttributeSet();
		StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

		SimpleAttributeSet left = new SimpleAttributeSet();
		StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);

		panelOne.setMargin(new Insets(10, 10, 10, 10));

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
		JMenuItem gHelp = new JMenuItem("Formatting Guide");
		JMenuItem eHelp = new JMenuItem("Error Guide");
		JMenuItem tHelp = new JMenuItem("How To");

		fImport.addActionListener(this);
		fExport.addActionListener(this);
		rClear.addActionListener(this);
		rProcess.addActionListener(this);
		hHelp.addActionListener(this);
		gHelp.addActionListener(this);
		eHelp.addActionListener(this);
		tHelp.addActionListener(this);

		fileOpt.add(fImport);
		fileOpt.add(fExport);
		runOpt.add(rClear);
		runOpt.add(rProcess);
		helpOpt.add(hHelp);
		helpOpt.add(gHelp);
		helpOpt.add(eHelp);
		helpOpt.add(tHelp);

		// Controls and sets frame formatting
		frameOne.setJMenuBar(menuBar);

		panel.add(scroll);
		// panel.add(panelOne);

		panel.add(scrollb);
		// panel.add(panelTwo);

		frameOne.add(panel);

		frameOne.setSize(635, 700);
		frameOne.setLocationRelativeTo(null);

		frameOne.show();

		JOptionPane.showMessageDialog(frameOne,
				"Hello!\n" + "Please import a valid text file to get started.\n"
						+ "For further assistance, click 'Help'");
	}

	/**
	 * Used when any of the following menu action occurs: Export, Import,
	 * Process, Flag Guide, Clear. Interacts with the ActionListener class
	 * 
	 * @param event the event to be processed
	 */
	public void actionPerformed(ActionEvent event)
	{
		String select = event.getActionCommand();

		if (select.equals("Export"))
		{

			// Create file selection object
			JFileChooser selectExp = new JFileChooser("f:");
			selectExp.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int saveE = selectExp.showSaveDialog(null);

			if (saveE == JFileChooser.APPROVE_OPTION)
			{

				File label = new File(
						selectExp.getSelectedFile().getAbsolutePath()
								+ "/FormattedText.txt");
				File error = new File(
						selectExp.getSelectedFile().getAbsolutePath()
								+ "/ErrorLog.txt");

				try
				{
					// write files
					label.createNewFile();
					FileWriter writer = new FileWriter(label, false);
					BufferedWriter wfile = new BufferedWriter(writer);

					wfile.write(bottomText.getText());
					wfile.flush();
					wfile.close();

					error.createNewFile();
					writer = new FileWriter(error, false);
					wfile = new BufferedWriter(writer);

					wfile.write(modedText.getErrorLog());
					wfile.flush();
					wfile.close();
				} catch (Exception evt)
				{
					JOptionPane.showMessageDialog(frameOne, evt.getMessage());
				}
			} else
				// cancel option text
				JOptionPane.showMessageDialog(frameOne,
						"A file was not exported");
		} else if (select.equals("Import"))
		{
			JFileChooser selectImp = new JFileChooser("f:");

			int saveI = selectImp.showOpenDialog(null);

			// if a file is selected
			if (saveI == JFileChooser.APPROVE_OPTION)
			{
				// obtain file path
				File fileIn = new File(
						selectImp.getSelectedFile().getAbsolutePath());

				try
				{
					FileReader fRead = new FileReader(fileIn);
					BufferedReader bRead = new BufferedReader(fRead);

					// obtain file name input
					textStr = bRead.readLine();
					String str1 = "";

					while ((str1 = bRead.readLine()) != null)
					{
						textStr = textStr + "\n" + str1;
					}
					// display top text
					topText.setText(textStr);
					fRead.close();
					bRead.close();
				} catch (Exception evt)
				{
					JOptionPane.showMessageDialog(frameOne, evt.getMessage());
				}
				imported = true;

			} else
				JOptionPane.showMessageDialog(frameOne,
						"A file was not imported");
		} else if (select.equals("Process"))
		{
			// if a file is selected
			if (imported == true || topText.getText() != "")
			{
				// formats the output text and displays it in bottom window
				modedText = new TextModifier(topText.getText());
				modedText.formatString(textStr);
				bottomText.setText(modedText.getFormattedString());
				JOptionPane.showMessageDialog(frameOne, "File Processed");
			} else
			{
				JOptionPane.showMessageDialog(frameOne,
						"Please import a file to process");
			}
		} else if (select.equals("Clear"))
		{
			topText.setText("");
			bottomText.setText("");
			imported = false;
			textStr = "";
		} else if (select.equals("Flag Guide"))
		{
			JOptionPane.showMessageDialog(frameOne, "Flag Guide\n"
					+ "'-r' right-justified text\n" + "'-c' center text\n"
					+ "'-l' left-justified text\n" + "'-t' title\n"
					+ "'-d' double line spacing\n"
					+ "'-s' single line spacing\n" + "'-i' indented text\n"
					+ "'-b' block text\n" + "'-2' two columns text\n"
					+ "'-1' one column text\n" + "'-e' blank line\n");

		} else if (select.equals("Error Guide"))
		{
			JOptionPane.showMessageDialog(frameOne, "Error Guide\n\n"
					+ "If an error has occured in the program,\nan error log "
					+ "will be saved " + "along side\nyour exported file.\n\n"
					+ "Error Conditions:\n"
					+ "An invalid flag. ex. -5\nA blank line");

		} else if (select.equals("Formatting Guide"))
		{
			JOptionPane.showMessageDialog(frameOne, "Formatting Guide\n\n"
					+ "-To format your text, place a command flag on the line\n"
					+ "or lines directly above the text you wish to edit.\n\n"
					+ "-Multiple flags may be used on a single line of text,\n"
					+ "but each flag needs to be on its own line.\n\n"
					+ "-If two flags with conflicting instructions are listed \n"
					+ "for a single section of text, the second flag will be s"
					+ "elected.\n\n"
					+ "-Ensure that there are no blank lines in your file.\n\n"
					+ "-Certain commands should not be used together on\n"
					+ "the same line of text. For example '-2' and '-1' should\n"
					+ "never be applied to the same line. The same conditions\n"
					+ "apply to the line spacing commands 's' and 'd'. Use one\n"
					+ "but not both on any given section of text.\n"
					+ "\nFormatting Example:\n" + "----------------\n" + "-c\n"
					+ "-i\n"
					+ "Lorem Impsum Lorem ipsum dolor sit amet, consectetuer\n"
					+ "adipiscing elit Lorem ipsum dolor sit amet");
		} else if (select.equals("How To"))
		{
			JOptionPane.showMessageDialog(frameOne, "How To:\n\n"
					+ "To use the 360 Text Editor, start by importing a\n"
					+ "properly formatted text file. This is done in the\n"
					+ "file menu. You may view and edit the imported\n"
					+ "text in the top viewer window. If you are happy\n"
					+ "with your import you may choose to process the\n"
					+ "file. Processing will allow you to preview the\n"
					+ "‘export text’. After which, you may choose to\n"
					+ "re-edit your imported file and process again, or\n"
					+ "export to a .txt file. If you choose to export, you\n"
					+ "need only select export in the file menu. A file\n"
					+ "of your formatted text will be saved in a\n"
					+ "location of your choosing. Any encountered\n"
					+ "errors will be saved in an error log at that\n"
					+ "same location.");
		}
	}
}
