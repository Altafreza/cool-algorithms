package binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        long lo = 1, hi = Integer.MIN_VALUE;
        for (int i : piles) {
            hi = Math.max(hi, i);
        }
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;

            if (isPossible(mid, H, piles)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) hi + 1;
    }

    public boolean isPossible(long k, int h, int[] piles) {
        int count = 0;
        for (int i : piles) {
            count += i / k;
            if (i % k != 0) count++;
        }

        return count <= h;
    }
}
