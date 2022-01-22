package binarysearch;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2, 2, 4, 3, 1}));
    }

    // o(nlogn) better than brute force o(n2)
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 1, r = nums.length; // bin search over values
        while (l < r) {
            int cnt = 0;
            int mid = l + (r - l) / 2;

            // monotonic function
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            if (cnt <= mid) {
                l = mid + 1; // not an ans
            } else {
                r = mid; // an answer
            }
        }
        return l;
    }

    // O(n) time complexity
    public int firstDuplicateValue(int[] array) {

        for (int idx = 0; idx < array.length; idx++) {

            int targetIdx = Math.abs(array[idx]) - 1;
            if (array[targetIdx] < 0) return Math.abs(array[idx]);

            array[targetIdx] = -array[targetIdx];
        }

        return -1;
    }
}
