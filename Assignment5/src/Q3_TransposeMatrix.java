/* Assignment 5 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (30 marks)
 *
 * Write a java program to compute the transpose of a user input matrix,
 * whose elements are all integers.
 *
 * Converting rows of a matrix into columns and columns of a matrix into
 * row is called transpose of a matrix.
 *
 * INPUT: user input matrix (2D array).
 * OUTPUT: the transpose of input matrix.
 *
 * Note: considering how to take users' input, you can set some rules
 * (give users some hints) to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * INPUT: 4  6  8
 *        5  8  9
 *        2  1  8
 *
 * OUTPUT: 4  5  2
 *         6  8  1
 *         8  9  8
 *
 */

import java.util.Scanner;

public class Q3_TransposeMatrix {
    /* place your subroutine code here */
    public static int[][] matrixMaker(String input){
        char[] inputArray = input.toCharArray();

        //gets number of rows
        int numRows =1;
        for (int i=0;i<inputArray.length;i++){
            if(inputArray[i]==';'){
                numRows++;
            }
        }

        //gets number of columns
        int numCols=0;
        int k=0;
        while(k<inputArray.length && inputArray[k]!=59){
            if(inputArray[k]!=32){
                numCols++;
            }
            k++;
        }

        int[][] regRows=new int[numRows][numCols];
        int currentRow=0;
        int currentCol=0;

        for (char c : inputArray) {

            if (c == ';') {
                //regRows[currentRow] = regCols;
                currentRow++;
                //System.out.println("crow: "+currentRow);
                currentCol = 0;
            } else if (c != ' ') {
                //System.out.println(c);
                regRows[currentRow][currentCol] = c-48;
                currentCol++;

            }
        }
        return regRows;
    }

    public static int[][] transposer(int[][] arr){
        int[][] newArr= new int[arr[0].length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                newArr[j][i]=arr[i][j];
            }
            System.out.println();
        }
        return newArr;
    }
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Please input your array with your row values separated by spaces and indicating a new row with a semicolon\nExample:\n 1 2 3;4 5 6;7 8 9"); //asking for the size of the array and creating one of that size
        String input = myScan.nextLine();
        int[][] arr =matrixMaker(input);
        int[][] tarr =transposer(arr);
        
        for(int i=0;i<tarr.length;i++){
            for(int each:tarr[i]){
                System.out.print(" " + each);
            }
            System.out.println();
        }

    }
}
