/*
Copyright (C) 2022 Aleeya Irshad

Program Name: Roman
Assignment Name: Roman Numerals
Instructor: E. Chun
Course Code: ICS4U-03

@author Aleeya Irshad
@version #: 3.2; On Friday, April 8th, 2022

@Program Description: This program converts an integer input to Roman numerals and a string input of Roman
numerals to an integer using methods.

@Asumptions and Limitations: Program has built-in exception handling and a database to maximize time
complexity and efficiency, similar to real converters that use databases to access outputs quickly. It is assumed
the boundaries for this program are 1-39,999.

.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class <strong>converts Roman numerals to integers and vice versa</strong>
 * @author Aleeya Irshad
 */
public class Roman {
	
	//Global Variables for Access Across All Methods
	static String[] romans = {"Q", "MQ", "E", "ME", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	static int[] numerals = {10000, 9000, 5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	static ArrayList<String> roman = new ArrayList<String>(); //database for Roman numerals
	static ArrayList<Integer> numeral = new ArrayList<Integer>(); //database for numbers
	static String fullNum = "";
	static char[] romArray;
	
	
	/**
	 * The convertToRoman method <strong>converts an integer input to a string Roman numeral</strong>
	 * @param x is the user input integer to convert to Roman numerals
	 * @return the string Roman numeral value of the integer input
	 * @throws OutOfInteger handles exceptions for invalid integers out of range
	 */
	public static String convertToRoman (int x) throws OutOfIntegerException, InvalidRomanException {
		int constant = x;
		while (x > 0 && x < 40000) {
			fullNum = "";
			for (int i = 0; i < numerals.length; i++) {
				if (x >= numerals[i]) {
					fullNum += romans[i];
					x -= numerals[i];
					i = -1; // reset to get to index 0
				}
			}
			roman.add(fullNum); //add Roman to database
			numeral.add(constant); //add corresponding number to database
			return fullNum;
		}
		throw new OutOfIntegerException ("Please input a valid integer from 1-39999.");
	}
	
	
	/**
	 * The repeatedNumerals method <strong>finds if repeated Roman numerals are valid</strong>
	 * @param y is the string Roman numeral value of an individual Roman character
	 * @param z is the char array of the total user input
	 * @return a boolean value of false if the count is greater than the max and true if it is less or equal
	 */
	public static boolean repeatedNumerals (String y, char[] z) {
		int max;
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < z.length; i++) {
			if (y.equals(String.valueOf(z[i]))) {
				count++;
				if (i >= 1) {
					if (y.equals(String.valueOf(z[i-1]))) maxCount++;
					if (maxCount > 3) break;
				}
			}
		}
		switch (y) {
		case "I": case "X": case "C": case "Q":
			max = 3;
			break;
		case "M":
			max = 4;
		default:
			max = 1;
		}
		if (count > max && maxCount > 3) return false;
		return true;
	}
	
	
	/**
	 * The convertToInt <strong>converts a string Roman input to an integer</strong>
	 * @param r is the string Roman numeral user input to convert to an integer
	 * @return the integer value of the string Roman numeral input
	 * @throws InvalidRoman handles exceptions for invalid Roman numerals
	 * @throws OutOfInteger handles exceptions for invalid integers out of range
	 */
	public static int convertToInt (String r) throws InvalidRomanException, OutOfIntegerException {
		int number = 0;
		int current = 0;
		String previousRom = null;
		String romanString;
		int previous = 10000; //initialize at high number so condition for i = 0 will always work
		boolean valid = false;
		romArray = r.toCharArray();
		
		for (int i = 0; i < romArray.length; i++) {
			for (int j = 0; j < romans.length; j++) {
				romanString = String.valueOf(romArray[i]);
				if (romanString.equals(romans[j])) {
					current = numerals[j];
					valid = true;
					valid = repeatedNumerals(romanString, romArray); //use method to find if numeral is valid
					if (i >= 1) { //condition for multiple-digit Roman numbers
						previousRom = String.valueOf(romArray[i-1]);
						for (int k = 0; k < romans.length; k++ ) {
							if (previousRom.equals(romans[k])) {
								valid = true;
								previous = numerals[k];
								if (current > previous) number += current-(previous*2);
								break;
							}
						}
					}
					if (current <= previous) number += current;
				}
			}
			if (r.equals("QQQQ")) valid = false;
			if (valid == false) throw new InvalidRomanException ("Input a valid roman numeral from I-QQQMQCMXCIX.");
		}
		if (!convertToRoman(number).equals(r)) valid = false; //use convertToRoman to check if Roman numeral is valid
		if (valid == false) throw new InvalidRomanException ("Input a valid roman numeral from I-QQQMQCMXCIX.");
		roman.add(r); //add Roman numerals to database
		numeral.add(number); //add number to database
		return number;
	}
	
	
	//Main Program
	public static void main(String[] args) throws IOException, InvalidRomanException, OutOfIntegerException {
		
		Scanner myObj = new Scanner(System.in);
		int choice = 1;
		int num = 1;
		int place = 0;
		String rom = "";
		
		while (choice != 0) { //so that it keeps repeating asking until choice = 0 is true
			try {
				System.out.print("\n\n0 - Exit\n1 - Integer to Roman\n2 - Roman to Integer\nChoice: ");
				choice = myObj.nextInt();
			}
			catch (Exception e) {
				System.out.print("Invalid input! Please input an integer between 0 and 2.");
				System.exit(0);
			}
			myObj.nextLine();
			
			switch(choice) {
				case 0:
					System.out.print("You have exited, thank you!");
					System.exit(0);
				case 1:
					try { //testing for data type and integer size errors
						try { //see if it can access ArrayList database
							System.out.print("\nInteger to convert: ");
							num = myObj.nextInt();
							place = numeral.indexOf(num);
							System.out.print("Roman Numeral: " + roman.get(place));
						} 
						catch (IndexOutOfBoundsException e) { //if boundary exception was reached since element doesn't exist
							System.out.println("Roman Numeral: " + convertToRoman(num)); //perform conversion
						}
					}
					catch (Exception e) {
						System.out.println("Please input a valid integer from 1-39999.");
						System.exit(0);
					}
					myObj.nextLine();
					break;
				case 2:
					try { //testing for data type and Roman numeral validity errors
						try { //see if it can access ArrayList database
							System.out.print("\nRoman to convert: ");
							rom = (myObj.next()).toUpperCase();
							place = roman.indexOf(rom);
							System.out.println("Integer: " + numeral.get(place));
						}
						catch (IndexOutOfBoundsException e) { //if boundary exception was reached since element doesn't exist
							System.out.println("Integer: " + convertToInt(rom)); //perform conversion
						}
					}
					catch (InvalidRomanException e) {
						System.out.println (e.getMessage());
						System.exit(0);
					}
					myObj.nextLine();
					break;
				default:
					System.out.print("Invalid input! Please input an integer between 0 and 2.");
					break;
			}
		}
		myObj.close();
	}
}

/*
                                                ___
                                               /   \             
                                              /_____\
                                             / \ A / \
                                            /___\_/___\
*/