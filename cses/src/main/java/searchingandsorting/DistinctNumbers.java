package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(distinctNumbers(a));
    }

    private static int distinctNumbers(int[] a) {
        Arrays.sort(a);
        int i = 0;
        int count = 0;
        for (int x : a) {
            if (i != x) {
                i = x;
                count++;
            }
        }
        return count;
    }

}
