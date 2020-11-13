package binarysearch;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThePlayboyChimp_UVa10611 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; ++i)
            h[i] = sc.nextInt();
        int Q = sc.nextInt();
        while (Q-- > 0) {
            int k = sc.nextInt();
            int x = upperBound(h, k), y = lowerBound(h, k);
            out.println((x == -1 ? "X" : x) + " " + (y == -1 ? "X" : y));
        }
        out.flush();
        out.close();
    }

    static int upperBound(int[] h, int k) {
        int ans = -1, lo = 0, hi = h.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            if (h[mid] < k) {
                ans = h[mid];
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return ans;
    }

    static int lowerBound(int[] h, int k) {
        int ans = -1, lo = 0, hi = h.length - 1;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            if (h[mid] > k) {
                ans = h[mid];
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}
