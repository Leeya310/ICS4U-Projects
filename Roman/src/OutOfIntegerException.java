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
 * This class handles <strong>integer boundary exceptions</strong> for the convertToRoman method
 * @author Aleeya Irshad
 */
public class OutOfIntegerException  extends Exception {
	public OutOfIntegerException (String message) {
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
