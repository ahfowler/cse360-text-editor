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

public class TextModifier {
	private String rawText;
	private String formattedString;

	private Queue<Character> commandQueue;

	TextModifier(String text) {
		rawText = text;
		formattedString = "";
		commandQueue = new LinkedList<>();
	}

	// Methods based on command.
	String returnSpaces(int count) {
		String spaces = "";

		for (int i = 0; i < count; i++) {
			spaces += " ";
		}

		return spaces;
	}

	String leftText(String line) {
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80) {
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = leftText(newLine);
			String nextLine = leftText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else {
			int numOfSpaces = 80 - line.length();
			String newLine = line;
			newLine += returnSpaces(numOfSpaces);
			return newLine + "\n";
		}
	}

	String rightText(String line) {
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80) {
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = rightText(newLine);
			String nextLine = rightText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else {
			int numOfSpaces = 80 - line.length();
			String newLine = returnSpaces(numOfSpaces);
			newLine += line;
			return newLine + "\n";
		}
	}

	String centerText(String line) {
		line = line.trim().replaceAll("\\s+", " ");
		if (line.length() > 80) {

			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = centerText(newLine);
			String nextLine = centerText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else {
			String[] words = line.split(" ");
			String lastWord = words[words.length - 1];

			int numOfSpaces = 80 - line.length();
			int spacesPerWord = numOfSpaces / (words.length - 1) + 1;
			int remainingSpaces = line.length()
					+ spacesPerWord * (words.length - 1) - words.length;

			if (remainingSpaces < 80) {
				remainingSpaces = 80 - remainingSpaces - 1;
			} else {
				remainingSpaces = 0;
			}

			String newLine = "";

			for (int i = 0; i < words.length - 1; i++) {
				newLine += words[i] + returnSpaces(spacesPerWord);
				if (i == words.length / 2) {
					newLine += returnSpaces(remainingSpaces);
				}
			}
			newLine += lastWord;

			System.out.println(newLine.length());

			return newLine + "\n";
		}
	}

	String titleText(String line) {
		line = line.trim().replaceAll("\\s+", " ");

		if (line.length() > 80) {

			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = titleText(newLine);
			String nextLine = titleText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else {
			int numOfSpaces = 80 - line.length();
			String newLine = returnSpaces(numOfSpaces / 2);
			newLine += line;
			newLine += returnSpaces(numOfSpaces / 2);

			if (newLine.length() < 80) {
				newLine += " ";
			}

			return newLine + "\n";

		}
	}

	String doubleText(String line) {
		if (line.length() > 80) {
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = doubleText(newLine);
			String nextLine = doubleText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + "\n" + nextLine;
		} else {
			return line + "\n";
		}
	}

	String singleText(String line) {
		if (line.length() > 80) {
			String newLine = line.substring(0, 80);

			String[] words = newLine.split(" ");
			String lastWord = words[words.length - 1];

			if (newLine.charAt(79) != lastWord.charAt(0)
					|| newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length - 1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length() - 1);
			}

			newLine = doubleText(newLine);
			String nextLine = doubleText(
					line.substring(80 - lastWord.length() - 1));

			return newLine + nextLine;
		} else {
			return line + "\n";
		}
	}

	String indentText(String line) {
		line = line.trim().replaceAll("\\s+", " ");
		if (line.length() > 75) {
			int split = 75;
			char spltWords = line.charAt(split);

			// prevent mid word splitting
			if (spltWords != ' ') {
				while (spltWords != ' ' && spltWords != -1) {
					--split;
					spltWords = line.charAt(split);

				}
			}

			String iLine = line.substring(0, split); // line to be indented

			iLine = returnSpaces(5) + iLine;
			line = leftText(line.substring(split + 1));
			line = iLine + "\n" + line;
		} else {
			line = returnSpaces(5) + line;
		}

		return line;
	}

	String blockText(String line) {
		line = line.trim().replaceAll("\\s+", " ");
		if (line.length() > 70) {
			int split = 70;
			char spltWords = line.charAt(split);

			// prevent mid word splitting
			if (spltWords != ' ') {
				while (spltWords != ' ' && spltWords != -1) {
					--split;
					spltWords = line.charAt(split);
				}
			}
		
			String iLine = line.substring(0, split); 
			
			return returnSpaces(10) + iLine + "\n" + blockText(line.substring(split + 1));
		} else {
			line = returnSpaces(10) + line;
		}
		return line + "\n";
	}

	String envokeCommand(char command, String line) {
		switch (command) {
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
		case 'b': //block text
			return blockText(line);
		case '2': 
			return line;
		case '1':
			return line;
		case 'e':
			return "\n";
		default:
			return line;
		}
	}

	void formatString(String text) {
		// Logic on parsing the rawText using the methods above.
		String lines[] = rawText.split("\\r?\\n"); // Split the rawText into
													// lines

		// commandQueue.add('l'); //left justified default
		// commandQueue.add('s'); //single space default
		// commandQueue.add('1'); //one column default

		for (int i = 0; i < lines.length; i++) {
			if (lines[i].charAt(0) == '-') { // We are reading a command
				// Add to the commandQueue
				commandQueue.add(lines[i].charAt(1));
			} else {
				// Use the commandQueue to invoke methods on the next line
				String formattedLine = lines[i];
				while (!commandQueue.isEmpty()) {
					char command = commandQueue.remove();
					formattedLine = envokeCommand(command, formattedLine);
				}
				formattedString += formattedLine;
			}
		}
	}

	String getFormattedString() {
		return formattedString;
	}
}
