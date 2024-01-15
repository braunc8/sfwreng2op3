/* Assignment 6 (100 marks in total; 5% of the final score of this course)
 *
 * Question 3 (20 marks)
 *
 * Write a Java program, user input a 1-dimension array of integers, firstly
 * sorting it in non-increasing order, and then remove the duplicates in the
 * array (if exists).
 *
 * INPUT: user input a 1-dimension array.
 * OUTPUT: sorted array in non-increasing order, and without any repeating element.
 *
 * Note: You must write sort algorithm by yourself, you are not supposed to
 * use Arrays.sort() to output the result directly.
 *
 * Hint: you can use bubble sorting algorithm or other sorting algorithms.
 *
 * Keep the input format in the example and make your code user-friendly.
 *
 * Example 1:
 * INPUT: [0, 1, 1, 0, 1, 2, 2, 3, 3, 4]
 * OUTPUT: [4, 3, 2, 1, 0]
 *
 * Example 2:
 * INPUT: [7, 0, 4, 2, 9]
 * OUTPUT: [9, 7, 4, 2, 0]
 *
 */

import cassArr.carr;

public class Q3_RemoveDuplicates {

//removes an item in a given position in the array
    public static int[] shrink(int[] input, int pos){
        int[] arr = new int[input.length-1];
        int j=0;
        for (int i=0;i<arr.length;i++){
            if (i!=pos){
                arr[i]=input[j];
            }else{
                pos=-3;//impossible for an index to be negative so after we found the location we don't need to look anymore
                i--;
            }
            j++;
        }
        return arr;
    }

    public static int[] sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int max=i;//sets max as current i
            for (int j=(i+1);j<arr.length;j++){
                if (arr[i]==arr[j]){//if they are equal, the element is removed, then the index must be checked again since all the following items in the array have moved back one
                    arr = shrink(arr, j);
                    j--;
                }else if(arr[max]<arr[j]){
                    max=j;
                    for (int k=(j+1);k<arr.length;k++) {//basically every time we set a new max, we have to look for duplicates in the list and remove them
                        if (arr[k] == arr[j]) {
                            arr = shrink(arr, k);
                            k--;
                        }
                    }
                }
            }
            //if a greater index is found, swap them
            int temp=arr[max];
            arr[max]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] grid = sort(carr.iInp1D());
        System.out.println("Here is your array sorted highest to lowest without duplicates: ");
        carr.print(grid);

    }
}
