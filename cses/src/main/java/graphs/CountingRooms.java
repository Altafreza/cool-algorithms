package graphs;

import java.io.*;
import java.util.StringTokenizer;

//5 8
//########
//#..#...#
//####.#.#
//#..#...#
//########
public class CountingRooms {
    private static char[][] map;
    private static FastScanner in;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        in = new FastScanner(System.in);
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

        out.println(countRooms(map));

        out.flush();
        out.close();
    }

    private static int countRooms(char[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '.' && !visited[i][j]) {
                    dfs(i, j, visited, map);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, boolean[][] visited, char[][] map) {
        visited[i][j] = true;
        for (int x = 0; x < dirs.length; x++) {
            int a = i + dirs[x][0];
            int b = j + dirs[x][1];
            if (a >= map.length || b >= map[0].length || a < 0 || b < 0) continue;
            if (map[a][b] == '.' && !visited[a][b]) {
                dfs(a, b, visited, map);
            }
        }
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


