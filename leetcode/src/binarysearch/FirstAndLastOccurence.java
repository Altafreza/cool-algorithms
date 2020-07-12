package binarysearch;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstOccurence(nums, target), lastOccurence(nums, target)};
    }

    public int firstOccurence(int[] a, int k) {
        int lo = 0, hi = a.length - 1;
        int ans = -1;
        while (lo <= hi) { // to stop going inside infinite loop
            int mid = (lo + hi) / 2;

            if (a[mid] == k) {
                ans = mid;
                hi = mid - 1;
            } else if (a[mid] > k) {
                hi = mid - 1; // true monotone
            } else { // false monotone
                lo = mid + 1; // estimation
            }
        }

        return ans;
    }

    public int lastOccurence(int[] a, int k) {
        int lo = 0, hi = a.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a[mid] == k) {
                ans = mid;
                lo = mid + 1;
            } else if (a[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
