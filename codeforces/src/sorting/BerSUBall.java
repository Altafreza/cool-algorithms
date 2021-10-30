package sorting;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
// https://codeforces.com/problemset/problem/489/B
public class BerSUBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[] boys = new int[n];
        for (int i = 0; i < n; i++) {
            boys[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] girls = new int[m];
        for (int i = 0; i < m; i++) {
            girls[i] = sc.nextInt();
        }
        out.println(findPairs(boys, girls));

        sc.close();
        out.close();
    }

    public static int findPairs(int[] boys, int[] girls) {
        Arrays.sort(boys);
        Arrays.sort(girls);

        int i = 0, j = 0;
        int ret = 0;
        while (i < boys.length && j < girls.length) {
            if (Math.abs(boys[i] - girls[j]) <= 1) {
                ret++;
                i++;
                j++;
            } else if (boys[i] > girls[j]) {
                j++;
            } else i++;
        }
        return ret;
    }
}
