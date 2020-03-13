package datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class TopProduct {
	/*
	 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
	 * int test = sc.nextInt();
	 * 
	 * for(int i = 0; i < test; i++) { int lines = sc.nextInt();
	 * 
	 * } }
	 */

	// Driver method to test above method
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);

		TreeMap<String, Integer> sortedMap = sortMapByValue(map);
		System.out.println(sortedMap);
	}

	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}

	// a comparator that compares Strings
	static class ValueComparator implements Comparator<String> {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		public ValueComparator(HashMap<String, Integer> map) {
			map.putAll(map);
		}

		@Override
		public int compare(String s1, String s2) {
			if (map.get(s1) >= map.get(s2)) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
