package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class example {
    public static void main(String[] args) {
        int[] a = new int[]{23, 12, 22, 23, 24, 22, 12, 12, 32, 23, 35, 23};
        // 12 12 12 22 22 23 23 23 23 24 32 35
        // 23 =even 4
        // 12 odd 3
        // 24 1
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer value = e.getValue();
            if (value == 1) System.out.println(e.getKey() + " 1");
            else {
                if (value % 2 == 0) {
                    System.out.println(e.getKey() + " even " + value);
                } else {
                    System.out.println(e.getKey() + " odd " + value);
                }
            }
        }

    }

}
