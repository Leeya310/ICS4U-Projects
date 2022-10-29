/*
Copyright (C) 2022 Aleeya Irshad

Program Name: Node.java
Assignment Name: Huffman
Instructor: E. Chun
Course Code: ICS4U-03

@author Aleeya Irshad
@credits Mr. Chun - I implemented code Mr. Chun provided and revised.
@version #: 15; On Wednesday, June 8th, 2022

@Program Description: This program creates the Node for construction of the Huffman tree.

.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

/**
 * Class that creates the Node object for construction of the Huffman tree
*/
public class Node implements java.io.Serializable {
	public int freq;
	public char value;
	public Node leftNode;
	public Node rightNode;
	
	/**
	 * Constructor of a single node with a frequency
	 * @param n integer value for frequency of the Node
	 */
	public Node (int n) {
		this.freq = n;
	}
	
	/**
	 * Construction of a leaf Node
	 * @param a char value for the character of the leaf Node
	 * @param n integer value for frequency of the leaf Node
	 */
	public Node (char a, int n) {
		this.value = a;
		this.freq = n;
	}
	
	/**
	 * Construction of a branch section with two children Nodes
	 * @param r Node to be added to the right branch
	 * @param l Node to be added to the left branch
	 */
	public Node (Node r, Node l) {
		this.freq = r.freq + l.freq;
		this.rightNode = r;
		this.leftNode = l;
	}
	
	/**
	 * Setting the frequency
	 * @param n is the integer value of the frequency
	 */
	public void setFreq (int n) {
		this.freq = n;
	}
	
	/**
	 * Setting the character
	 * @param a is the char value for the character
	 */
	public void setValue (char a) {
		this.value = a; 
	}
}

/*
										  ___
										 /   \             
										/_____\
									   / \ A / \
									  /___\_/___\
*/