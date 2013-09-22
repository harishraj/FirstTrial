public class LinearSearch {

	public static int linearSearch(int[] list, int sought) {
		int i;
		int m = list.length;
		for (i = 0; i < m; i++) {
			if (list[i] == sought) {
				break;
			}
		}
		return i;
	}

	public static void main(String args[]) {
		int[] list = { 16, 5, 28, 2, 99, 67, 45, 54, 89, 18 };
		int x, sought = 45;
		x = linearSearch(list, sought);
		System.out.println("Index is " + x);

	}
}
