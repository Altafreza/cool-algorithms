package online_judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SubPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            st = new StringTokenizer(br.readLine());

            int b = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
            if (n == 0 && b == 0)
                break;
            st = new StringTokenizer(br.readLine());
            int[] r = new int[b + 1];
            for (int i = 1; i <= b; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            int[] d = new int[b + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                r[j] -= val;
                r[k] += val;
            }

            boolean ans = true;
            for (int i = 0; i < r.length; i++) {
                if (r[i] < 0)
                    ans = false;
            }
            out.append(ans ? "S\n" : "N\n");

        }
        out.close();
    }
}
