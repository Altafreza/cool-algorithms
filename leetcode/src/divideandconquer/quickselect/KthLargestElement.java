package divideandconquer.quickselect;


import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    // Quick Select O(n) time
    // because
    private static int findKthLargest(int[] nums, int low, int high, int kidx) {
        if (low == high) return nums[low];
        int pivotIdx = partition(nums, low, high);
        //pivotIdx is an answer
        // it is the (nums.length - pivotIdx) largest element
        if (kidx == pivotIdx) return nums[pivotIdx];
        else if (kidx < pivotIdx) {
            return findKthLargest(nums, low, pivotIdx - 1, kidx);
        } else { // numslen == 6
            // suppose if pivotIdx is 3(3nd largest) and we want kidx = 4(2nd largest)
            return findKthLargest(nums, pivotIdx + 1, high, kidx);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        Random rand = new Random();

        int x = low + rand.nextInt(high - low + 1);
        swap(nums, x, high);
        int pivot = nums[high];

        int i = low, j = high - 1;

        // all elements before i are less than a[high]
        // and after j it is greater than a[high]
        // when i == j we do not know whether it is greater or lesser than a[high]
        while (i <= j) {
            if (nums[i] <= pivot) {
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
