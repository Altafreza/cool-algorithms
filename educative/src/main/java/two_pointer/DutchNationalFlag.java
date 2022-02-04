package two_pointer;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {

        System.out.println(Arrays.
                toString(DutchNationalFlag.
                        sort(new int[]{1, 0, 2, 1, 0})));
        System.out.println(Arrays.
                toString(DutchNationalFlag.
                        sort(new int[]{2, 2, 0, 1, 2, 0})));

    }

    public static int[] sort(int[] a) {

        int low = 0, high = a.length - 1;

        int i = 0;
        while (i <= high) {
            if (a[i] == 0) {
                swap(a, low, i);
                low++; // a[x] before low are '0'
                i++;
            } else if (a[i] == 1) {
                i++;
            } else {
                swap(a, i, high);
                high--;  // a[x] after high are '2'
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
