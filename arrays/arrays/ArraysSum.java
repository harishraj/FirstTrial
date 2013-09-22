package arrays;

import java.util.*;

public class ArraysSum {

	public static int[] GetNumbers(int sum, int[] array) {
		int j=0;
		int[] result = new int[20];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int k : array) {
        	hashSet.add(k);
        }
        
        for(int i : array) {
            if (hashSet.contains(sum - i)) 
            	result[j] = i;
            }
        return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 19, 2, 18, 5, 10, 12, 22};
		int[] result = new int[20];
		result = GetNumbers(20, array);
		for (int sd : result){
			System.out.println(sd);
		}
	}
}
