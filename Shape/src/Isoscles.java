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
 * The Isoscles extended class of Triangle has <strong>calculations for the perimeter and area of an isoscles 
 * triangle</strong>
 * @author Leeya310
 */
public class Isoscles extends Triangle {
	
	/**
	 * Takes a <strong>side, a base and height to evaluate as an isoscles triangle, overwriting the parent 
	 * class</strong>
	 * @param leg1, as a double value that represents the 2 equal legs
	 * @param base, as a double value as the base of the triangle (perpendicular to height)
	 * @param height, as the height value of the triangle (perpendicular to base)
	 * @throws InvalidDimensionsException to handle negative and 0 inputs
	 */
	public Isoscles (double leg1, double base, double height) throws InvalidDimensionsException {
		super(leg1, base, height, 0);
		this.leg1 = leg1;
		this.base = base;
		this.height = height;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the triangle</strong> based on the equal legs and the base
	 * @return the perimeter of the triangle in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.leg1 <= 0 || this.base <= 0 || this.height < 0) throw new InvalidDimensionsException 
		("Dimensions input out of range for Isosceles triangle. Please input double dimensions greater than 0.");
		if (leg1*2 <= base || leg1+base <= leg1) throw new InvalidDimensionsException ("Dimensions correlate "
				+ "to invalid triangle. Make sure the sum of any two sides is greater than the third.");
		super.perimeter = (2*leg1)+base;
		return super.perimeter;
	}
	
	/**
	 * findArea() finds the <strong>area of the triangle</strong> based on the base and height
	 * @return the area of the triangle in square units
	 */
	public double findArea() {
		super.area = (base*height)/2; 
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