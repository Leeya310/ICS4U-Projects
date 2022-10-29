/*
Copyright (C) 2022 Leeya310

Program Name: Shape
Assignment Name: Abstrat Classes and Polymorphism
Course Code: ICS4U

@author Leeya310
@version #: 4.2; On Friday, April 22nd, 2022

@Program Description: This program finds the perimeter/circumference and area of different 2D shapes using
abstract classes and polymorphism

@Asumptions and Limitations: Program has built-in exception handling. It is assumed inputs will be for valid
polynomials and for realistic numbers.

.------..------..------..------..------..------.                            
|A.--. ||L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| (\/) || :/\: || (\/) || (\/) || (\/) || (\/) |
| :\/: || (__) || :\/: || :\/: || :\/: || :\/: | 
| '--'A|| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

/**
 * The Square extended class of Rectangle has <strong>a blueprint of properties of squares and methods to 
 * find perimeter and area</strong>
 * @author Leeya310
 */
public class Square extends Rectangle {
	
	/**
	 * Takes <strong>1 side length to evaluate a square, overwriting the parent class</strong>
	 * @param base1, double value for the value of the equal side lengths (also height of overall shape)
	 */
	public Square (double base1) {
		super(base1, 0);
		this.base1 = base1;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the square</strong> based on the 1 length
	 * @return the perimeter of the square in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.base1 <= 0) throw new InvalidDimensionsException ("Dimensions input out of range for square. "
				+ "Please input double dimensions greater than 0.");
		super.perimeter = 4*(this.base1);
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the square</strong> based on the side length
	 * @return the area of the square in square units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findArea() {
		super.area = Math.pow(this.base1, 2);
		return super.area;
	}

	/**
	 * This <strong>overwrites the parent method and calls it to output</strong> perimeter and area
	 * @throws InvalidDimensionsException to handle negative or zero inputs
	 */
	public void printInfo() throws InvalidDimensionsException {
		super.printInfo();
	}
}

/*
										    ___
										   /   \             
										  /_____\
									   	 / \ A / \
										/___\_/___\
*/