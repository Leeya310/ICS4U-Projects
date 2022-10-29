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
 * The Shape class is a <strong>blueprint for 2D shapes and their properties to find their perimeters and 
 * areas</strong>
 * @author Leeya310
 */
public abstract class Shape {
	
	protected double perimeter;
	protected double area;

	/**
	 * findPerimeter() finds the <strong>perimeter of the shape</strong> based on its properties
	 * @throws InvalidDimensionsException to handle negative or zero value inputs
	 */
	public abstract double findPerimeter() throws InvalidDimensionsException;
	
	/**
	 * findArea() finds the <strong>area of the shape</strong> based on its properties
	 */
	public abstract double findArea();
	
	/**
	 * This <strong>calls to output</strong> circumference and area
	 * @throws InvalidDimensionsException to handle negative or zero inputs
	 */
	protected void printInfo() throws InvalidDimensionsException {
		System.out.println("Perimeter = " + findPerimeter() + " units" + "\nArea = " + findArea() + " units^2");
	}
}

/*
											    ___
											   /   \             
											  /_____\
											 / \ A / \
											/___\_/___\
*/
