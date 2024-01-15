/* Assignment 2 (100 marks in total; 5% of the final score of this course)
 *
 * Question 1 (20 marks)
    Write a Java program to find the value of following expression.
    a) (101 + 0) / 3
    b) 3.0e-6 * 10000000.1
    c) true && true
    d) false && true
    e) (false && false) || (true && true)
    f) (false || false) && (true && true)

 * INPUT: n/a
 * OUTPUT: the value of each of the above expressions.

 */

public class Q1_ExpressionSolution {
    public static void main(String[] args) {
        double vala = (100+0)/3;
        double valb = 3.0*Math.pow(10,-6)*(10000000.1);
        boolean valc = true&&true;
        boolean vald = false&&false;
        boolean vale = (false&&false)||(true&&true);
        boolean valf = (false||false)&&(true||true);

        System.out.println("The answer to a is: " + vala);
        System.out.println("The answer to b is: " + valb);
        System.out.println("The answer to c is: " + valc);
        System.out.println("The answer to d is: " + vald);
        System.out.println("The answer to e is: " + vale);
        System.out.println("The answer to f is: " + valf);
    }
}
