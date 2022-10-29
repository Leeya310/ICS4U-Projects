/*
Copyright (C) 2022 Aleeya Irshad

Program Name: Decode.java
Assignment Name: Huffman
Instructor: E. Chun
Course Code: ICS4U-03

@author Aleeya Irshad
@credits Mr. Chun - I implemented code Mr. Chun provided and revised.
@version #: 15; On Wednesday, June 8th, 2022

@Program Description: This program reads in an encoded file and decodes it, writing the decoded to a file.

.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Hashtable;

/**
 * Class that reads in an encoded file and decodes it using Huffman, outputting the decoded to a file.
*/
public class Decode extends Encode {
	
	static TreeData charBinary = new TreeData(' ');
	
	/**
	 * Method that gets the binary value of a read in integer value
	 * @param a is the integer value of the character
	 * @return the string (binary) value of the integer
	 */
	public static String getBinary (int a) {
		String bitString = null;
		FileInputStream in = null;
		try {
			in = new FileInputStream("encoded.encoded");
			out = new FileOutputStream("decoded.decoded");
		} catch (FileNotFoundException e1) {
  	  		System.err.print("FILE NOT FOUND");
  	  		System.exit(0);
  	  	} catch (IOException e1) {
  	  		System.err.print("I/O ERROR OCCURRED");
  	  		System.exit(0);
  		} catch (NullPointerException e1) {
  			System.err.println ("NULL POINTER ERROR OCCURRED");
  			System.exit(0);
  		}
		
		String newBinary = null;
		boolean firstRun = true;
		String lastString = null;
		
		while (a >= 0) {
			try {
				a = in.read();
				if (a < 0) break;
				bitString = Integer.toBinaryString(a);
				int bitsLength = bitString.length();
				lastString = bitString;
				if (bitsLength < 8) for (int i = bitsLength; i < 8; i++) bitString = "0" + bitString;
			} catch (FileNotFoundException e2) {
	  	  		System.err.print("FILE NOT FOUND");
	  	  		System.exit(0);
	  	  	} catch (IOException e2) {
	  	  		System.err.print("I/O ERROR OCCURRED");
	  	  		System.exit(0);
	  		} catch (NullPointerException e2) {
	  			System.err.println ("NULL POINTER ERROR OCCURRED");
	  			System.exit(0);
	  		}
			
			if (firstRun == true) newBinary = bitString;
			else newBinary = bitString + newBinary;
			firstRun = false;
		}
		String newNewBinary = lastString + newBinary.substring(8);
		return newNewBinary;
	}
	
	
	/**
	 * Method that finds the character and the binary value of the text with that character omitted
	 * @param root is the root of the node array
	 * @param btInt is the integer value of the bits
	 * @param charBinary is the data of the character and new binary value
	 * @return the character and new binary value
	 */
	public static TreeData searchTree(Node root, int bitInt, TreeData charBinary) {
		
		char character;
		Node currentNode = root;
		
		for (int i = charBinary.binary.length(); i > 0; i--) {
			character = charBinary.binary.charAt(i-1);
			if (currentNode.rightNode == null && currentNode.leftNode == null) break;
			if (character == 48) currentNode = currentNode.leftNode;
			if (character == 49) currentNode = currentNode.rightNode;
			charBinary.binary = charBinary.binary.substring(0, charBinary.binary.length()-1);
		}
		charBinary = new TreeData(currentNode.value, charBinary.binary);
		return charBinary;
	}
	
	
	/**
	 * Method that writes the decoded text to a file
	 * @param s is the string value of the text
	 */
	public static void decodedWrite(String s) {
		try {
			byte b [] = s.getBytes(); 
			for (int i = 0; i < b.length; i++) out.write(b[i]); 
		} catch (FileNotFoundException e3) {
  	  		System.err.print("FILE NOT FOUND");
  	  		System.exit(0);
  	  	} catch (IOException e3) {
  	  		System.err.print("I/O ERROR OCCURRED");
  	  		System.exit(0);
  		} catch (NullPointerException e3) {
  			System.err.println ("NULL POINTER ERROR OCCURRED");
  			System.exit(0);
  		}
	}

	
	/**
	 * Main method that decodes a file and writes it out to another file
	 */
	public static void main(String[] args) {
		System.out.print("Gathering info to decode...");
		ArrayList<Character> characters = new ArrayList<Character>();
		String newBinary = null;
		int bitInt = 0;
		populateHash(ht);
		nodesArray = findNodeArray(ht);
		root = nodesArray.get(0);
		Node s = root;
		System.out.println(" Info gathered.\nDecoding...");
		
		FileInputStream in1 = null;
		try {
			in1 = new FileInputStream("huffman.ser");
			ObjectInputStream inStream = new ObjectInputStream(in1);
			
		} catch (FileNotFoundException e4) {
  	  		System.err.print("FILE NOT FOUND");
  	  		System.exit(0);
  	  	} catch (IOException e4) {
  	  		System.err.print("I/O ERROR OCCURRED");
  	  		System.exit(0);
  		} catch (NullPointerException e4) {
  			System.err.println ("NULL POINTER ERROR OCCURRED");
  			System.exit(0);
  		}
		
		newBinary = getBinary(bitInt);
			
		charBinary.binary = newBinary;
			
		while (charBinary.binary.length() > 0) {
			TreeData treeInfo = searchTree(s,bitInt, charBinary);
			characters.add(treeInfo.character);
		}
		
		String charStr = null;
		for (int i = 0; i < characters.size(); i++) {
			if (i == 0) charStr = (characters.get(i)).toString();
			else charStr += (characters.get(i)).toString();
		}
		decodedWrite(charStr);
		System.out.println("Successfully decoded.");
	}
}

/*
									  ___
									 /   \             
									/_____\
								   / \ A / \
								  /___\_/___\
*/