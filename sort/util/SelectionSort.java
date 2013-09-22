package util;

public class SelectionSort {

	/** The selection sort is a combination of searching and sorting.
	During each pass, the unsorted element with the smallest (or largest) value 
	is moved to its proper position in the array.  
	The number of times the sort passes through the array is one less than the 
	number of items in the array.  
	In the selection sort, the inner loop finds the next smallest (or largest) value 
	and the outer loop places that value into its proper location.
	**/

	private static void sort(long[] list) {
		int start = 0, limit = list.length;
		
		long temp;
		int current;
		int lowestindex;

		while (start < limit) {
			lowestindex = start;
			for (current = start; current < limit; current++)
				if (list[current] < list[lowestindex])
					lowestindex = current;
			//swap
			temp = list[start];
			list[start] = list[lowestindex];
			list[lowestindex] = temp;
			start++;
		}
	}

	public static void main(String args[]) {
		long[] list = new long[20];

		int i;

		for (i = 0; i < 20; i++)
			list[i] = Math.round(Math.random() * 200);

		System.out.println(" Original unsorted list ");
		for (i = 0; i < 20; i++)
			System.out.print(list[i] + " ");
		
		sort(list);

		System.out.println();
		System.out.println(" Sorted list ");

		for (i = 0; i < 20; i++)
			System.out.print(list[i] + " ");
	}

}