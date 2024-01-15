/* Assignment 1 (100 marks in total; 5% of the final score of this course) 
 * 
 * Question 5 (20 marks)
 * 
 * Write a Java program to display the following pattern.
 * 
 * INPUT: n/a
 * OUTPUT: the following pattern of JAVA.
 
 
	   J    a   v     v  a                                                  
	   J   a a   v   v  a a                                                 
	J  J  aaaaa   V V  aaaaa                                                
	 JJ  a     a   V  a     a
 
 */
/*
import java.util.Arrays;
import java.util.List;
*/


public class Q5_PrintPattern {
	public static void main(String[] args) { //there are 3 different ways to print the pattern in this code, i have commented out the second two
        //way 1
        System.out.println("\t   J    a   v     v  a"); //printing the exact pattern line by line
        System.out.println("\t   J   a a   v   v  a a");
        System.out.println("\tJ  J  aaaaa   V V  aaaaa");
        System.out.println("\t JJ  a     a   V  a     a");
/*
        //way 2
        List<String> js = Arrays.asList("   J", "   J", "J  J"," JJ "); //creating each part of the pattern as an individual segment
        String space1 = "    ";
        List<String> as = Arrays.asList("a", "a a", "aaaaa","a     a");
        String space2 = "   ";
        List<String> vs = Arrays.asList("v     v", "v   v", "V V","V");
        String space3 = "  ";

        for (int i= 0; i<4;i++){ //iterates through the total number of lines, printing each line as specified
            System.out.println("\t"+ js.get(i)+space1+as.get(i)+space2+vs.get(i)+space3+as.get(i));
            space1 = space1.substring(0, space1.length() - 1); //removes one character space from variable space1
        }
        //way 3
        List<String> j1s = Arrays.asList("\t   J    ", "\t   J   ", "\tJ  J  ","\t JJ  "); //establishing variables as a list to be printing in order
        List<String> a1s = Arrays.asList("a", "a a", "aaaaa","a     a");
        List<String> v1s = Arrays.asList("   v     v  ", "   v   v  ", "   V V  ","   V  ");

        for (int i = 0; i<4;i++){ //iterates through the total number of lines, printing the required components of the pattern
                System.out.println(j1s.get(i)+a1s.get(i)+v1s.get(i)+a1s.get(i));
        }

*/
        }
    }

