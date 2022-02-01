package dynamicprograming.mathematics
        ;

import java.util.HashMap;
import java.util.Map;

public class MathPow {
    public double myPow(double n, int k) {
        boolean additionalMult = false;

        if (k == Integer.MIN_VALUE) {
            k++;
            additionalMult = true;
        }
        Map<Integer, Double> memo = new HashMap<>();


        if (k < 0) {
            double res = helper(memo, n, -1 * k);
            return additionalMult ? 1 / (res * n) : 1 / res;
        }
        return helper(memo, n, k);
    }

    private double helper(Map<Integer, Double> memo, double n, int k) {
        if (k == 0)
            return 1;
        else if (k == 1)
            return n;
        if (!memo.containsKey(k)) {
            int mid = k / 2;
            memo.put(k, helper(memo, n, k - mid) * helper(memo, n, mid));
        }
        return memo.get(k);
    }

}
