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
 * The Rectangle extended class of Quadrilateral has <strong>a blueprint of properties of rectangles and methods 
 * to find perimeter and area</strong>
 * @author Leeya310
 */
public class Rectangle extends Quadrilateral {
	
	/**
	 * Takes the <strong>length and width of a rectangle to evaluate, overwriting the parent class</strong>
	 * @param base1, double value for a side length
	 * @param width1, double value for a side width (height of overall shape)
	 */
	public Rectangle (double base1, double width1) {
		super(base1, width1, 0, 0, 0, 0, 0);
		this.base1 = base1;
		this.width1 = width1;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the rectangle</strong> based on the base and width
	 * @return the perimeter of the rectangle in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.base1 <= 0 || this.width1 <= 0) throw new InvalidDimensionsException ("Dimensions input out of "
				+ "range for rectangle. Please input double dimensions greater than 0.");
		if (2*this.base1+this.width1 <= this.width1 || 2*this.width1 <= this.base1  || this.base1 + this.width1
				<= this.base1 || this.base1 + this.width1 <= this.width1) throw new 
		InvalidDimensionsException ("Dimensions correlate to invalid rectangle. Make sure the sum of any three "
				+ "sides is greater than the fourth.");
		super.perimeter = 2*(this.base1 + this.width1);
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the rectangle</strong> based on the length and width
	 * @return the area of the rectangle in square units
	 */
	public double findArea() {
		super.area = this.base1*this.width1;
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