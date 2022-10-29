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

.------..------..------..------..------.
|L.--. ||E.--. ||E.--. ||Y.--. ||A.--. |
| :/\: || (\/) || (\/) || (\/) || (\/) |
| (__) || :\/: || :\/: || :\/: || :\/: |
| '--'L|| '--'E|| '--'E|| '--'Y|| '--'A|
`------'`------'`------'`------'`------'

------------------------------------------------------------------------------------------------------------------*/

/**
 * The Trapezoid extended class of Quadrilateral has <strong>a blueprint of properties of trapezoids and methods 
 * to find perimeter and area</strong>
 * @author Leeya310
 */
public class Trapezoid extends Quadrilateral {
	
	/**
	 * Takes <strong>2 bases, a height and 2 legs to evaluate a trapezoid, overwriting the parent class</strong>
	 * @param base1, double value for a side length that is one of the bases (perpendicular to height)
	 * @param base2, double value for the side length that is the other base (perpendicular to height)
	 * @param height1, double value length of a perpendicular from base to highest point of the other base 
	 * (perpendicular to base)
	 * @param width1, double value for a side width (leg of trapezoid)
	 * @param width2, double value for another side width (other leg of trapezoid)
	 */
	public Trapezoid (double base1, double base2, double height1, double width1, double width2) {
		super(base1, base2, height1, width1, width2, 0, 0);
		this.base1 = base1;
		this.base2 = base2;
		this.height1 = height1;
		this.width1 = width1;
		this.width2 = width2;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the trapezoid</strong> based on the 2 bases and 2 widths
	 * @return the perimeter of the trapezoid in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		double[] dimensions = {this.base1, this.base2, this.height1, this.width1, this.width2};
		for (int i = 0; i < dimensions.length-1; i++) {
			if (dimensions[i] <= 0) throw new InvalidDimensionsException ("Dimensions input out of range for "
					+ "trapezoid. Please input double dimensions greater than 0.");
		}
		super.perimeter = this.base1 + this.base2 + this.width1 + this.width2;
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the trapezoid</strong> based on the 2 bases and height of 
	 * overall trapezoid
	 * @return the area of the square in square units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findArea() {
		super.area = ((this.base1+this.base2)/2)*this.height1;
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
