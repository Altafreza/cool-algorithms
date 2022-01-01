package online_judge;

import java.io.PrintWriter;
import java.util.Scanner;

/*https://codeforces.com/problemset/problem/705/A
 * */
public class Hulk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) s.append("I hate");
            else s.append("I love");

            if(i == n - 1) s.append(" it");
            else s.append(" that ");
        }
        out.println(s.toString());
        out.close();
    }

}
