package arrays;

public class ArraysZeroMove1 {

	public static int[] moveZeroes(int[] array1) {
		int i = 0, j = array1.length - 1, temp = 0;
		
		while (i < j ) {
			while (array1[i] != 0) i++;
			while (array1[j] == 0) j--;
			temp = array1[i];
			array1[i] = array1[j];
			array1[j] = temp;
		}
		return array1;
	}

	public static void main(String[] args) {
		int[] array1 = { 1, 0, 9, 0, 17, 19, 2, 6, 8, 10, 0, 15, 0, 0, 24, 25 };
		int[] array3 = moveZeroes(array1);
	}


}
