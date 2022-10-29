/*
Copyright (C) 2022 Aleeya Irshad

Program Name: Encode.java
Assignment Name: Huffman
Instructor: E. Chun
Course Code: ICS4U-03

@author Aleeya Irshad
@credits Mr. Chun - I implemented code Mr. Chun provided and revised.
@version #: 15; On Wednesday, June 8th, 2022

@Program Description: This program reads a file, encodes and writes it and the tree using Huffman.

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
 * Class that reads in a file, encodes it using Huffman and writes it and the binary tree to two files.
*/
public class Encode implements java.io.Serializable {
	
	protected static Node tempInt;
	protected static Node tempInt1;
	protected static Node root;
	
	protected static BitSet bitsOut;
	
	protected static FileOutputStream out = null;
	protected static FileOutputStream out1 = null;
	
	protected static ArrayList<Node> nodesArray;
	protected static Hashtable <Character, Integer> ht = new Hashtable <Character, Integer>();
	
	protected static boolean less;
	
	protected static int character1 = 0;
	protected static int constCount = 0;
	public static int counter = 0;

	
	/**
	 * Method that populates the hashtable to get the characters' respective frequencies
	 * @param ab is the hashtable that will be populated with the character (char) and the frequency (int)
	 * @return the hashtable that was passed through, but populated
	 */
	public static Hashtable <Character, Integer> populateHash(Hashtable <Character, Integer> ab) {
		
 		FileInputStream in = null;
		try {
			in = new FileInputStream("testfile.txt");
		} catch (FileNotFoundException e1) {
			System.err.println("FILE NOT FOUND");
			System.exit(0);
		}
		
		while (character1 >= 0) {
			try {
				character1 = in.read();
			} catch (IOException e1) {
				System.err.println("I/O ERROR OCCURRED");
				System.exit(0);
			} catch (NullPointerException e1) {
				System.err.println("NULL POINTER ERROR OCCURRED");
				System.exit(0);
			}
				
			if (ht.get((char) character1) == null) ht.put((char) character1, 1); 
			//if null, put character in hashtable with frequency of 1
			else ht.replace((char) character1, ht.get((char) character1) + 1); 
			//otherwise (already there), replace with 1 added to frequency
		}
		character1 = 0;
		return ab;
	}
	
	
	/**
	 * Method that uses bubble sort to take in the node array and sort from highest to lowest frequency
	 * @param n is the node array
	 */
	public static void sortNodeArray (ArrayList<Node> n) {
		for (int i = 0; i < n.size()-1; i++) {
			for (int j = 0; j < n.size()-1; j++) {
				if (n.get(j).freq > n.get(j+1).freq) {
					tempInt = n.get(j+1);
					tempInt1 = n.get(j);
					n.set(j, tempInt);
					n.set(j+1, tempInt1);
				}
			}
		}
	}
	
	
	/**
	 * Method that finds the node array by using the hashtable to populate it, then sorting the array
	 * @param ab is the hashtable that has the characters and their respective frequencies
	 * @return the populated and sorted node arraylist
	 */
 	public static ArrayList<Node> findNodeArray(Hashtable <Character, Integer> ab) {
 	 	
 		ArrayList<Node> n = new ArrayList<Node>();
		ab.forEach((k, v) -> {
 	 		n.add(new Node (k, v));
 	 	});
 	 		
 	 	sortNodeArray(n);
 	 		
 	 	int counter = 0;
 		int number = n.size();
 			
 		while (number > 1) {
 			number = number/2;
 			counter++;
 		}
 			
 		while (counter > 0) {
 			for (int i = 0; i < n.size(); i++) {
 				n.add(new Node (n.remove(0), n.remove(0)));
 			}
 			counter--;
 		}
 	 	return n;
 	}
	
 	
	/**
	 * Method that finds the huffman value of a character using a node, char and string
	 * @param n is the node array
	 * @param c is the char value of the character
	 * @param bits is the string value of the bits of the path associated with the character
	 * @return return "" if it is a leaf node, return the path to that and continue to a leaf node
	 * if it is a branch node
	 */
	public static String findHuffmanValue (Node n, char c, String bits) {
		if (n.leftNode == null && n.rightNode == null) { //if it is a leaf node
			if (n.value == c) return bits; //get the value of that and get the bits from that
			return "";
		}
		return findHuffmanValue (n.leftNode, c, bits + "0") + findHuffmanValue (n.rightNode, c, bits + "1");
	}
 	
	
	/**
	 * Method that writes the bitsets of the respective character paths to a file
	 * @param b is bitset that contains 8 bits (and a variable amount for the last) per set
	 * @param n is the node array
	 */
	public static void encodedWrite(BitSet b, ArrayList <Node> n) {
		
  	  	try {
  	  		if (b.length() == 0) out.write(0);
  	  		else out.write(b.toByteArray());
  	  		counter++;
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
  	} 
	
	
	/**
	 * Method that writes the binary tree to a file
	 * @param n is the node array that contains the binary tree data
	 */
	public final static void treeWrite(ArrayList <Node> n) {
		
		try {
			ObjectOutputStream serOut = new ObjectOutputStream(out1);
  			serOut.writeObject(n);
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
	 * Main method that implements the above methods to output the binary tree and the encoded binary
	 * data to two separate text files
	 * @throws IOException 
	 */
 	public static void main (String[] args) {
 		int bitsCount = 0; //counting number of bits to go in each bitset
 		boolean firstRun = true; //for avoiding a null value
 		String actualBits = null; //the bits of the entire text by eliminating spaces
 		String totalBit = null; //the bits of the entire text with spaces
 		bitsOut = new BitSet(8);
 		String sBits = null; //bits for each character
 		FileInputStream in = null;
 		FileInputStream in1 = null;
 		
 		System.out.print("Currently encoding...");
 		
		try {
			in = new FileInputStream("testfile.txt");
			in1 = new FileInputStream("testfile.txt");
			out = new FileOutputStream("encoded.encoded");
			out1 = new FileOutputStream("huffman.ser");
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
		
		populateHash(ht);
		nodesArray = findNodeArray(ht);
		root = nodesArray.get(0);
  		
  		while (character1 >= 0) { //since it outputs -1 if the end of the stream has been reached
 			try {
                character1 = in1.read();
                if (character1 < 0) break;
                sBits = findHuffmanValue(root, (char) character1, " ");
                if (firstRun == true) totalBit = sBits;
                else totalBit = totalBit + sBits;
                 firstRun = false;
        	} catch (FileNotFoundException e5) {
      	  		System.err.print("FILE NOT FOUND");
      	  		System.exit(0);
      	  	} catch (IOException e5) {
      	  		System.err.print("I/O ERROR OCCURRED");
      	  		System.exit(0);
      		} catch (NullPointerException e5) {
      			System.err.println ("NULL POINTER ERROR OCCURRED");
      			System.exit(0);
      		}	
 		}
  		
  		firstRun = true;
  		
  		for (int i = 0; i < totalBit.length(); i++) {
  			if (totalBit.charAt(i) == '0' || totalBit.charAt(i) == '1') {
  				if (firstRun == true) actualBits = Character.toString(totalBit.charAt(i));
  				else actualBits = actualBits + totalBit.charAt(i);
  			}
  			else if (totalBit.charAt(i) == ' ') {
  				continue;
  			}
  			firstRun = false;
  		}
  		
  		System.out.println(" Successfully encoded.");
  		
  		System.out.println("Currently writing encoded to the file...");
  		
  		for (int j = 0; j < actualBits.length(); j++, bitsCount++) {
            if (bitsCount % 8 == 0 && bitsCount != 0) {
            	encodedWrite(bitsOut, nodesArray);
            	bitsOut.clear();
            	bitsCount = 0;
            }
            	
            if (actualBits.charAt(j) == '0') bitsOut.set(bitsCount, false);
            if (actualBits.charAt(j) == '1') bitsOut.set(bitsCount, true);
  		} 
  		
  		constCount = bitsCount;
  		String newActualBits = null;
  		
  		if (constCount > 0 && constCount < 8) {
  			BitSet bitsOut2 = new BitSet(constCount); //new bitset based on characters left over
  			newActualBits = actualBits.substring(actualBits.length()-constCount);
  			bitsCount = 0;
  	  		for (int i = 0; i < newActualBits.length()+1; i++, bitsCount++) {
  	            if (bitsCount % constCount == 0 && bitsCount != 0) {
  	            	encodedWrite(bitsOut2, nodesArray);
  	            	bitsOut2.clear();
  	            	bitsCount = 0;
  	            	break;
  	            }
  	         
  	            if (newActualBits.charAt(i) == '0') bitsOut2.set(bitsCount, false);
  	            if (newActualBits.charAt(i) == '1') bitsOut2.set(bitsCount, true);
  			}
  		}
  		System.out.println("Currently writing tree to the file...");
  		treeWrite(nodesArray);
  		System.out.println("Successfully wrote to both files.");
 	}
}

/*
								  ___
								 /   \             
								/_____\
							   / \ A / \
							  /___\_/___\
*/