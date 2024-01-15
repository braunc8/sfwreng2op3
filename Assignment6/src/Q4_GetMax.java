/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
 *
 * Write a complete static method that finds the largest value in a 2-dimension array of ints.
 * The method should have one parameter, which is a 2d array of type int. The largest number
 * in the array should be returned as the value of the method.
 *
 * INPUT: user input a 2-dimension array of type int
 * OUTPUT: the largest number in input array
 *
 * Note: considering how to take users' input, you can set some rules (give users some hints)
 * to make your code user-friendly.
 * User will follow your instruction to input test example.
 *
 * Example:
 * Input: 4  6  8
 *        5  8  9
 *        2  1  8
 * Output: 9
 *
 */
import cassArr.carr;
public class Q4_GetMax {

    //finds the max
    public static int max(int[][] arr){
        int maxi=0;//sets the initial max as the first element
        int maxj=0;

        //goes through each element in the matrix, looking for a new higher value and resetting the max indices when it finds a new max
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[maxi][maxj]<arr[i][j]){
                    maxi=i;
                    maxj=j;
                }
            }
        }
        return arr[maxi][maxj];//returns the max value
    }



    public static void main(String[] args) {
        int[][] input = carr.iInp2D();//takes the input array
        int max=max(input);//finds the max and assigns it to a variable
        System.out.print("Here is your maximum value in the given matrix: "+ max);
    }
}
