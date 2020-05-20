package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubarrayWithSum0 {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(new Integer[]{17, 12, -12, 7});
        System.out.println(solve(ints));
    }

    public static int solve(List<Integer> A) {
        HashMap<Long, Integer> set = new HashMap<>();
        long sum = 0;
        set.put(sum, -1);
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i); // prefix sum map
            if (set.containsKey(sum)) return 1;
            set.put(sum, i);
        }

        return 0;

    }
}
