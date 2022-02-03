package prefix_sum;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int right = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 0, 4})));
    }
}
