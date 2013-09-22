import java.util.Hashtable;

public class StringUtil {

	public static void main(String args[]) {
		// stringSearch("CDE", "ABCDEFGHICDEABCDEFGCDE");
		System.out.println("Is the word palindrome :"
				+ isPalindrome("malayalama"));
	}

	public static void stringSearch(String pat, String text) {

		int M = pat.length();
		int N = text.length();

		for (int i = 0; i <= N - M; i++) {
			if (text.charAt(i) == pat.charAt(0)) {
				if (text.substring(i, i + M).equals(pat)) {
					System.out.println("Found the match ");
				}
			}
		}
	}

	public static String  strtoLower(String str) {

		if (str == null || str.length() < 1) {
			throw new NullPointerException("str");
		}
	
		for (int i = 0; i < str.length(); i++) {
			int ascii = new Integer(str.charAt(i));
			if (ascii > 96 && ascii < 123) {
				ascii = ascii - 32;
				char c = (char) ascii;
		
				str = str.replace(str.charAt(i), c);
			}
		}
		return str;
	}

		public static boolean isPalindrome(String text) {

		return text
				.equals(new StringBuffer().append(text).reverse().toString());
		/**
		 * char[] word = text.toCharArray(); int leng = word.length; for (int
		 * i=0; i < leng/2; i++) { if (word[i] != word[leng-i]) return false; }
		 * 
		 * return true;
		 **/
	}

	boolean isAnagram(String s1, String s2) {
		// Argument validation
		if (s1 == null || s2 == null)
			throw new NullPointerException("s1 or s2");

		// get length of both string
		int length1 = s1.length();
		int length2 = s2.length();

		// Create hash table to store char count
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		// Lower all the characters in strings
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		// Iterate through first string, ignore space and store char count in
		// hashtable
		for (int i = 0; i < length1; i++) {
			if (s1.charAt(i) == ' ') {
				continue;
			}
			if (ht.containsKey(s1.charAt(i))) {
				ht.put(s1.charAt(i), ht.get(s1.charAt(i)) + 1);
			} else {
				ht.put(s1.charAt(i), 1);
			}
		}

		// Iterate second string and decrement char count
		// And remove char from hash table if count is 0
		for (int i = 0; i < length2; i++) {
			if (s2.charAt(i) == ' ') {
				continue;
			}
			if (!ht.containsKey(s2.charAt(i))) {
				return false;
			} else {
				char key = s2.charAt(i);
				ht.put(key, ht.get(key) - 1);
				if (ht.get(key) == 0) {
					ht.remove(key);
				}
			}
		}
		// Return true if hashtable is empty
		return ht.isEmpty();
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}

	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
}
