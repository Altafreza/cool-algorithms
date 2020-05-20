package greedy;

//Majority element is that element which occurs
// strictly more than half the times in the array
public class MajorityElement {
    static int count = 0;

    // Greedy based on Boyer Moore Vote algorithm
    public static int majorityElement1(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else {
                if (res == nums[i])
                    count++;
                else
                    count--;
            }
        }
        return res;
    }

    public static void merge(int[] nums, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int i, j, k;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = nums[p + i];
        }

        for (j = 0; j < n2; j++) {
            R[j] = nums[q + j + 1];
        }
        i = 0;
        j = 0;
        k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i = i + 1;
            } else {
                nums[k] = R[j];
                j = j + 1;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] nums, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergesort(nums, p, q);
            mergesort(nums, q + 1, r);
            merge(nums, p, q, r);
        }
    }

    public static int majorityElement(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }
}
