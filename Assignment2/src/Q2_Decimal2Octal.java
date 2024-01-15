/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
    Write a Java program to convert a decimal number to octal number.

    Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. It is also called base-ten positional numeral system.
    Octal number: The octal numeral system is the base-8 number system, and uses the digits 0 to 7.


 * INPUT: a user input decimal number x
 * OUTPUT: an octal number y converted from x

* Hint: For a decimal number x=1256, the corresponding octal number is y=2350.
 */

import java.util.Scanner;

public class Q2_Decimal2Octal {
    public static void main(String args[]) {
        Scanner myScanner = new Scanner(System.in);//taking user input
        System.out.println("Please input a decimal number to be converted to an octal number: ");
        int userInput = myScanner.nextInt();

        System.out.print("The number: \"" + userInput + "\" in octal is: ");

        int exponent = 0;//this exponent will be used to determine the column of the remainder
        int octal = 0;

        while (userInput>0) {//determines individual digits for the columns of the numbers and adds them up
            int octalDigit = userInput % 8; //finding the particular column digit for the octal

            octalDigit *= Math.pow(10, exponent);//making sure the column of our digit is correct
            exponent++;
            octal += octalDigit; //adding the column value to the octal number

            userInput /= 8;
        }
        System.out.println("\"" + octal + "\"");
    }
}
