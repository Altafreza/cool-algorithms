package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class FerrisWheel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.parallelSort(a);
        System.out.println(ferrisWheel(a, x, n));
    }

    private static int ferrisWheel(int[] a, int x, int n) {

        int i = 0, j = n - 1;
        int count = 0;
        while (i <= j) {
            if (a[i] + a[j] > x) {
                j--;
            } else {
                i++;
                j--;
            }
            count++;
        }
        return count;
    }

}
