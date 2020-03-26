package divideandconquer;

import java.util.Arrays;

public class CountRangeSum {
    public static int countRangeSum(int[] nums, int b, int c){
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        return countRangeSum(sums, 0, nums.length, b, c);
    }

    public static int countRangeSum(int[] sums, int start, int end, int b, int c){
        if(start >= end) return 0;
        int mid = (start + end) / 2;
        int count = countRangeSum(sums, start, mid, b, c) + countRangeSum(sums, mid + 1, end, b, c);
        int j = mid + 1, k = mid + 1;
        for(int i = start; i <= mid; i++){
            while(j <= end && sums[j] - sums[i] < b) j++;
            while(k <= end && sums[k] - sums[i] <= c) k++;
            count += k - j;
        }


        Arrays.sort(sums, start, end + 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{2, 3, 5, 8}, 4,  13));
    }
}
