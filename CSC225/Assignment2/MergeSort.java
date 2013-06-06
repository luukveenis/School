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
	
	/* Takes the first two sorted input arrays A1 and A2,
	 * and merges them into the larger input array A retaining the order */
	public static void merge(int[] A1, int[] A2, int[] A){
		int indexA1 = 0; // counters for current position in each array
		int indexA2 = 0;
		int indexA = 0;
		/* while there are still elements in both A1 and A2, inspect the first
		 * element in each and insert the smaller at the end of A */
		while (! (indexA1 >= A1.length || indexA2 >= A2.length)){
			A[indexA++] = (A1[indexA1] < A2[indexA2]) ? A1[indexA1++] : A2[indexA2++];
		}
		/* If A1 is not empty, append to A */
		while (!(indexA1 >= A1.length)){
			A[indexA++] = A1[indexA1++];
		}
		/* If A2 is not empty, append to A */
		while (!(indexA2 >= A2.length)){
			A[indexA++] = A2[indexA2++];
		}
	}
	
	
	/* mergeSort(A)
		Sort the array A using the merge sort algorithm.
		Do not change the function signature (name/parameters).
	*/
	public static void mergeSort(int[] A){
		/* Check whether the base case (length == 1) is satisfied, and 
		   if so, return */
		if (A.length == 1){
			return;
		}

		/* ... Your code goes here ... */

		/* Split the input array into two new smaller arrays A1 and A2 */
		int A1Size = A.length/2;
		int A2Size = A.length - A1Size;
		int[] A1 = new int[A1Size];
		int[] A2 = new int[A2Size];

		/* Iterate over the whole array and add the first half to A1,
		 * then add the second half to A2 */
		for(int i=0; i<A.length; i++){
			if (i<A1Size)
				A1[i] = A[i];			// add first half to A1
			else
				A2[i-A1Size] = A[i];	// add second half to A2
		}
	
		/* Recursively sort the smaller arrays */
		mergeSort(A1);
		mergeSort(A2);
	
		/* Merge the sorted A1 & A2 back into A 
		 * Uses the merge method defined above */
		merge(A1,A2,A);
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
