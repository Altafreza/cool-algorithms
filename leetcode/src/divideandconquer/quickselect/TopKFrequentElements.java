package divideandconquer.quickselect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// wiggle sort II, K Closest Points to the origin, Minimum moves to equal array II
//Given a non-empty array of integers, return the k most frequent elements.
public class TopKFrequentElements {
    static HashMap<Integer, Integer> freq;

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{11, 3, 3, 7, 3, 7, 14, 14}, 3));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        freq = new HashMap();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
         int[] elems = new int[freq.size()];
        int index = 0;
        for (int num : freq.keySet()) {
            elems[index++] = num;
        }
        quickSelect(elems, 0, elems.length - 1, k);
        List<Integer> res = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            res.add(elems[i]);
        }
        return res;
    }

    public static void quickSelect(int[] elems, int lo, int hi, int k) {
        if (lo < hi) {
            int mid = partition(elems, lo, hi);
            if (mid == k) {
                return;
            }
            if (mid < k) {
                quickSelect(elems, mid + 1, hi, k);
            } else {
                quickSelect(elems, lo, mid - 1, k);
            }
        }

    }

    public static int partition(int[] elems, int lo, int hi) {
//        int pivotIndex = lo + (int) ((hi - lo + 1) * Math.random());
//        swap(elems, pivotIndex, hi);
        int pivotFreq = freq.get(elems[hi]);
        int j = 0;
        for (int i = 0; i < hi; i++) {
            if (freq.get(elems[i]) >= pivotFreq) {
                swap(elems, i, j++);
            }
        }
        swap(elems, j, hi);
        return j;
    }

    public static void swap(int[] elems, int i, int j) {
        int temp = elems[i];
        elems[i] = elems[j];
        elems[j] = temp;
    }
}

