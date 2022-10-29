/*
 Copyright (C) 2022 Leeya310
 Program Name: Roman
 Assignment Name: Roman Numerals
 Course Code: ICS4U
 
 @author Leeya310
 @version #: 3.2; On Friday, April 8th, 2022
 
.------..------..------..------..------.
|L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| :/\: || (\/) || (\/) || (\/) || (\/) |
| (__) || :\/: || :\/: || :\/: || :\/: |
| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/


/**
 * This class handles <strong>integer boundary exceptions</strong> for the convertToRoman method
 * @author Leeya310
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
