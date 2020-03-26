package divideandconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReversePair {
    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        // divide to one size subarray return from there and merge
        // merge using a new aux subarray
        // three pointers at each call left mid right
        //1 3 2 3 1
        return mergesort(A, 0, A.size() - 1);
    }

    private int mergesort(List<Integer> A, int lo, int hi) {
        if (lo == hi) return 0;


        int mid = (hi + lo) / 2;
        // recursing thru subaarray and breaking in halves
        int paircount = mergesort(A, lo, mid) + mergesort(A, mid + 1, hi);
        paircount += merge(A, lo, mid, hi); // merge is always happening on sorted subarrays from lo to hi
        return paircount;
    }

    private int merge(List<Integer> A, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int count = 0; // 134 12
        while (i <= mid && j <= hi) {
            if ((long) A.get(i) > (long) 2 * A.get(j)) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        Collections.sort(A.subList(lo, hi + 1));
        return count;
    }
}
