/*
 Copyright (C) 2022 Aleeya Irshad
 Program Name: Roman
 Assignment Name: Roman Numerals
 Instructor: E. Chun
 Course Code: ICS4U-03
 
 @author Aleeya Irshad
 @version #: 3.2; On Friday, April 8th, 2022
 
.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/


/**
 * This class extends the Exception by <strong>handling invalid inputs through unoptimized</strong> number of Roman characters
 * @author Aleeya Irshad
 */
public class InvalidRomanException extends Exception {
	public InvalidRomanException (String message) {
		super (message);
	}
}

/*
                                                  ___
                                                 /   \             
                                                /_____\
                                               / \ A / \
                                              /___\_/___\
*/
