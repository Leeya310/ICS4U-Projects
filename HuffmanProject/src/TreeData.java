/*
Copyright (C) 2022 Aleeya Irshad

Program Name: TreeData.java
Assignment Name: Huffman
Instructor: E. Chun
Course Code: ICS4U-03

@author Aleeya Irshad
@version #: 15; On Wednesday, June 8th, 2022

@Program Description: This program creates the TreeData object for returning the character and new binary
value from the method that traverses through the binary tree when decoding.

.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

/**
 * Class that creates the TreeData object for returning the character and new binary value from the method that 
 * traverses through the binary tree when decoding
*/
public class TreeData {
	
	public char character;
	public String binary;
	
	/**
	 * Constructor of a single TreeData with a character
	 * @param c is the char value for the character value for a TreeData object
	 */
	public TreeData (char c) {
		this.character = c;
	}
	
	/**
	 * Constructor of a single TreeData with a string value
	 * @param s is the String value for the binary value for a TreeData object
	 */
	public TreeData (String s) {
		this.binary = s;
	}
	
	/**
	 * Constructor of a TreeData object with a character and binary value
	 * @param c is the char value for the character value for a TreeData object
	 * @param s is the String value for the binary valye for a TreeData object
	 */
	public TreeData (char c, String s) {
		this.character = c;
		this.binary = s;
	}
}

/*
										 ___
										/   \             
									   /_____\
									  / \ A / \
									 /___\_/___\
*/