package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    private static Map<Integer, Integer> parent;

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        parent = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            parent.putIfAbsent(nums[i], nums[i]);
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int root = find(nums[i]);
            max = Math.max(max, root - nums[i] + 1);
        }

        return max;
    }


    private static int find(int i) {
        int key = i;
        while (parent.containsKey(key + 1)) {
            int nkey = parent.get(parent.get(key + 1));
            parent.put(i, nkey); // unioning child into parent bucket
            key = nkey;
        }
        return key;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
