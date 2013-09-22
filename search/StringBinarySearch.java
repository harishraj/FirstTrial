import java.io.*;

public class StringBinarySearch {

	public static int SeekValue(String sought, String[] list) {

    	int first, last, mid;
		mid = 0;
		first = 0;
		last = list.length;
		mid = (first + last) / 2;

		if (sought.length() > 0) {
			while (!(sought.equals(list[mid])) && first < last) {
				if (sought.compareTo(list[mid]) < 0)
					last = mid - 1;
				else
					first = mid + 1;
				mid = (first + last) / 2;
			}
			
			if (!(sought.equals(list[mid])))
				mid = -1;
			else
				return mid;
			}
		return mid;
	}
	
	public static void main(String args[]) throws IOException {
		String[] list = { "Andy", "Anne", "Bart", "Ben", "Carol", "Dennis",
				"Homer", "Lisa", "Maggie", "Marge" };
		String sought = "Homer";
		int index;
		index = SeekValue(sought, list);
		if (index != -1) {
			System.out.print("Found the value : " + index);
		}
		else {
			System.out.print("Value not Found ");
		}
	}
}
