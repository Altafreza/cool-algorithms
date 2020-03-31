package binarysearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2 + 1;

            if (nums[mid] > nums[mid - 1]) low = mid;

            else high = mid - 1;
        }
        return low;
    }
}
