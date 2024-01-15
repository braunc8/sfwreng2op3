/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (30 marks)
 *
 * Write a subroutine, user input an 1D array of integers and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * INPUT: user input array and target
 * OUTPUT: the indices of the two numbers such that they add up to target.
 *
 * The array and target are parameters to the subroutine.
 * User can get hint to input array and target number, respectively.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example:
 * INPUT: [2,7,11,15], 9
 * OUTPUT: [0,1]
 *
 */

import java.util.Scanner;

public class Q2_TwoSum {
    /* place your subroutine code here */
    public static int[] indexGiver(int[] arr, int sum){
        int[] indices= new int[2];
        for (int i=0;i<arr.length;i++){
            for (int j=(i+1);j<arr.length;j++){
                if((arr[j]+arr[i])==sum){
                    indices[0]=i;
                    indices[1]=j;
                }
            }
        }
        return indices;
    }


    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Please input your array and target sum in the following format: [2,7,11,15], 9"); //asking for the size of the array and creating one of that size
        String input = myScan.nextLine();
        char[] arrayInt = input.toCharArray();
        int index = 0;
        while (index < arrayInt.length && arrayInt[index] != ']') {
            index++;
        }
        int[] searchArray = new int[index/2+1];
        int searchIndex = 0;
        for (int i=0;i<(index);i++) {//fix if time
            if (arrayInt[i] != 91 && arrayInt[i] != 44) {
                int add = Character.getNumericValue(arrayInt[i]);
                searchArray[searchIndex] = add;
                searchIndex++;
            }
        }
        char inputSum = arrayInt[arrayInt.length - 1];
        int sum = Character.getNumericValue(inputSum);
        int[] indices=indexGiver(searchArray, sum);
        System.out.println("["+indices[0]+","+indices[1]+"]");
    }
}
