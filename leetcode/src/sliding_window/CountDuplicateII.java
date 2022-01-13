package sliding_window;

public class CountDuplicateII {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}, 3);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        if (k == 0) return false;
        for (int j = 1; j < nums.length; j++) {

            if (j - i > k) {
                i++;
                j = i + 1;
            }
            if (nums[i] == nums[j]) return true;
        }
        return false;
    }
}
