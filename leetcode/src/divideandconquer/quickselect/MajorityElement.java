package divideandconquer.quickselect;

import java.util.Random;

public class MajorityElement {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(majorityElementQS(new int[]{2, 1, 1, 1, 1, 7}));
    }

    //Quick Select
    private static int majorityElementQS(int[] a) {

        return majorityElementQS(a, 0, a.length - 1);
    }

    // Quick Select O(n) time
    // because
    private static int majorityElementQS(int[] nums, int low, int high) {
        if (low >= high) return nums[low];
        int pivotIdx = partitionQS(nums, low, high);
        //pivotIdx is an answer
        // if count of pivot is >= n/2 (= because we include the pivot element too)
        if (count >= nums.length / 2) return nums[pivotIdx];
            // size of left side is more right and we have not found the ME
        else if (pivotIdx > nums.length - pivotIdx - 1) {
            // nums.length - pidx - 1 is the length of the right side
            // pivotIdx is actually the length between 0 to pidx - 1
            return majorityElementQS(nums, low, pivotIdx - 1);
        } else {
            // size of right side is more than left and we have not found the ME
            return majorityElementQS(nums, pivotIdx + 1, high);
        }
    }

    private static int partitionQS(int[] nums, int low, int high) {
        Random rand = new Random();

        //int x = low + rand.nextInt(high - low + 1);
        //swap(nums, x, high);
        int pivot = nums[high];

        int i = low, j = high - 1;
        count = 0;
        // all elements before i are less than a[high]
        // and after j it is greater than a[high]
        // when i == j we do not know whether it is greater or lesser than a[high]
        while (i <= j) {
            if (nums[i] <= pivot) {
                if (nums[i] == pivot) {
                    count++;
                }
                i++; // next estimate
            } else {
                swap(nums, i, j);
                j--; // next estimate
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int a = nums[j];
        nums[j] = nums[i];
        nums[i] = a;
    }
}
