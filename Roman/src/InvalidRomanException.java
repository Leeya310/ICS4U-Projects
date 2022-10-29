/*
 Copyright (C) 2022 Leeya310
 Program Name: Roman
 Assignment Name: Roman Numerals
 Course Code: ICS4U
 
 @author  Leeya310
 @version #: 3.2; On Friday, April 8th, 2022
 
.------..------..------..------..------.
|L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| :/\: || (\/) || (\/) || (\/) || (\/) |
| (__) || :\/: || :\/: || :\/: || :\/: |
| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/


/**
 * This class extends the Exception by <strong>handling invalid inputs through unoptimized</strong> number of Roman characters
 * @author Leeya310
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
