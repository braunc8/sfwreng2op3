/* Assignment 4 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (20 marks)
 *
 * Use a "subroutine" and a lambda expression to implement function
 * f(x,y) = sqrt(x*x-y*y), both x and y are real numbers.
 * Meanwhile, your code can throw an IllegalException (custom run-time exception,
 * which can be one provided by Java) if the value of (x*x-y*y) is negative.
 *
 * INPUT: the value of x and y (user input)
 * OUTPUT: the value of sqrt(x*x-y*y)
 *
 * Note: output must be displayed using four significant digits after decimal point.
 *
 */
package Questions;
import myFun.miniMath;

import java.util.Scanner;

public class Q2_LambdaExpression {
    static miniMath squared = (x)->{return x*x;};//this object returns x^2
    public static double sqrt(double x, double y){
        double ans = squared.valueAt(x) - squared.valueAt(y);//computes the value of x^2-y^2, and if less than zero, throws an exception statement
        if (ans<0){
            throw new IllegalArgumentException("IllegalArgumentException -> x^2 needs to be bigger than y^2");
        }

        ans = Math.sqrt(ans);//then computes the square root and returns that value
        return ans;
    }
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);//gathering my inputs
        System.out.println("Please input a number: ");
        double x = myScan.nextDouble();
        System.out.println("Please input another number: ");
        double y = myScan.nextDouble();

        try{//tries to compute the value and returns an error if it is not possible
            double val = sqrt(x,y);
            System.out.printf("Your value is %1.4f", val);
        }catch (IllegalArgumentException sqrtError){
            System.out.println(sqrtError.getMessage());
        }

    }
}
