package binarysearch;

public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2, 2, 4, 3, 1}));
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 1, r = nums.length;
        while (l < r) {
            int cnt = 0;
            int mid = l + (r - l) / 2;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
