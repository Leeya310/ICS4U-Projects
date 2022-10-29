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
 * The Triangle extended class of Shape has <strong>a blueprint of properties of triangles and methods to find 
 * perimeter and area</strong>
 * @author Leeya310
 */
public class Triangle extends Shape {
	
	protected double leg1;
	protected double leg2;
	protected double base;
	protected double perimeter;
	protected double height;
	
	/**
	 * Takes <strong>2 sides, a base and a height to evaluate a triangle, overwriting the parent class</strong>
	 * @param leg1, as a double value of the side length of the triangle
	 * @param leg2, as a double value of the other side length of the triangle
	 * @param base, as a double value as the base of the triangle (perpendicular to height)
	 * @param height, as the height value of the triangle (perpendicular to base)
	 * @throws InvalidDimensionsException to handle negative and 0 inputs
	 */
	public Triangle (double leg1, double leg2, double base, double height) throws InvalidDimensionsException {
		this.leg1 = leg1;
		this.leg2 = leg2;
		this.base = base;
		this.height = height;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the triangle</strong> based on the base and 2 legs
	 * @return the perimeter of the triangle in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.leg1 <= 0 || this.leg2 <= 0 || this.base <= 0 || this.height <= 0) throw new 
		InvalidDimensionsException ("Dimensions input out of range for triangle. Please input double "
				+ "dimensions greater than 0.");
		if (this.leg1+this.leg2 <= this.base || this.leg1+this.base <= this.leg2 || this.leg2+this.base 
				<= this.leg1) throw new InvalidDimensionsException ("Dimensions correlate to invalid "
						+ "triangle. Make sure the sum of any two sides is greater than the third.");
		super.perimeter = this.leg1+this.leg2+this.base;
		return super.perimeter;
	}
	
	/**
	 * findArea() finds the <strong>area of the triangle</strong> based on the base and height
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