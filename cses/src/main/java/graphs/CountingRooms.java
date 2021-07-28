package graphs;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//5 8
//########
//#..#...#
//####.#.#
//#..#...#
//########
public class CountingRooms {
    private static char[][] map;
    private FastScanner in;

    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int v = sc.nextInt(), e = sc.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < e; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int count = 0;
        boolean[] marked = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!marked[i]) {
                dfs(adj, marked, i);
                count++;
            }
        }
        out.println(count);
        out.flush();
        out.close();
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] marked, int i) {
        marked[i] = true;
//        if (adj[i] != null)
            for (int x : adj[i]) {
                if (!marked[x]) {
                    dfs(adj, marked, x);
                }
            }
    }
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), m = in.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = in.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(map[i][j]);
            }
            out.println();
        }

        countRooms(map);

        out.flush();
        out.close();
    }*/

    private static int countRooms(char[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

            }
        }
        return 0;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
