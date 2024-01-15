

/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 4 (20 marks)
 *
 * Write a java program to use Method Overloading for printing three types of array:
 * Integer[], Character[] and Double[].
 *
 * Input: None.
 * Output: print out different types of array.
 *
 * There is no specific format as long as printed arrays are neatly and cleanly.
 *
 */
package Questions;
public class Q4_PrintArray {
    // creating a method for printing integer array
    /* place your code here */
    public static void arrayPrint(Integer[] A){
        System.out.print("[" +A[0]);//making the start of my array

        for (int i=1;i<A.length;i++){//for each element in the array past the first element
            System.out.print(", " + A[i]);//print a comma, space and the variable at that location
        }
        System.out.println("]");//finish off the array, and adds a new line at the end
    }
    // overloading the above created method with different parameter method
    // contains a character parameter
    public static void arrayPrint(Character[] A){//same as Integer array method, but accepts Character array
        System.out.print("[");
        System.out.print(A[0]);
        for (int i=1;i<A.length;i++){
            System.out.print(", " + A[i]);
        }
        System.out.println("]");
    }
    // overloading the above created method with different parameter method
    // contains a double parameter
    public static void arrayPrint(Double[] A){//see Character arrayPrint :)
        System.out.print("[");
        System.out.print(A[0]);
        for (int i=1;i<A.length;i++){
            System.out.print(", " + A[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Integer[] iarr = {1,2,3,4,5};
        Character[] carr = {'A','B','C','D','E'};
        Double[] darr = {1.234, 2.345, 3.456, 4.567};

        // calling the methods and printing the arrays
        /* place your code here */
        System.out.println("Here is your integer array: ");
        arrayPrint(iarr);
        System.out.println("Here is your character array: ");
        arrayPrint(carr);
        System.out.println("Here is your Double array: ");
        arrayPrint(darr);

    }
}
