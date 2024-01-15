package cassArr;

import java.util.Scanner;
public class carr {
    /*
    IMPORTANT
    Explanations can be found in the first method of each unique method set, there's quite a few that
    are essentially duplicates which accept different parameter types
     */
    //testing zone
    public static void main(String[] args) {
    }

    //printers
    //1D
    public static void print(int[] arr) {
        System.out.print("[" + arr[0]);//prints the start of the array
        for (int i=1;i<arr.length;i++) {//for each element in the array after the first it prints them
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");//prints the end and a new line
    }
    public static void print(Double[] arr) {
        System.out.print("[" + arr[0]);
        for (int i=1;i<arr.length;i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");
    }
    public static void print(char[] arr) {
        System.out.print("[" + arr[0]);
        for (int i=1;i<arr.length;i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");
    }
    public static void print(String[] arr) {
        System.out.print("[" + arr[0]);
        for (int i=1;i<arr.length;i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("]");
    }

    //2D
    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {//prints the row for every row in the array
            print(arr[i]);
        }
    }
    public static void print(Double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
        }
    }
    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
        }
    }
    public static void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
        }
    }


    //test makers
    //makes a 2D int Matrix for testing purposes
    public static int[][] iMatMake(int numRows, int numCols, int range) {
        int[][] grid = new int[numRows][numCols];//makes an array of this size
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = (int) (Math.random() * range);//fills each spot with a random number within range
            }
        }
        return grid;
    }
    //makes a 2D double matrix for testing purposes
    public static Double[][] dMatMake(int numRows, int numCols, int range) {
        Double[][] grid = new Double[numRows][numCols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = (int) (Math.random() * range);
                Double add = (double) num;
                grid[i][j] = add;
            }
        }
        return grid;
    }

    //input takers
    //makes a 1D int matrix from a user input
    public static int[] iInp1D() {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Please input your array with your row values separated by spaces and surrounded by []"); //asking for the size of the array and creating one of that size

        //prints out an example according to the user's desired number of rows
        System.out.println("Example:");
        print(iMatMake(1, 3, 1));

        //takes the input and converts it to a int[] matrix
        String input = myScan.nextLine();
        int[] ret = new int[numCols(input)];
        return inpToMat(input, ret);
    }
    public static Double[] dInp1D() {
        Scanner myScan = new Scanner(System.in);

        System.out.println("Please input your array with your row values separated by spaces and surrounded by []"); //asking for the size of the array and creating one of that size

        //prints out an example according to the user's desired number of rows
        System.out.println("Example:");
        System.out.println("[" + 1 + " " + 2 + " " + 3 + "]");
        String input = myScan.nextLine();
        Double[] ret = new Double[numCols(input)];
        return inpToMat(input, ret);
    }
    //utilities for the matrix to inout functions
    public static int[] inpToMat(String input, int[] ret) {//the inclusion of ret parameter was mostly for method overloading reasons
        char[] chars = input.toCharArray();//turn it into a character array
        String line = "";//initializes our column starting point and our addition
        int colNum = 0;

        for (int i = 1; i < chars.length; i++) {//start at 1 bc of the [
            if (chars[i] != ' ' && chars[i] != ']') {//when the number isnt a space, it adds it to a variable
                String num = Character.toString(chars[i]);
                line += num;
            } else {//when we reach other characters, the line we have been creating is converted to an integer and added to the array
                int add = Integer.parseInt(line);
                ret[colNum] = add;
                line = "";//restart the line once it is added to the final array
                colNum++;//once we have add this column, we move to the next
            }
        }
        return ret;
    }
    public static Double[] inpToMat(String input, Double[] ret) {
        char[] chars = input.toCharArray();//turn it into a character array
        String line = "";
        int colNum = 0;//restarts the column number for each line

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ' ' && chars[i] != ']') {//when the number isnt a space, it adds it to a variable
                String num = Character.toString(chars[i]);
                line += num;
            } else {
                Double add = Double.parseDouble(line);
                ret[colNum] = add;
                line = "";//restart the line once it is added to the final array
                colNum++;//once we have add this column, we move to the next
            }

        }
        return ret;
    }
    public static int numCols(String arr) {//this counts the number of spaces in a line and returns the number of columns of the array
        char[] spacesCounting = arr.toCharArray();
        int numCols = 1;
        for (char each : spacesCounting) {
            if (each == 32) {
                numCols++;
            }
        }
        return numCols;
    }


    //2D
    public static int[][] iInp2D() {
        Scanner myScan = new Scanner(System.in);

        //takes user input for number of rows
        System.out.println("Please input the amount of rows in your matrix: ");
        int numRows = myScan.nextInt();
        String[] badArr = new String[numRows];

        //asks the user for their array with an example format
        System.out.println("Please input your array with your row values separated by spaces and surrounded by [], entering between lines");
        System.out.println("Example:");
        print(iMatMake(numRows, 3, 1));

        //takes each row from the user and adds it to a 1D string array
        String input;
        myScan.nextLine();
        for (int i = 0; i < numRows; i++) {
            input = myScan.nextLine();
            badArr[i] = input;
        }

        //converts our 1D String array to a 2D Double array
        int[][] arr = new int[numRows][];
        for (int i = 0; i < badArr.length; i++) {
            int numCols = numCols(badArr[i]);
            int[] line = new int[numCols];
            int[] newLine = inpToMat(badArr[i], line);
            arr[i] = newLine;
        }
        return arr;
    }
    public static Double[][] dInp2D() {
        Scanner myScan = new Scanner(System.in);

        //takes user input for number of rows
        System.out.println("Please input the amount of rows in your matrix: ");
        int numRows = myScan.nextInt();
        String[] badArr = new String[numRows];
        System.out.println("Please input your array with your row values separated by spaces and surrounded by [], entering between lines");
        System.out.println("Example:");
        print(dMatMake(numRows, 3, 1));

        //takes each row from the user and adds it to a 1D string array
        String input;
        myScan.nextLine();
        for (int i = 0; i < numRows; i++) {
            input = myScan.nextLine();
            badArr[i] = input;
        }

        //converts our 1D String array to a 2D Double array
        Double[][] arr = new Double[numRows][];
        for (int i = 0; i < badArr.length; i++) {
            int numCols = numCols(badArr[i]);
            Double[] line = new Double[numCols];
            Double[] newLine = inpToMat(badArr[i], line);
            arr[i] = newLine;
        }
        return arr;
    }


    //sorters
    //sorts a row of a 1D integer matrix (decreasing) (selection sort)
    public static int[] sortDecreasing(int[] arr){
        for (int i=0;i<arr.length;i++){ //sets the max i to the first value
            int max=i;
            for (int j=(i+1);j<arr.length;j++){//for every value in the matrix
                if(arr[max]<arr[j]){//check if its greater than the current max
                    max=j; //resets the new max index
                }
            }
            int temp=arr[max];//sets the current variable to the max found in the remaining list
            arr[max]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    //sorts 1 row of a 1D double matrix (decreasing) (selection sort)
    public static Double[] sortDecreasing(Double[] arr){
        for (int i=0;i<arr.length;i++){
            int max=i;
            for (int j=(i+1);j<arr.length;j++){
                if(arr[max]<arr[j]){
                    max=j;
                }
            }
            Double temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

}