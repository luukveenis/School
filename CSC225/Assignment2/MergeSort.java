/* MergeSort.java
   CSC 225 - Summer 2013
   Assignment 2 - Template for MergeSort
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java MergeSort
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java MergeSort file.txt
   where file.txt is replaced by the name of your text file.

   B. Bird
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class MergeSort{
	public static final int max_values = 1000000;
	
	
	/* mergeSort(A)
		Sort the array A using the merge sort algorithm.
		Do not change the function signature (name/parameters).
	*/
	public static void mergeSort(int[] A){
		/* Check whether the base case (length == 1) is satisfied, and 
		   if so, return */

		/* ... Your code goes here ... */

		/* Split the input array into two new smaller arrays A1 and A2 */
		int A1Size = A.length/2;
		int A2Size = A.length - A1Size;
		int[] A1 = new int[A1Size];
		int[] A2 = new int[A2Size];

		/* ... Your code goes here ... */
	
		/* Recursively sort the smaller arrays */
	
		/* ... Your code goes here ... */
	
		/* Merge the sorted A1 & A2 back into A */
	
		/* ... Your code goes here ... */
	}

	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter up to %d positive integers to be sorted. Enter a negative value to end the list.\n",max_values);
		}
		int[] array = new int[max_values];
		int n = 0;
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			array[n++] = v;
		array = Arrays.copyOfRange(array,0,n);

		System.out.printf("Read %d values, sorting...\n",array.length);
		mergeSort(array);
		
		//Don't print out the values if there are more than 100 of them
		if (array.length <= 100){
			System.out.println("Sorted values:");
			for (int i = 0; i < array.length; i++)
				System.out.printf("%d ",array[i]);
			System.out.println();
		}
		
		//Check whether the sort was successful
		boolean isSorted = true;
		for (int i = 0; i < n-1; i++)
			if (array[i] > array[i+1])
				isSorted = false;
		System.out.printf("Array %s sorted successfully.\n",isSorted? "was":"was not");
	}
}
