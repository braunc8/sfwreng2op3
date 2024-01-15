/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
 *
 * Write a java program, use "subroutine" to finish sorting a 2-dimension array.
 *
 * User input a 2-dimension array of double type, return it in non-decreasing
 * order according to values in the first raw, if there are two or more same
 * element in the first raw, keep the original sequence.
 *
 * INPUT: a user input 2-dimension array.
 * OUTPUT: sorted input array in non-decreasing order according to values in the first row.
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example 1
 * INPUT: if user input array (Order 2*4) is
 *        1.45  0.25  8.95  0.99
 *        2.56  5.67  0.47  2.65
 *
 * OUTPUT: 0.25  0.99  1.45  8.95
 *         5.67  2.65  2.56  0.47
 *
 * Example 2
 * INPUT: if user input array (Order 5*5) is
 *        0.95  0.23  0.95  0.95  0.65
 *        2.56  5.67  0.47  2.65  0.47
 *        1.45  0.25  8.95  0.99  0.67
 *        5.67  2.65  0.25  8.95  0.99
 *        1.23  4.21  0.97  7.64  8.52
 *
 * OUTPUT: 0.23  0.65  0.95  0.95  0.95
 *         5.67  0.47  2.56  0.47  2.65
 *         0.25  0.67  1.45  8.95  0.99
 *         2.65  0.99  5.67  0.25  8.95
 *         4.21  8.52  1.23  0.97  7.64
 *
 */

import cassArr.carr;

public class Q1_Sort2DArray {

    public static Double[][] sort(Double[][] arr){
        int i=0;
        boolean swap;

        do {
            Double temp;
            swap=false;
            for (int j = 0; j < (arr[0].length-i-1); j++) {//starts at the first element going until our new "end" each time
                if (arr[0][j] > arr[0][j + 1]) {//if the element is greater than the following element (in the first row)
                    for(int k=0;k<arr.length;k++){//it switches the two for all rows
                        temp = arr[k][j];
                        arr[k][j] = arr[k][j + 1];
                        arr[k][j + 1] = temp;
                    }
                    swap = true;//since a swap has occurred, the loop should continue
                }
            }
            i++;
        } while (i < (arr[0].length-1) && swap);//the amount of elements in the array we are checking, ends when no swaps have occurred
        return arr;
    }

    public static void main(String[] args) {
        Double[][] inputArr = carr.dInp2D();//takes the array
        Double[][] arr=sort(inputArr);//sorts the array according to the first row

        //prints the Array
        carr.print(arr);
    }

}