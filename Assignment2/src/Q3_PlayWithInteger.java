/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
    Write a Java program that accepts an integer (n, 0 <= n <= 9) and computes the value of n+nn+nnn.

 * INPUT: a user input integer n
 * OUTPUT: the value of n+nn+nnn.

* Hint: For n=2, the output is 2+22+222=246
 */

import java.util.Scanner;

public class Q3_PlayWithInteger {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int total = 0;
        int exponent;
        int column;

        System.out.println("Please input a number: ");
        int val = myScanner.nextInt();

        for (column = 2; column>-1;column--) //starts by making the largest number and adding it to total, then increments down
            for (exponent = column; exponent>-1; exponent--){
                int num= (int) (val*Math.pow(10,exponent));
                total+=num;
            }

        System.out.println("Your new value is: " + total);
    }
}
