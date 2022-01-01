package online_judge;

import java.io.PrintWriter;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/520/A
public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        String s = sc.next();
        int[] a = new int[26];
        s = s.toLowerCase();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (a[c - 'a'] == 0) {
                a[c - 'a']++;
                count++;
            }
        }

        if (count == 26) out.println("YES");
        else out.println("NO");

        out.close();
    }
}
