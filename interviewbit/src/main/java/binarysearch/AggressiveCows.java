package binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public int solve3(int[] a, int b) {
        Arrays.sort(a);
        int low = 0;
        int high = a[a.length - 1] - a[0];
        while (high > low) {
            int mid = (low + high) / 2 + 1;
            if (isPossible(a, mid, b)) {// placing cows at a min dist of 'mid'
                low = mid; // beacause i'll be able to keep all cows in min dist < mid also
                // and i wannt to maximize answer also
            } else {
                high = mid - 1; // because i will not be to keep all cows in min dist > mid also
            }
        }
        return low;

    }

    public int solve34(int[] a, int b) {
        Arrays.sort(a);
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            low = Math.min(low, a[i + 1] - a[i]); // when n cows // minimum possible
        }
        int high = a[a.length - 1] - a[0]; // maximum possible
        while (high >= low) {
            int mid = (low + high) / 2;
            if (isPossible(a, mid, b)) {// placing cows at a min dist of 'mid'
                low = mid + 1; // beacause i'll be able to keep all cows in min dist < mid also
                // and i wannt to maximize answer also
            } else {
                high = mid - 1; // because i will not be to keep all cows in min dist > mid also
            }
        }
        return low - 1;

    }

    public int solve(int[] a, int b) {
        Arrays.sort(a);
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            low = Math.min(low, a[i + 1] - a[i]); // when n cows // minimum possible
        }
        int high = a[a.length - 1] - a[0] + 1; //when 2 cows mininmum impossible
        while (high - 1 > low) {
            int mid = (low + high) / 2;
            if (isPossible(a, mid, b)) {// placing cows at a min dist of 'mid'
                low = mid; // beacause i'll be able to keep all cows in min dist < mid also
                // and i wannt to maximize answer also
            } else {
                high = mid; // because i will not be to keep all cows in min dist > mid also
            }
        }
        return low;

    }

    // check if it is possible to have mid as answer i.e min distance between cows
    // is mid meaning any distance between cows !< mid meaning all dist is >= mid
    // so we start placing cows greedily so that the criteria is not violated
    private boolean isPossible(int[] stalls, int mid, int cows) { //monotonous function //
        int pos = 0;
        cows--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[pos] >= mid) {// this ensures that the minimum distance will be always greater than mid
                cows--;
                if (cows == 0) return true;
                pos = i;
            }
        }
        return cows == 0;
    }
}
