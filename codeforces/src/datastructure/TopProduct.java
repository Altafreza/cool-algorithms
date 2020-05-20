package datastructure;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class TopProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

		SortedMap<String, Integer> temp = new TreeMap<>();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                String s = sc.next();
                if (s.equals("top")) {
                    System.out.println(getTop(temp));
                } else {
                    int val = sc.nextInt();
                    temp.put(s, temp.getOrDefault(s, 0) + val);
                }
            }
            temp.clear();
        }
    }

    public static String getTop(SortedMap<String, Integer> sortedMap) {
        StringBuilder sb = new StringBuilder("");
        int max = sortedMap.values().stream().max(Integer::compare).get();
        sortedMap.forEach((k, v) -> {
			if (v == max)
				sb.append(k + " ");
        });
        /*for (Map.Entry<String, Integer> next : sortedMap.entrySet()) {
            if (next.getValue() == max)
                sb.append(next.getKey() + " ");
        }*/

        return sb.toString();
    }
}
