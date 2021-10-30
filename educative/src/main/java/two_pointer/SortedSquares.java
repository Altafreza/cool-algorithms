package two_pointer;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, j = nums.length - 1;
        int[] squares = new int[nums.length];

        while (l <= r) {
            if (Math.pow(nums[l], 2) <= Math.pow(nums[r], 2)) {
                squares[j--] = (int) Math.pow(nums[r], 2);
                r--;
            } else {
                squares[j--] = (int) Math.pow(nums[l], 2);
                l++;
            }
        }
        return squares;
    }
}
