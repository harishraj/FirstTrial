package util;

public class MergeSort {
	
	public static void sort(long list[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			sort(list, start, mid);
			sort(list, mid + 1, end);
			merge(list, start, mid, mid + 1, end);
		}
	}
	
	public static void merge(long list[], int startLeft, int endLeft, int startRight, int endRight) {
		int position = startLeft;
		int startpoint = startLeft;
		int length = list.length;
		long[] templist = new long[length];
		
		while ((startLeft <= endLeft) && (startRight <= endRight)) {
			if (list[startLeft] < list[startRight]) {
				templist[position] = list[startLeft];
				startLeft++;
			} else {
				templist[position] = list[startRight];
				startRight++;
			}
			position++;
		}
		
		while (startLeft <= endLeft) {
			templist[position] = list[startLeft];
			startLeft++;
			position++;
		}
		
		while (startRight <= endRight) {
			templist[position] = list[startRight];
			startRight++;
			position++;
		}
		
		for (position = startpoint; position <= endRight; position++)
			list[position] = templist[position];
	}

	public static void main(String[] args) {
		long[] list = new long[20];
		int first = 0;
		int last = 19;
		
		for (int i = 0; i < 20; i++)
			list[i] = Math.round(Math.random() * 200);
		System.out.println("List before sorting");
		
		for (int i = 0; i < 20; i++)
			System.out.print(list[i] + " ");
		System.out.println();
		sort(list, first, last);
	
		System.out.println("List after sorting");
			for (int i = 0; i < 20; i++)
			System.out.print(list[i] + " ");
	}
}