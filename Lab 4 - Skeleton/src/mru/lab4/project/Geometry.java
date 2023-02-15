package mru.lab4.project;

import java.util.Scanner;

/**
 * This program demonstrates methods
 */

public class Geometry {
	
	public void runApplication() {
		int choice; // The user's choice
		double value = 0; // The method's return value
		char letter; // The user's Y or N decision
		double radius; // The radius of the circle
		double length; // The length of the rectangle
		double width; // The width of the rectangle
		double height; // The height of the triangle
		double base; // The base of the triangle
		double side1; // The first side of the triangle
		double side2; // The second side of the triangle
		double side3; // The third side of the triangle

		// Create a scanner object to read from the keyboard
		Scanner keyboard = new Scanner(System.in);

		// The do loop allows the menu to be displayed first
		do {
			// TASK #2 Call the printMenu method

			choice = keyboard.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter the radius of " + "the circle: ");
				radius = keyboard.nextDouble();

				// TASK #4 Call the circleArea method and
				// store the result in the value variable

				System.out.println("The area of the " + "circle is " + value);
				break;
			case 2:
				System.out.print("Enter the length of " + "the rectangle: ");
				length = keyboard.nextDouble();
				System.out.print("Enter the width of " + "the rectangle: ");
				width = keyboard.nextDouble();

				// TASK #4 Call the rectangleArea method and
				// store the result in the value variable

				System.out.println("The area of the " + "rectangle is " + value);
				break;
			case 3:
				System.out.print("Enter the height of " + "the triangle: ");
				height = keyboard.nextDouble();
				System.out.print("Enter the base of " + "the triangle: ");
				base = keyboard.nextDouble();

				// TASK #4 Call the triangleArea method and
				// store the result in the value variable

				System.out.println("The area of the " + "triangle is " + value);
				break;
			case 4:
				System.out.print("Enter the radius of " + "the circle: ");
				radius = keyboard.nextDouble();

				// TASK #4 Call the circumference method and
				// store the result in the value variable

				System.out.println("The circumference " + "of the circle is " + value);
				break;
			case 5:
				System.out.print("Enter the length of " + "the rectangle: ");
				length = keyboard.nextDouble();
				System.out.print("Enter the width of " + "the rectangle: ");
				width = keyboard.nextDouble();

				// TASK #4 Call the perimeter method and
				// store the result in the value variable

				System.out.println("The perimeter of " + "the rectangle is " + value);
				break;
			case 6:
				System.out.print("Enter the length of " + "side 1 of the " + "triangle: ");
				side1 = keyboard.nextDouble();
				System.out.print("Enter the length of " + "side 2 of the " + "triangle: ");
				side2 = keyboard.nextDouble();
				System.out.print("Enter the length of " + "side 3 of the " + "triangle: ");
				side3 = keyboard.nextDouble();

				// TASK #4 Call the perimeter method and
				// store the result in the value variable

				System.out.println("The perimeter of " + "the triangle is " + value);
				break;
			default:
				System.out.println("You did not enter " + "a valid choice.");
			}
			keyboard.nextLine(); // Consume the new line

			System.out.println("Do you want to exit " + "the program (Y/N)?: ");
			String answer = keyboard.nextLine();
			letter = answer.charAt(0);

		} while (letter != 'Y' && letter != 'y');
	}

	// TASK #2 Create the printMenu method here

	// TASK #3 Create the value-returning methods here

	// TASK #5 Write javadoc comments for each method
}