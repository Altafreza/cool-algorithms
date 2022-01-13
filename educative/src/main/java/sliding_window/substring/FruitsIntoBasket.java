package sliding_window.substring;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
    }


    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> m = new HashMap<>();

        int i = 0;
        int ret = Integer.MIN_VALUE;
        for (int j = 0; j < fruits.length; j++) {
            m.put(fruits[j], m.getOrDefault(fruits[j], 0) + 1);

            while (m.size() > 2) {
                m.put(fruits[i], m.get(fruits[j]) - 1);
                if (m.get(fruits[i]) == 0) m.remove(fruits[i]);
                i++;
            }
            ret = Math.max(ret, j - i + 1);
        }

        return ret;
    }

    public int totalFruit1(int[] fruits) {
        // longest subarray with at most 2 types of fruit
        int n = fruits.length;
        int distinct = 0, ans = 0;
        int[] cnt = new int[n];
        for (int l = 0, r = 0; r < n; r++) {
            cnt[fruits[r]]++;
            if (cnt[fruits[r]] == 1) distinct++;
            while (distinct > 2) {
                cnt[fruits[l]]--;
                if (cnt[fruits[l]] == 0) distinct--;
                l++;
            }
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }

}
