/* Assignment 1 (100 marks in total; 5% of the final score of this course) 
 * 
 * Question 4 (20 marks)
 * 
 * Write a Java program to print the area and perimeter of a circle.
 * Also submit a screenshot to demonstrate that you have successfully ran
 * javac and java commandline to compile and run the code of Q1_HelloWorld.java
 * 
 * INPUT: radius input by a user.
 * OUTPUT: the area and the perimeter of the circle defined by the radius. All results must use two significant digits after decimal point.
 * 
 * Hint: you may use java.util.Scanner to take user input real valued radius.
 * 
 */

import java.util.Scanner;

public class Q4_AreaOfCircle {
	public static void main(String[] args) {
		Scanner my_scanner = new Scanner(System.in); //creating a new scanner object

		System.out.println("Please input a radius: "); //collecting our radius
		double rad = my_scanner.nextDouble();

		double perimeter = 2*Math.PI*rad; //performing calculations
		double area = Math.PI*(Math.pow(rad, 2));

		System.out.printf("The area of the circle is: %1.2f\n", area); //printing our results
		System.out.printf("The perimeter of the circle is: %1.2f\n", perimeter);


	}
}
