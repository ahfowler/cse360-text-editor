package project360;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Azaria Fowler
 * @author Taylor Gordon
 * @author Laura Karp
 * @author Liang Wang
 * 
 * Class ID: 70642 - CSE 360 - Wednesday Team Number: 39 Group Project
 *
 * 360 Text Editor - A program that creates a formatted text file given
 * a document with user created formatting flags.
 * 
 * @version 1.0 November 22, 2019
 **/

/**
 * TextModifier - A class of functions used to edit text given the proper flag.
 */
public class TextModifier
{
	private String rawText;
	private String formattedString;
	private String errorLog;

	private Queue<Character> commandQueue;

	/**
	 * Constructor for the TextModifier class
	 * 
	 * @param text a string of user text
	 */
	TextModifier(String text)
	{
		rawText = text;
		formattedString = "";
		errorLog = "Error Log:\n";
		commandQueue = new LinkedList<>();
	}

	/**
	 * returnSpaces() returns a series of spaces
	 * 
	 * @param count The number of spaces needed.
	 * @return String - A string of whitespace.
	 */
	String returnSpaces(int count)
	{
		String spaces = "";

		for (int i = 0; i < count; i++)
		{
			spaces += " ";
		}

		return spaces;
	}

	/**
	 * leftText() - Left justifies a given string of text
	 * 
	 * @param line A string of text
	 * @return String - Left justified 'line' text
	 */
	String leftText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80)
		{
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ')
			{
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++)
				{
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = leftText(newLine);
			String nextLine = leftText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else
		{
			int numOfSpaces = 80 - line.length();
			String newLine = line;
			newLine += returnSpaces(numOfSpaces);
			return newLine + "\n";
		}
	}

	/**
	 * rightText() - Right justifies a given string of text
	 * 
	 * @param line A string of text
	 * @return String - Right justified 'line' text
	 */
	String rightText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80)
		{
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ')
			{
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++)
				{
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = rightText(newLine);
			String nextLine = rightText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else
		{
			int numOfSpaces = 80 - line.length();
			String newLine = returnSpaces(numOfSpaces);
			newLine += line;
			return newLine + "\n";
		}
	}

	/**
	 * centerText() - Center justifies a given string of text
	 * 
	 * @param line A string of text.
	 * @return String - Center justified 'line' text.
	 */
	String centerText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");
		if (line.length() > 80)
		{

			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ')
			{
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++)
				{
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = centerText(newLine);
			String nextLine = centerText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else
		{
			String[] words = line.split(" ");
			if (words.length > 1)
			{
				String lastWord = words[words.length - 1];

				int numOfSpaces = 80 - line.length();
				int spacesPerWord = numOfSpaces / (words.length - 1) + 1;
				int remainingSpaces = line.length()
						+ spacesPerWord * (words.length - 1) - words.length;

				if (remainingSpaces < 80)
				{
					remainingSpaces = 80 - remainingSpaces - 1;
				} else
				{
					remainingSpaces = 0;
				}

				String newLine = "";

				for (int i = 0; i < words.length - 1; i++)
				{
					newLine += words[i] + returnSpaces(spacesPerWord);
					if (i == words.length / 2)
					{
						newLine += returnSpaces(remainingSpaces);
					}
				}
				newLine += lastWord;
				return newLine + "\n";
			} else
			{
				return leftText(line);
			}
		}
	}

	/**
	 * titleText() - Centers a string, creating a title
	 * 
	 * @param line A string of text.
	 * @return String - A centered title.
	 */
	String titleText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80)
		{

			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ')
			{
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++)
				{
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = titleText(newLine);
			String nextLine = titleText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else
		{
			int numOfSpaces = 80 - line.length();
			String newLine = returnSpaces(numOfSpaces / 2);
			newLine += line;
			newLine += returnSpaces(numOfSpaces / 2);

			if (newLine.length() < 80)
			{
				newLine += " ";
			}

			return newLine + "\n";

		}
	}

	/**
	 * doubleText() - Double spaces lines of text
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, double-spaced.
	 */
	String doubleText(String line)
	{
		// lines will always have 81 characters (including the new line)
		if (line.length() > 81)
		{ // There is another line
			String newLine = doubleText(line.substring(0, 81));
			String nextLine = doubleText(line.substring(81));
			return newLine + nextLine;
		} else
		{
			return line + "\n";
		}
	}

	/**
	 * singleText() - Single spaces lines of text
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, single-spaced.
	 */
	String singleText(String line)
	{
		// lines will always have 81 characters (including the new line)
		if (line.length() > 81)
		{ // There is another line
			String newLine = doubleText(line.substring(0, 81));
			String nextLine = doubleText(line.substring(81));
			return newLine + nextLine;
		} else
		{
			return line;
		}
	}

	/**
	 * indentText() - Indents the first line of given text.
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, with the first line indented.
	 */
	String indentText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");
		if (line.length() > 75)
		{
			int split = 75;
			char spltWords = line.charAt(split);

			// prevent mid word splitting
			if (spltWords != ' ')
			{
				while (spltWords != ' ' && split > -1)
				{
					--split;
					spltWords = line.charAt(split);

				}
			}

			String iLine = line.substring(0, split); // line to be indented

			iLine = returnSpaces(5) + iLine;
			line = leftText(line.substring(split + 1));
			line = iLine + "\n" + line;
		} else
		{
			line = returnSpaces(5) + line;
		}

		return line;
	}

	/**
	 * blockText - Creates a block of text.
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, blocked (10 spaces).
	 */
	String blockText(String line)
	{
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 70)
		{
			int split = 70;
			char spltWords = line.charAt(split);

			// prevent mid word splitting
			if (spltWords != ' ')
			{
				while (spltWords != ' ' && split > -1)
				{
					--split;
					spltWords = line.charAt(split);
				}
			}

			String iLine = line.substring(0, split);

			return returnSpaces(10) + iLine + "\n"
					+ blockText(line.substring(split + 1));
		} else
		{
			line = returnSpaces(10) + line;
		}
		return line + "\n";
	}

	/**
	 * twoColumn - Creates two columns from given text.
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, in two columns.
	 */
	String twoColumn(String text) {
		int middle = text.length() / 2;
		int before = text.lastIndexOf(' ', middle);
		int after = text.indexOf(' ', (middle + 1));
		
		if (before == -1 || (after != -1 && middle - before >= after - middle)) {
		    middle = after;
		} else {
		    middle = before;
		}		

		String firstHalf = text.substring(0, (int) middle);
		String secondHalf = text.substring((int) (middle + 1));
	
		String words1[] = firstHalf.split("\\s");
		//System.out.println(words1[words1.length-1]);
		
		ArrayList<String> lines1 = new ArrayList<String>();
		
		int len = 0;
		String line = "";
		for (int i=0; i< words1.length; i++) {
			if (len + words1[i].length() > 35) {
				line = line.trim(); // line.substring(0, line.length()-1);
				lines1.add(line);
				len = 0;
				line = "";
			}
			line += words1[i] + " ";
			len += words1[i].length() + 1;
		}
		lines1.add(line);
		
		String words2[] = secondHalf.split("\\s");
		
		ArrayList<String> lines2 = new ArrayList<String>();
		len = 0;
		line = "";
		
		for (int i=0; i< words2.length; i++) {
			if (len + words2[i].length() > 35) {
				line = line.trim(); // line.substring(0, line.length()-1);
				lines2.add(line);
				len = 0;
				line = "";
			}
			line += words2[i] + " ";
			len += words2[i].length() + 1;
		}
		lines2.add(line);

		int i, j;
		String output = "";
		for (i=0, j=0; i<lines1.size() && j<lines2.size(); i++, j++) {
			output += String.format("%-35s          %-35s\n", lines1.get(i), lines2.get(j));
		}
		
		while (i != lines1.size()) {
			output += lines1.get(i++) + "\n";
			
			while (j != lines2.size()) {
				// 45 spaces
				output += returnSpaces(45) + lines2.get(j++) + "\n";
			}
		}

		return output;	
	}

	/**
	 * oneColumn - Creates one column of given text.
	 * 
	 * @param line A string of text.
	 * @return String - Lines of text, in one columns.
	 */
	String oneColumn(String line)
	{
		return leftText(line);
	}
	
	/**
	 * envokeCommand() - An internal menu used to select a formatting option
	 * from a given flag value.
	 * 
	 * @param command A character command of text.
	 * @param line    A String of text.
	 * @return String - Lines of formatted text.
	 */
	String envokeCommand(char command, String line)
	{
		switch (command)
		{
		case 'l': // left justified
			return leftText(line);
		case 'r': // right justified
			return rightText(line);
		case 'c': // justified
			return centerText(line);
		case 't': // title
			return titleText(line);
		case 'd': // double spaced lines
			return doubleText(line);
		case 's': // single spaced lines
			return singleText(line);
		case 'i': // indented first line
			return indentText(line);
		case 'b': // block text
			return blockText(line);
		case '2':
			return twoColumn(line);
		case '1':
			return oneColumn(line);
		default:
			errorLog += "-" + command + " is not a valid command.\n";
			return line;
		}
	}

	/**
	 * formatString() - separates flag commands from text, sending both to
	 * appropriate functions.
	 * 
	 * @param text A String of text.
	 */
	void formatString(String text)
	{
		// Logic on parsing the rawText using the methods above.
		String lines[] = rawText.split("\\r?\\n"); // Split the rawText into lines
		commandQueue.add('l'); //left justified default
//		commandQueue.add('s'); //single space default
//		commandQueue.add('1'); //one column default
		
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].length() >= 1) { // Ignore blank lines.
				if (lines[i].charAt(0) == '-' && lines[i].length() == 2) { // We are reading a command
					// Add to the commandQueue
					commandQueue.add(lines[i].charAt(1));
				} else { // Treat it like text.
					String formattedLine = "";
					
					// Compile formattedLines until you reach another command.
					while (i < lines.length && lines[i].length() > 2 && lines[i].charAt(0) != '-' && lines[i].length() != 2) {
						formattedLine += " " + lines[i];
						i++;
					}
					
					if (i < lines.length) {
						if (lines[i].length() < 1) {
							// You just read a blank line.
							formattedLine += "\n";
						} else if (lines[i].charAt(0) == '-' && lines[i].length() == 2) {
							i--;
						}
					}
					
					// Use the commandQueue to invoke methods on the next line				
					while (!commandQueue.isEmpty()) {
						char command = commandQueue.remove();
						if (command == 'e') {
							formattedString += "\n";
						} else {
							formattedLine = envokeCommand(command, formattedLine);
						}
					}

					formattedString += formattedLine;
					commandQueue.add('l');
	//				commandQueue.add('s');
	//				commandQueue.add('1');
				}
			} else
			{
				formattedString += "\n";
			}
		}
	}

	/**
	 * getFormattedString() - returns a formatted string
	 * 
	 * @return String - A String of text.
	 */
	String getFormattedString()
	{
		return formattedString;
	}

	/**
	 * getErrorLog() - returns an error log string
	 * 
	 * @return String - An error log file string.
	 */
	String getErrorLog()
	{
		return errorLog;
	}

}
