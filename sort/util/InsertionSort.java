package util;

public class InsertionSort {
	/**
	 * The insertion sort, unlike the other sorts, passes through the array only once.
	 * The insertion sort splits an array into two sub-arrays. 
	 * The first sub-array is always sorted and increases in size as the sort continues. 
	 * The second sub-array is unsorted, contains all the elements yet to be inserted 
	 * into the first sub-array, and decreases in size as the sort continues. 
	 */

	public static long[] sort(long[] list){
		 long insertValue;
		 int position;
		
		for (int count = 0; count < list.length; count++) {
			insertValue = list[count];
			position = count;
			while (position > 0 && list[position - 1] > insertValue) {
				list[position] = list[position - 1];
				position--;
			}
			list[position] = insertValue;
		}
		return list;
	}
	
	public static void main(String args[]) {
		long[] list = new long[20];

		int count;
		// populate list with 20 random numbers
		for (count = 0; count < 20; count++)
			list[count] = Math.round(Math.random() * 200);
		
		// output unsorted list
		System.out.println(" Original unsorted list ");
		for (count = 0; count < 20; count++)
			System.out.print(list[count] + " ");
		System.out.println();
	
		long result[] = sort(list); 
		
		System.out.println();
		System.out.println(" Sorted list ");
		for (count = 0; count < 20; count++)
			System.out.print(result[count] + " ");
	}
}