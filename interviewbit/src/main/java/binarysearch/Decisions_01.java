package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decisions_01 {
    public static void main(String[] args) {
        /*int n = 5, h = 3;

        while (h > 0) {
            int res = (n >> h - 1) & 1;
            n = n % (int) Math.pow(2, h - 1);
            h--;
            System.out.print(res + "_");
        }*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(squareRootUpto3(n));
        //convertdectobin(n);
        //System.out.println();

        //primeUptill(n);


    }

    private static void primeUptill(int n) {
        List<Integer> set = new ArrayList<Integer>();

        set.add(2);

        for (int i : set) {
            printSet(set);
            for (int j = i + 1; j <= i * i; j++) {
                if (j % i != 0) set.add(j);
            }

        }

    }

    private static void printSet(List<Integer> set) {
        System.out.print("[");
        for (int a : set) {
            System.out.print(a + "_");
        }
        System.out.print("]");
    }

    private static double squareRootUpto3(int n) {
        double lo = 0, hi = n;
        double res = 0.0;
        while (hi == lo || hi - lo > 0.0001) {
            double mid = (lo + hi) / 2;
            if (mid * mid < n) {
                res = mid;
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return res;
    }

    private static int convertdectobin(int n) {
        int i = 1;
        int msb = 0;
        while (true) {
            i = i * 2;
            msb++;
            if (n < i) break;
        }
        msb--;
        System.out.println(msb);

        double high = Math.pow(2, msb);

        while (msb >= 0) {
            if (n - high >= 0) {
                System.out.print(1 + "_");
                n -= high;
            } else System.out.print(0 + "_");
            msb--;
            high = Math.pow(2, msb);
        }

        return 0;
    }
}
