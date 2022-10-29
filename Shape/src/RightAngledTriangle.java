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
 * The RightAngledTriangle extended class of Triangle has <strong>a blueprint of properties of right angle 
 * triangles and methods to find perimeter and area</strong>
 * @author Leeya310
 */
public class RightAngledTriangle extends Triangle {
	
	/**
	 * Takes a <strong>base and height to evaluate as a right angle triangle, overwriting the parent 
	 * class</strong>
	 * @param base, as a double value as the base of the triangle (perpendicular to height)
	 * @param height, as the height value of the triangle (perpendicular to base)
	 * @throws InvalidDimensionsException to handle negative and 0 inputs
	 */
	public RightAngledTriangle (double base, double height) throws InvalidDimensionsException {
		super(base, height, 0, 0);
		this.base = base;
		this.height = height;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the right angle triangle</strong> based on the base and 
	 * height
	 * @return the perimeter of the triangle in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		double hypotenuse = Math.sqrt(Math.pow(base, 2)+(Math.pow(height, 2)));
		if (this.base <= 0 || this.height <= 0) throw new InvalidDimensionsException ("Dimensions"
				+ " input out of range for triangle. Please input double dimensions greater than 0.");
		if (base+height <= hypotenuse || hypotenuse+base <= height|| hypotenuse+height <= base) throw new 
		InvalidDimensionsException ("Dimensions correlate to invalid triangle. Make sure the sum of any "
				+ "two sides is greater than the third.");
		super.perimeter = this.base+this.height+hypotenuse;
		return super.perimeter;
	}
	
	/**
	 * findArea() finds the <strong>area of the right angle triangle</strong> based on the base and height
	 * @return the area of the triangle in square units
	 */
	public double findArea() {
		super.area = (this.base*this.height)/2; 
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