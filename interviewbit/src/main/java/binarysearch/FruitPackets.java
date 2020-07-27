package binarysearch;

public class FruitPackets {
    public int solve(int a, int b, int c) {
        int low = 1, high = Math.min(a, b);
        int ans = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            int a1 = a - mid, b1 = b - mid;
            if (a1 + b1 + c >= mid && a1 >= 0 && b >= 0) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
