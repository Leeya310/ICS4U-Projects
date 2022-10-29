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
 * The Quadrilateral extended class of Shape has <strong>a blueprint of properties of quadrilaterals and 
 * methods to find perimeter and area</strong>
 * @author Leeya310
 */
public class Quadrilateral extends Shape {
	
	protected double base1;
	protected double base2;
	protected double diagonal1;
	protected double height1;
	protected double height2;
	protected double width1;
	protected double width2;
	
	/**
	 * Takes <strong>2 side lengths, 2 side widths, a diagonal and 2 heights to evaluate a quadrilateral, 
	 * overwriting the parent class</strong>
	 * @param base1, double value for a side length (perpendicular to height of overall shape)
	 * @param base2, double value for another side length (perpendicular to height of overall shape)
	 * @param diagonal1, double value for the diagonal distance between opposite vertexes (perpendicular 
	 * to both heights of inner triangles)
	 * @param height1, double value length of a perpendicular from a remaining vertex to the diagonal 
	 * (height of inner triangle 1)
	 * @param height2, double value length of a perpendicular from the remaining vertex to the diagonal 
	 * (height of inner triangle 2)
	 * @param width1, double value for a side width 
	 * @param width2, double value for another side width
	 */
	public Quadrilateral (double base1, double base2, double diagonal1, double height1, double height2, 
			double width1, double width2) {
		this.base1 = base1;
		this.base2 = base2;
		this.diagonal1 = diagonal1;
		this.height1 = height1;
		this.height2 = height2;
		this.width1 = width1;
		this.width2 = width2;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the quadrilateral</strong> based on the 2 lengths 
	 * and 2 widths
	 * @return the perimeter of the quadrilateral in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		double[] dimensions = {this.base1, this.base2, this.diagonal1, this.height1, this.height2, 
				this.width1, this.width2};
		for (int i = 0; i < dimensions.length-1; i++) {
			if (dimensions[i] <= 0) throw new InvalidDimensionsException ("Dimensions input out of range "
					+ "for quadrilateral. Please input double dimensions greater than 0.");
		}
		if (this.base1+this.base2+this.width1 <= this.width2 || this.base1+this.base2+this.width2 <= 
				this.width1  || this.base2+
				this.width1+this.width2 <= this.base1 || this.base1+this.width1+this.width2 <= 
				this.base2) throw new InvalidDimensionsException ("Dimensions correlate to invalid "
						+ "quadrilateral. Make sure the sum of any three sides is greater than the fourth.");
		super.perimeter = this.base1 + this.base2 + this.width1 + this.width2;
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the quadrilateral</strong> based on the diagonal and perpendicular 
	 * heights
	 * @return the area of the quadrilateral in square units
	 */
	public double findArea() {
		super.area = 0.5*(this.diagonal1)*(this.height1+this.height2);
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
