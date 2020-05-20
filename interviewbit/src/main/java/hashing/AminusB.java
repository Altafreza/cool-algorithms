package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AminusB {
    public class Solution {
        public int solve(int[] A, int B, int C) {
            Map<Long, Integer> frequencyMap = new HashMap<>();
            int maxSize = 1;
            for (int i = 0; i < A.length; i++) {
                long t = mod(A[i], C);
                long calculatedResult = mod(t * t, C);
                calculatedResult = calculatedResult - mod(B, C);
                calculatedResult = mod(calculatedResult * t, C);
                //long calculatedResult = mod(mod(mod(A[i] * A[i], C) * A[i], C) - mod(B * A[i], C), C);
                if (!frequencyMap.containsKey(calculatedResult))
                    frequencyMap.put(calculatedResult, 1);
                else {
                    int currFreq = frequencyMap.get(calculatedResult);
                    frequencyMap.put(calculatedResult, currFreq + 1);
                    maxSize = Math.max(maxSize, currFreq + 1);
                }
            }
            return maxSize;
        }

        public long mod(long x, int C) {
            return (x % C + C) % C;
        }

        public int solve(ArrayList<Integer> A, int B, int C) {

            //equation to satisfy is -> x^3 - x*BmodC
            HashMap<Integer, Integer> frequencies = new HashMap<>();
            int max = Integer.MIN_VALUE;
            int ans = 0;
            long temp = 0;
            long c = C;
            long b = B;
            for (int iter = 0; iter < A.size(); iter++) {
                long X = A.get(iter);
                //temp = (((X)*(X)*(X)) - X*(B));
                temp = (((X % c * X % c) % c) * X % c) % c - ((b % c * X % c) % c);
                temp %= c;
                if (temp < 0) {
                    temp += c;
                }
                frequencies.put((int) temp, (frequencies.get((int) temp) == null) ? 1 : frequencies.get((int) temp) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
                //System.out.println(entry.getKey());
                if (entry.getValue() > ans) {
                    ans = entry.getValue();
                }
            }
            return ans;
        }
    }
}
