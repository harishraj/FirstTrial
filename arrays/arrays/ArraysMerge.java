package arrays;

public class ArraysMerge {

	public static int[] merge(int[] array1, int[] array2) {
		int i = 0, j = 0, k = 0;
		int[] result = new int[20];
		
		while (i < array1.length && j < array2.length) {
			if (array1[i] <= array2[j]) {
				result[k++] = array1[i++];
			} else {
				result[k++] = array2[j++];
			}
		}
		
		if (i < array1.length -1) {
			for (int i1 = i; i1 < array1.length-1; i1++) {
				result[k++] = array1[i1];
			}
		} else if (j < array2.length -1) {
			for (int j1 = j; j1 < array2.length-1; j1++) {
				result[k++] = array2[j1];
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 9, 11, 17, 19 };
		int[] array2 = { 2, 6, 8, 10, 14, 15, 20, 22, 24, 25 };
		int[] array3 = new int[20];

		array3 = merge(array1, array2);
	}

}
