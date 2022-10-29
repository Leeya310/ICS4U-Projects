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
 * The Circle extended class of Ellipse has <strong>a blueprint of properties of circles and methods to find 
 * circumference and area</strong>
 */
public class Circle extends Ellipse {
	
	/**
	 * Takes the <strong>radius and overwrites the parent class</strong>
	 * @param radius 
	 * @param radius is a double value that is taken as the radius of the circle
	 */
	
	public Circle (double radius) {
		super(radius, radius);
		this.radius = radius;
	}
	
	/**
	 * findPerimeter() finds the <strong>circumference of the circle</strong> based on the radius
	 * @return the circumference of the circle in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.radius <= 0 || this.radius2 <= 0) throw new InvalidDimensionsException ("Dimensions input out "
				+ "of range for circle. Please input double dimensions greater than 0.");
		super.perimeter = Math.PI*(2*this.radius);
		return super.perimeter;
	}
	
	/**
	 * findArea() finds the <strong>area of the circle</strong> based on the radius
	 * @return the area of the circle in square units
	 */
	public double findArea() {
		super.area = Math.PI*Math.pow(this.radius, 2);
		return super.area;
	}
	
	/**
	 * This <strong>overwrites the parent method and calls it to output</strong> circumference and area
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