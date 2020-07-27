package dynamicprogramming;


import java.io.*;
import java.util.StringTokenizer;

class MinimumStepsToOne {
    public static void main(String[] args) {
        try {
            input.init(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int t = input.nextInt();
            int[] dp = new int[20000001];
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                out.println("Case " + i + ": " + getMinSteps(n, dp));
            }
            out.close();

        } catch (Exception e) {
            return;
        }
    }


    // function to calculate min steps
    static int getMinSteps(int n, int memo[]) {
        // base case
        if (n == 1)
            return 0;
        if (memo[n] != 0)
            return memo[n];

        // store temp value for
        // n as min( f(n-1),
        // f(n/2), f(n/3)) +1
        int res = 1 + getMinSteps(n - 1, memo);

        if (n % 2 == 0)
            res = Math.min(res,
                    1 + getMinSteps(n / 2, memo));
        if (n % 3 == 0)
            res = Math.min(res,
                    1 + getMinSteps(n / 3, memo));

        // store memo[n] and return
        memo[n] = res;
        return memo[n];
    }

    static class input {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static String nextLine() throws IOException {
            return reader.readLine();
        }
    }


}

