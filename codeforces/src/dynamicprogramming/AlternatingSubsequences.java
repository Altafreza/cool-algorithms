package dynamicprogramming;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlternatingSubsequences {
    public static long maxSumAlternatingSubsequences(int[] a) {
        List<Integer> l = new ArrayList<>();

        for (int ai : a) {
            if (l.isEmpty()) {
                l.add(ai);
            } else {
                int last = l.get(l.size() - 1);
                if (Integer.signum(ai) == Integer.signum(last)) {
                    l.set(l.size() - 1, Math.max(last, ai)); //less neg or more pos
                } else {
                    l.add(ai);
                }
            }
        }
        // helper(a, -1, 0, new long[a.length + 1][a.length]);
        return l.stream().mapToLong(value -> value).sum();

    }

    // correct funtion for finding max sum alternating ssubseq
    private static long helper(int[] a, int prev, int i, long[][] dp) {
        if (i == a.length) return 0;
        if (dp[prev + 1][i] != 0) return dp[prev + 1][i];
        long sum = 0;
        if (prev != -1 && Integer.signum(a[i]) == Integer.signum(a[prev])) {
            sum = helper(a, prev, i + 1, dp);
        } else {
            long s = helper(a, i, i + 1, dp);
            sum = a[i] + s;
        }
        Math.max(sum, helper(a, prev, i + 1, dp));
        dp[prev + 1][i] = sum;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; ++i) {
                a[i] = sc.nextInt();
            }

            out.println(maxSumAlternatingSubsequences(a));
        }

        sc.close();
        out.close();
    }
}
