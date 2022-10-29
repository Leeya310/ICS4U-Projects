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
 * The Ellipse extended class of Shape has <strong>a blueprint of properties of ellipses and methods to find 
 * circumference and area</strong>
 * @author Leeya310
 */
public class Ellipse extends Shape {
	
	protected double radius;
	protected double radius2;
	
	/**
	 * Takes the <strong>two radii and overwrites the parent class</strong>
	 * @param radius is a double value as an axis radius of the ellipse
	 * @param radius2 is a double value as the other axis radius of the ellipse
	 */
	public Ellipse (double radius, double radius2) {
		this.radius = radius;
		this.radius2 = radius2;
	}
	
	/**
	 * findPerimeter() finds the <strong>circumference of the ellipse</strong> based on the radii
	 * @return the circumference of the ellipse in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		if (this.radius <= 0 || this.radius2 <= 0) throw new InvalidDimensionsException ("Dimensions input out "
				+ "of range for ellipse. Please input double dimensions greater than 0.");
		double h = Math.pow((this.radius-this.radius2), 2) / Math.pow((this.radius+this.radius2), 2);
		super.perimeter = Math.PI*(this.radius + this.radius2)*(1+(3*h)/(10+Math.sqrt(4-3*h)));
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the ellipse</strong> based on the radii
	 * @return the area of the circle in square units
	 */
	public double findArea() {
		super.area =this.radius*this.radius2*Math.PI;
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