import java.io.*;

public class BinarySearch {

	BinarySearch() {
	}

	public static void main(String args[]) throws IOException {
		int[] list = {5, 18, 22, 29, 42, 55, 67, 78, 89, 98};
		int sought = 78, index;

		index = seekValue(list, sought);

		if (index == -1) {
			System.out.println("Item not in the array " + "\n");
		}
		System.out.println(sought + " found at array location " + index);
		System.out.println("------------------------------");
	}

	public static int seekValue(int[] list, int sought) {
		int first, last, mid;
		mid = 0;
		first = 0;
		last = list.length;
		mid = (first + last) / 2;

		while (sought > 0) {
			while (sought != list[mid] && first < last) {
				if (sought < list[mid])
					last = mid - 1;
				else
					first = mid + 1;
				mid = (first + last) / 2;
			}

			if (sought == list[mid]) {
				return mid;
			} else {
				mid = -1;
				break;
			}
		}
		return mid;
	}
}
