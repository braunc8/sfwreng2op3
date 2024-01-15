/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
    Write a Java program to print integer numbers between 1 to a user input integer n, which are divisible by 3, 5 and by both.

 * INPUT: a user input integer n
 * OUTPUT: all the integer numbers between 1 and n that are either divisible by 3 or by 5 or by both.

* Hint: For n=16, the output should be as follows.
    Divided by 3 -> 3, 6, 9, 12, 15.
    Divided by 5 -> 5, 10, 15.
    Divided by 3 and 5 -> 15.
 */

import java.util.Scanner;

public class Q4_FindNumbers {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int input = myScan.nextInt();

        //establishing arrays to iterate through
        int[] divList = new int[]{3,5,15};
        String[] titleList = new String[]{"3","5","3 and 5"};
        String[] ansList = new String[]{"","",""};

        for (int i = 1; i<=input;i++){// iterates through all integers 1 to n
            for (int j=0;j<3;j++){//tests if it is divisible by 3, then 5, then 3 and 5
                if (i%divList[j]==0) { //if it is divisible by the specified number, it adds to the specific list
                    ansList[j] += ", " + i;
                }
            }
        }
        for (int i=0; i<(ansList.length);i++){ //removes the unnecessary starting ", " for every item in ansList, then prints
            ansList[i] = ansList[i].substring(2);
            System.out.println("Divided by "+titleList[i]+" -> " + ansList[i] + ".");
        }
    }
}
