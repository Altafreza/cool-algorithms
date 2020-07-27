package divideandconquer;

import java.util.Arrays;

public class ReversePair {

    public int reversePairs(int[] nums) {
        // divide to one size subarray return from there and merge
        // merge using a new aux subarray
        // three pointers at each call left mid right
        //1 3 2 3 1
        if (nums.length == 0) return 0;
        return mergesort(nums, 0, nums.length - 1);
    }

    private int mergesort(int[] nums, int lo, int hi) {
        if (lo == hi) return 0;


        int mid = (hi + lo) / 2;
        int paircount = mergesort(nums, lo, mid) + mergesort(nums, mid + 1, hi);// recursing thru subaarray and breaking in halves
        paircount += merge(nums, lo, mid, hi); // merge is always happening on sorted subarrays from lo to hi
        return paircount;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int count = 0; // 134 12
        while (i <= mid && j <= hi) {
            if ((long) nums[i] > (long) 2 * nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        Arrays.sort(nums, lo, hi + 1);
        //Collections.sort(A, lo, hi+1);
        return count;
    }
}
