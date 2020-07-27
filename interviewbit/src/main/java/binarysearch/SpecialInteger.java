package binarysearch;

/*
 * Given an array of integers A and an integer B, find and return the maximum value K
 * such that there is no subarray in A of size K with sum of elements greater than B.
 */
public class SpecialInteger {
    public int solve(int[] A, int B) {
        // values for k subarray size
        if (new Integer(B) == null) return 0;
        // low : min possible high: min impossible
        int low = 1, high = A.length + 1;

        while (high - low > 1) { // low will become the max possible
            int mid = (high + low) / 2;
            if (isPossible(A, mid, B)) low = mid; // before mid are also possible
            else high = mid; // after mid is also impossible
        }

        return low;
    }

    public int solve1(int[] A, int B) {
        // values for k subarray size
        if (new Integer(B) == null) return 0;
        // low : min possible || high: max possible
        int low = 1, high = A.length;

        while (high >= low) { // low will become the max possible
            int mid = (high + low) / 2;
            if (isPossible(A, mid, B)) low = mid + 1; // before mid are also possible
            else high = mid - 1; // after mid is also impossible
        }

        return low - 1;
    }

    // 1 2 3 4 5
    private boolean isPossible(int[] A, int k, int B) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += A[i];
        }

        if (sum > B) return false;

        for (int i = 1; i + k - 1 < A.length; i++) {
            int j = i + k - 1;
            sum = sum - A[i - 1] + A[j];
            if (sum > B) return false;
        }
        return true;
    }
}
