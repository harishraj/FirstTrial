package util;

import java.io.*;

public class BubbleSort {

	/**The bubble sort repeatedly compares adjacent elements of an array. 
	 * The first and second elements are compared and swapped if out of order.  
	 * Then the second and third elements are compared and swapped if out of order.  
	 * This sorting process continues until the last two elements of the array are compared 
	 * and swapped if out of order.
	 * The bubble sort knows that it is finished when it examines the entire array and 
	 * no "swaps" are needed (thus the list is in proper order).  
	 * The bubble sort keeps track of the occurring swaps by the use of a flag. 
	 * 
	 * **/
	
	public static void sort(long[] values) {

		int i, n;
		long temp;
		int count = 0;  
		n = values.length - 1;
		boolean sorted = false;
		
		while ((n > 0) && (sorted == false)) {
			sorted = true;
			count++;
			for (i = 0; i < n; i++) {
				if (values[i] > values[i + 1]) {
					temp = values[i];
					values[i] = values[i + 1];
					values[i + 1] = temp;
					sorted = false;
				}
			}
			n--;
		}
		System.out.println("Number of passes  " + count);
	}

	public static void main(String args[]) throws IOException {
		long[] list = new long[10];
		int i;
		for (i = 0; i < 10; i++)
			list[i] = Math.round(Math.random() * 200);
		System.out.println("Unsorted list ");

		for (i = 0; i < 10; i++)
			System.out.print(list[i] + " ");
		System.out.println();

		sort(list);
		System.out.println("Sorted list ");

		for (i = 0; i < 10; i++)
			System.out.print(list[i] + " ");
	}
}