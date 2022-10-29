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
 * The ShapeInputOutput class is a <strong>testing class for the Shape class to use abstract methods and 
 * polymorphism to find 2D 
 * perimeters and areas</strong>
 * @author Leeya310
 */
public class ShapeInputOutput {

	//Main Method
	public static void main(String[] args) throws InvalidDimensionsException {
		try {
			//Create objects for each shape
			Ellipse ellip1 = new Ellipse(2, 14);
			Ellipse cir1 = new Circle(3);
			Triangle tri1 = new Triangle(3, 5, 6, 4);
			Triangle rightTri1 = new RightAngledTriangle(7, 9);
			Triangle isosTri1 = new Isoscles(5, 2, 4);
			Quadrilateral quad1 = new Quadrilateral(4, 3, 5, 6, 2, 4, 3);
			Quadrilateral rec1 = new Rectangle(3, 4);
			Rectangle squ1 = new Square(4);
			Quadrilateral rho1 = new Rhombus(4, 6);
			Quadrilateral trap1 = new Trapezoid(5, 2, 3, 6, 4);
			
			//Print ellipse
			System.out.print("--------------------------------------------------------");
			System.out.println("\nEllipse: \nInputted radius = " + ellip1.radius + " units\nInputted radius 2 = " 
			+ ellip1.radius2 + " units");
			ellip1.printInfo();
			
			//Print circle
			System.out.print("--------------------------------------------------------");
			System.out.println("\nCircle: \nInputted radius = " + cir1.radius + " units");
			cir1.printInfo();
			
			//Print triangle
			System.out.print("--------------------------------------------------------");
			System.out.println("\nTriangle: \nInputted side length 1 = " + tri1.leg1 + " units\nInputted side "
					+ "length 2 = " + tri1.leg2 + " units\nInputted base = " + tri1.base + " units\nInputted "
							+ "height = " +  tri1.height + " units");
			tri1.printInfo();
			
			//Print right angled triangle
			System.out.print("--------------------------------------------------------");
			System.out.println("\nRight Angled Triangle: \nInputted base = " + rightTri1.base + " units\nInputted "
					+ "height =  " + rightTri1.height + " units");
			rightTri1.printInfo();
			
			//Print isoscles triangle
			System.out.print("--------------------------------------------------------");
			System.out.println("\nIsoscles Triangle: \nInputted equal legs =  " + isosTri1.leg1 + " units\nInputted "
					+ "base =  " + isosTri1.base + " units\nInputted height = " + isosTri1.height + " units");
			isosTri1.printInfo();
			
			//Print quadrilateral
			System.out.print("--------------------------------------------------------");
			System.out.println("\nGeneral Quadrilateral: \nInputted base 1 = " + quad1.base1 + " units\nInputted "
					+ "base 2 = " + quad1.base2 + " units\nInputted width 1 = " + quad1.width1 + " "
					+ "units\nInputted width 2 = " + quad1.width2 + " units\nInputted diagonal vertex "
					+ "length = " + quad1.diagonal1 + " units\nInputted perpendicualr height "
					+ "1 = " + quad1.height1 + " units\nInputted perpendicular height 2 "
					+ "= " + quad1.height2 + " units");
			quad1.printInfo();
			
			//Print rectangle
			System.out.print("--------------------------------------------------------");
			System.out.println("\nRectangle: \nInputted base = " + rec1.base1 + " units\nInputted width = " + 
			rec1.width1 + " units");
			rec1.printInfo();
			
			//Print square
			System.out.print("--------------------------------------------------------");
			System.out.println("\nSquare: \nInputted base = " + squ1.base1 + " units");
			squ1.printInfo();
			
			//Print rhombus
			System.out.print("--------------------------------------------------------");
			System.out.println("\nRhombus: \nInputted base = " + rho1.base1 + " units\nInputted opposite vertex "
					+ "to vertex length 1 = " + rho1.diagonal1 + " units");
			rho1.printInfo();
			
			//Print trapezoid
			System.out.print("--------------------------------------------------------");
			System.out.println("\nTrapezoid: \nInputted base 1 = " + trap1.base1 + " units\nInputted base 2 = " 
			+ trap1.base2 + " units\nInputted height = " + trap1.height1 + " units\nInputted width1 = " + trap1.width1 
			+ " units\nInputted width 2 = " + trap1.width2 + " units");
			trap1.printInfo();
			System.out.println("--------------------------------------------------------");
		}
		catch (InvalidDimensionsException e) { //if the input is less than 0 or constitutes an invalid polynomial
			System.out.println (e.getMessage());
			System.exit(0);
		}
	}
}

/*
										    ___
										   /   \             
										  /_____\
										 / \ A / \
										/___\_/___\
*/
