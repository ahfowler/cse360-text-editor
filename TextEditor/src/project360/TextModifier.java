package project360;

import java.util.*;
import java.util.LinkedList; 
import java.util.Queue; 


public class TextModifier 
{
	private String rawText;
	private String formattedString;
	
	private Queue<Character> commandQueue;
	
	
	TextModifier (String text) {
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
			String lastWord = words[words.length-1];
			
			if (newLine.charAt(79) != lastWord.charAt(0) || newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length-1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length()-1);
			}
			
			newLine = leftText(newLine);
			String nextLine = leftText(line.substring(80 - lastWord.length() -1));
			
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
			String lastWord = words[words.length-1];
			
			if (newLine.charAt(79) != lastWord.charAt(0) || newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length-1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length()-1);
			}
			
			newLine = rightText(newLine);
			String nextLine = rightText(line.substring(80 - lastWord.length() -1));
			
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
			String lastWord = words[words.length-1];
			
			if (newLine.charAt(79) != lastWord.charAt(0) || newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length-1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length()-1);
			}
			
			newLine = centerText(newLine);
			String nextLine = centerText(line.substring(80 - lastWord.length() -1));
			
			return newLine + nextLine;
		} else {	
			String[] words = line.split(" ");
			String lastWord = words[words.length-1];
			
			int numOfSpaces = 80 - line.length();
			int spacesPerWord = numOfSpaces/(words.length-1) + 1;
			int remainingSpaces = line.length() + spacesPerWord*(words.length-1) - words.length;
			
			if (remainingSpaces < 80) {
				remainingSpaces = 80 - remainingSpaces - 1;
			} else {
				remainingSpaces = 0;
			}
				
			String newLine = "";

			for (int i = 0; i < words.length-1; i++) {
				newLine += words[i] + returnSpaces(spacesPerWord);
				if (i == words.length/2) {
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
			String lastWord = words[words.length-1];
			
			if (newLine.charAt(79) != lastWord.charAt(0) || newLine.charAt(79) != ' ') {
				// The last word is cut off!
				newLine = "";
				for (int i = 0; i < words.length-1; i++) {
					newLine += words[i] + " ";
				}
				newLine = newLine.substring(0, newLine.length()-1);
			}
			
			newLine = titleText(newLine);
			String nextLine = titleText(line.substring(80 - lastWord.length() -1));
			
			return newLine + nextLine;
		} else {
			int numOfSpaces = 80 - line.length();
			String newLine = returnSpaces(numOfSpaces/2);
			newLine += line;
			newLine += returnSpaces(numOfSpaces/2);
			
			if (newLine.length() < 80) {
				newLine += " ";
			}
			
			return newLine + "\n";
	
		}
	}
	
	String doubleText(String line) {
		// lines will always have 81 characters (including the new line)
		if (line.length() > 81) { // There is another line
			String newLine = doubleText(line.substring(0, 81));
			String nextLine = doubleText(line.substring(81));		
			return newLine + nextLine;
		} else {
			return line + "\n";
		}
	}
	
	String singleText(String line) {
		// lines will always have 81 characters (including the new line)
		if (line.length() > 81) { // There is another line
			String newLine = doubleText(line.substring(0, 81));
			String nextLine = doubleText(line.substring(81));		
			return newLine + nextLine;
		} else {
			return line;
		}
	}
	
	String envokeCommand(char command, String line) {
		switch (command) {
		case 'l':
			return leftText(line);
		case 'r':
			return rightText(line);
		case 'c':
			return centerText(line);
		case 't':
			return titleText(line);
		case 'd':
			return doubleText(line);
		case 's':
			return singleText(line);
		case 'i':
			return line;
		case 'b':
			return line;
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
		String lines[] = rawText.split("\\r?\\n"); // Split the rawText into lines
		commandQueue.add('l');
		commandQueue.add('s');
		commandQueue.add('1');
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
				commandQueue.add('l');
				commandQueue.add('s');
				commandQueue.add('1');
			}
		}
	}
	
	String getFormattedString() {
		return formattedString;
	}
}
