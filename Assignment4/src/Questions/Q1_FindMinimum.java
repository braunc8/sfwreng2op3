/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a Java program, use 'subroutine' to finds the minimum value of
 * the first N elements of an array of type int.
 * Meanwhile, your code can throw an IllegalException (custom run-time
 * exception, which can be one provided by Java) if N is not in the range
 * of the length of input array.
 *
 * Input: user input array and number N.
 * Output: the minimum value of the first N elements of the array.
 *
 * Note: The array and N are parameters to the subroutine.
 * Users will input an array with no specific length.
 *
 */
package Questions;
import java.util.Scanner;

public class Q1_FindMinimum {
    /* place your subroutine code here */
    public static int miniNum(int[] A, int N){
        if (N>A.length){//error statement if subset N is larger than set A
            throw new IllegalArgumentException("IllegalArgumentException -> The amount of integers to be checked is larger than the array.");
        }
        int min = A[0];//establishes the "minimum" value as the first in the array
        for (int i=0;i<N;i++){//goes through each item in the subset and if it smaller than the minimum, it becomes the new minimum to be checked
            if (A[i]<min){
                min=A[i];
            }
        }
        return min; //returns the minimum after checking all the values
    }

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Please input the size of your array: "); //asking for the size of the array and creating one of that size
        int arraySize = myScan.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0;i<arraySize;i++){//adding items to the array one at a time
            System.out.println("Please input an integer for your array: ");
            array[i] =myScan.nextInt();
        }

        System.out.println("Please input the amount of integers you want to check: "); //asking for the amount of numbers to check
        int N = myScan.nextInt();

        try{//tries to find the minimum value in the given subset, but if the subset is larger than the set, returns an error message
            int min = miniNum(array,N);
            System.out.println("The lowest value found in the first " + N + " places of your array is: " + min);
        }catch(IllegalArgumentException largeN){
            System.out.println(largeN.getMessage());
        }
    }
}


