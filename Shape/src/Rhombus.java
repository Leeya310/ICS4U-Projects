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
 * The Rhombus extended class of Quadrilateral has <strong>a blueprint of properties of rombuses and methods to 
 * find perimeter and area</strong>
 * @author Leeya310
 */
public class Rhombus extends Quadrilateral {
	
	private double diagonal2;
	
	/**
	 * Takes the value of the <strong>side length and a diagonal to evaluate a rhombus, overwriting the parent 
	 * class</strong>
	 * @param base1, double value for the value of the equal side lengths
	 * @param diagonal1, double value for the diagonal distance between opposite vertexes
	 */
	public Rhombus (double base1, double diagonal1) {
		super(base1, diagonal1, 0, 0, 0, 0, 0);
		this.base1 = base1;
		this.diagonal1 = diagonal1;
	}
	
	/**
	 * findPerimeter() finds the <strong>perimeter of the rhombus</strong> based on the side length
	 * @return the perimeter of the rhombus in units
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public double findPerimeter() throws InvalidDimensionsException {
		this.diagonal2 = 2*(Math.sqrt(Math.pow(base1, 2) - Math.pow(this.diagonal1/2, 2)));
		double[] dimensions = {this.base1, this.diagonal1, this.diagonal2};
		for (int i = 0; i < dimensions.length-1; i++) {
			if (dimensions[i] <= 0) throw new InvalidDimensionsException ("Dimensions input out of range for "
					+ "rhombus. Please input double dimensions greater than 0.");
		}
		if (base1 <= diagonal1/2 || base1 <= diagonal2/2) throw new InvalidDimensionsException ("Dimensions correlate to invalid "
				+ "rhombus. Make sure half of the vertex to opposite vertex length is less than the base.");
		super.perimeter = 4*this.base1;
		return super.perimeter;
	}

	/**
	 * findArea() finds the <strong>area of the rhombus</strong> based on the diagonal vertex to opposite 
	 * vertex lengths
	 * @return the area of the rhombus in square units
	 */
	public double findArea() {
		super.area = (this.diagonal1*this.diagonal2)/2;
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