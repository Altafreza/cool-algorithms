package datastructure;

import java.util.*;

class MAin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            SortedMap<String, Integer> temp = new TreeMap<>();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                TreeMap<String, Integer> sortedMap = sortMapByValue(temp);
                String s = sc.next();
                if (s.equals("top")) {
                    System.out.println(getTop(sortedMap));
                } else {
                    int val = sc.nextInt();
                    temp.put(s, temp.getOrDefault(s, 0) + val);
                }
            }
        }
    }

    public static String getTop(TreeMap<String, Integer> sortedMap) {
        Map.Entry<String, Integer> firstEntry = sortedMap.firstEntry();
        int currVal = firstEntry.getValue();
        StringBuilder sb = new StringBuilder("");
        int max = sortedMap.values().stream().max(Integer::compare).get();
        for (Map.Entry<String, Integer> next : sortedMap.entrySet()) {
            if (next.getValue() == currVal)
                sb.append(next.getKey() + " ");
            else
                break;
        }

        return sb.toString();
    }

    public static TreeMap<String, Integer> sortMapByValue(SortedMap<String, Integer> map) {
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) != null || map.get(s2) != null) {
                    if (map.get(s1) > map.get(s2)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 0;
            }
        });
        result.putAll(map);
        return result;
    }


}
