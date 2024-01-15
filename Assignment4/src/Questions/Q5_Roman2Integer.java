/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 5 (20 marks)
 *
 * Write a java program to convert Roman numbers to integer.
 * Roman numerals are represented by seven different symbols:
 * I, V, X, L, C, D and M
 *
 * Symbol   Value
 *   I        1
 *   V        5
 *   X        10
 *   L        50
 *   C        100
 *   D        500
 *   M        1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written
 * as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *  I can be placed before V (5) and X (10) to make 4 and 9.
 *  X can be placed before L (50) and C (100) to make 40 and 90.
 *  C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Input: Roman number (user input, string type)
 * Output: print out corresponding integer
 *
 * Example: if the user enters 'LVIII', the program should output 'LVIII -> 58'
 *
 */
package Questions;
import java.util.Scanner;
public class Q5_Roman2Integer {
    /* place your subroutine code here */
    public static int romanToInt(String input){
        char[] num = input.toCharArray();//creating a char array to be manipulated
        int total = 0;
        int[] vals = charToVal(num); //converts the character array to its roman values

        for (int i=0;i<vals.length;i++){ //goes through each of the numbers in vals
            int add=vals[i];
            if (i<(vals.length-1)){//only checks if it is not the last item in the array, because you always add the last item (see explaination)
                if (vals[i]<vals[i+1]){//if it is less than the value after it, it is subtracted instead of added
                    add = -1*add;//makes the value negative so it is subtracted instead of added to the total
                    /*EXPLAINATION
                    *this works because roman numbers always are written from highest value to lowest value,
                    *with the exception of sole preceeding numberals which are subtractive instead of additive
                    *to represent numbers of the type (10^(n)-10^(n-1)) OR ( 5*(10^(n)-10^(n-1))
                    *so, by checking if the number is less than its following, we know it must be subtracted instead
                    *of added to the total value*/
                }
            }
            total+=add; //adds or subtracts the value
        }
        return total;
    }
    public static int[] charToVal(char[] num){ //converts an array of characters to an array with the values of roman numebrals
        char[] roman = {'M', 'D', 'C', 'L','X','V', 'I'}; //the roman numberals and their corresponding values
        int[] romanVals = {1000, 500,100,50,10,5,1};
        int[] vals = new int[num.length]; //making an empty array for the integers

        for (int i=0;i<num.length;i++){ //goes thru each of the characters in the numberal array, and checks their value and adds it to the value array
            for (int j=0;j<roman.length;j++){
                if (num[i]==roman[j]){
                    vals[i]=romanVals[j];
                }
            }
        }
        return vals;
    }

    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);//gathering my inputs
        System.out.println("Please input a roman numberal: ");
        String input = myScan.nextLine();

        System.out.println(romanToInt(input));//prints final value
    }
}
