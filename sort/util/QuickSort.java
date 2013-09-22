package util;

public class QuickSort {
	// Data Structures
	// sort function is recursive
	static void sort(long list[], int leftEnd, int rightEnd) {
		long pivot, temp;
		int left, right;
		left = leftEnd;
		right = rightEnd;
		int pivotpoint = (left + right) / 2;
		pivot = list[pivotpoint];
	
		while (left <= right) {
			while (list[left] < pivot)
				left++;

			while (list[right] > pivot)
				right--;
	
			if (left <= right) {
				temp = list[left];
				list[left] = list[right];
				list[right] = temp;
				left++;
				right--;
			}
		}
		// calls itself to sort left and right sub-lists
		if (leftEnd < right) {
			sort(list, leftEnd, right);
		}
		
		if (left < rightEnd) {
			sort(list, left, rightEnd);
		}
	}

	public static void main(String[] args) {
		long[] list = new long[20];

		int count;
		
		// 1. populate list with 20 random numbers
		for (count = 0; count < 20; count++)
			list[count] = Math.round(Math.random() * 200);

		// 2. output unsorted list
		System.out.println(" Original unsorted list ");
				for (count = 0; count < 20; count++)
			System.out.print(list[count] + " ");

		// 3. call the sort function
		System.out.println();
		System.out.println("Calling Quicksort function");
		sort(list, 0, 19);
		
		// 3. Output the sorted list
		System.out.println();
		System.out.println(" Sorted list ");
		for (count = 0; count < 20; count++)
			System.out.print(list[count] + " ");
	}
}
