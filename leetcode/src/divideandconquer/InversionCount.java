package divideandconquer;

import java.util.Arrays;

public class InversionCount {
    static long mod = (int) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        System.out.println(inversionCount(new int[]{1, 2, 5, 4, 3}));
    }

    private static int inversionCount(int[] nums) {
        return (int)inversionCount(nums, 0, nums.length - 1);
    }

    private static long inversionCount(int[] nums, int low, int high) {
        //if(low == high) return nums[low];
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            count += inversionCount(nums, low, mid);
            count += inversionCount(nums, mid + 1, high);
            count += countAcross(nums, low, mid, high);
        }
        return count % mod;
    }

    private static int countAcross(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int count = 0;
        while (i <= mid && j <= high) {
            if (a[i] > a[j]) {
                // mid thru i (inclusive both) both are contributing to the inversion
                j++;
            } else {
                count += j - mid + 1;
                i++;
            }
        }

        Arrays.sort(a, low, high+1);
        return count;
    }
}
