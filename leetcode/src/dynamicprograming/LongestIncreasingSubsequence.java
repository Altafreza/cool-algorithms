package dynamicprograming;

public class LongestIncreasingSubsequence {
    static public int lengthOfLIS(int[] a) {
        int n = a.length;
        // dp[prev = 0] represents when there is no prev element to this
        // meaning the curr indx is the first selection
        // return helper(a);
        // return helper(a, -1, new int[n + 1]);
        int[][] dp = new int[n + 1][n];
        helper(a, -1, 0, dp);
        return 0;
    }

    // for loop recurrence only with 1 state
    private static int helper(int[] a, int prev, int[] memo) {
        int prevEle = 0;
        if (prev == -1)
            prevEle = Integer.MIN_VALUE;
        else {
            prevEle = a[prev];
        }
        if (memo[prev + 1] != 0)
            return memo[prev + 1];
        int res = 0;
        for (int j = prev + 1; j < a.length; j++) {
            if (a[j] > prevEle) {
                res = Math.max(res, 1 + helper(a, j, memo));
            }
        }

        memo[prev + 1] = res;
        return res;
    }

    // 2^n without memo because its like combination sum
    // you either take the curr idx or not
    // there are 2 state variables
    private static int helper(int[] a, int prev, int curr, int[][] dp) {
        // dp[i][j] represents lis is starting from j(curr) idx
        // with i as prev indx
        // this i, j is necessary to memoize because we would later need for
        // a different i, j(prev, curr) this i, j
        if (curr == a.length)
            return 0;

        if (dp[prev + 1][curr] != 0)
            return dp[prev + 1][curr];
        int res = 0;

        int exc = helper(a, prev, curr + 1, dp);
        int inc = 0;
        if (prev < 0 || a[prev] < a[curr])
            inc = 1 + helper(a, curr, curr + 1, dp);

        dp[prev + 1][curr] = Math.max(exc, inc);
        return dp[prev + 1][curr];
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS1(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    static public int lengthOfLIS1(int[] a) {
        int n = a.length;
        //int[] dp = new int[];
        return helper1(a, n, new int[n + 1]);

    }

    // bottom-up
    private static int helper1(int[] a, int curr, int[] dp) {
        int res = 0; // base case
        int cEl = 0;
        if (dp[curr] != 0) return dp[curr];
        if (curr == a.length) cEl = Integer.MAX_VALUE;
        else cEl = a[curr];
        for (int i = curr - 1; i >= 0; i--) {
            if (a[i] < cEl) {
                res = Math.max(res, 1 + helper1(a, i, dp));
            }
        }
        dp[curr] = res;
        return res;
    }

    // bottom up
    public int helper(final int[] a) {
        int[] dp = new int[a.length]; // same as len of array
        if (a.length == 0)
            return 0;
        dp[0] = 1;

        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for (int b : dp) {
            max = Math.max(max, b);
        }

        return max;
    }

}
