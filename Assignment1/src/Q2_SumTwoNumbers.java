/* Assignment 1 (100 marks in total; 5% of the final score of this course) 
 * 
 * Question 2 (20 marks)
 * 
 * Write a Java program to print the sum of two user input integer numbers.
 * Also submit a screenshot to demonstrate that you have successfully ran
 * javac and java commandline to compile and run the code of Q1_HelloWorld.java
 * 
 * INPUT: two user input integer numbers
 * OUTPUT: the sum of the two user input integer numbers
 * 
 * Hint1: you may use java.util.Scanner to take user input numbers.
 * 
 */

import java.util.Scanner;


public class Q2_SumTwoNumbers {
	public static void main(String[] args) {
		Scanner my_scanner = new Scanner(System.in); //creating a scanner object to use later

		System.out.println("Please input an integer: "); //collecting the integers from user
		int num1 = my_scanner.nextInt();
		System.out.println("Please input another integer: ");
		int num2 = my_scanner.nextInt();

		int sum = num1 + num2; //calculating and printing sum
		System.out.println("The sum of your integers is: " + sum);
			}
		}
