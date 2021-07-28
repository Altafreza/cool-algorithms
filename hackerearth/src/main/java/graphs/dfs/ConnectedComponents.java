package graphs.dfs;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    public static void main(String args[]) throws Exception {
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
        for (int x : adj[i]) {
            if (!marked[x]) {
                dfs(adj, marked, x);
            }
        }
    }
}
