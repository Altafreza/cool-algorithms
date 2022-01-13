package online_judge;

import java.io.PrintWriter;
import java.util.Scanner;

/*http://codeforces.com/problemset/problem/621/A*/
public class WetShark {
    static int PRECISION = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] a = new int[n];
        long sum = 0, odd = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long num = sc.nextInt();
            sum += num;
            if (num % 2 != 0) odd = Math.min(odd, num);
        }

        if (sum % 2 != 0) sum -= odd;

        out.println(sum);
        out.close();
//        System.out.println(sqrt(10));
    }

    private static double sqrt(double X) {
        for (int i = 1; i < X; ++i) {
            int p = i * i;
            if (p == X) {
                // perfect square
                return i;
            }
            if (p > X) {
                // found left part of decimal
                return sqrt(X, i - 1, i);
            }
        }
        return Double.NaN;
    }


    private static double sqrt(double X, double low, double high) {
        double mid = (low + high) / 2;
        double p = mid * mid;
        // uncomment below line to see how we reach the final answer
        System.out.println(low + " " + high + " " + mid + " " + p);

        if (p == X || (Math.abs(X - p)*100  < PRECISION)) {
            System.out.println(X + " " + p);
            return mid;
        }
        if (p < X) {
            return sqrt(X, mid, high);
        }
        return sqrt(X, low, mid);
    }
}
