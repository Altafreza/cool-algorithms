package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurrounndRegions {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        int b = board.length;
        int r = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < r; j++) {
                if (i == 0 || j == 0 || i == b - 1 || j == r - 1) {
                    if (board[i][j] == 'O') {
                        q.offer(new int[]{i, j});
                        visit[i][j] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + direction[j][0];
                    int y = pos[1] + direction[j][1];
                    if (x >= 0 && x < b && y >= 0 && y < r && !visit[x][y] && board[x][y] == 'O') {
                        q.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
        }

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < r; j++) {
                if (!visit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // dfs solution
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve1(char[][] board) {
        if (board.length == 0)
            return;

        int rows = board.length, cols = board[0].length;


        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                markNotSurrounded(i, 0, board);
            if (board[i][cols - 1] == 'O')
                markNotSurrounded(i, cols - 1, board);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                markNotSurrounded(0, j, board);
            if (board[rows - 1][j] == 'O')
                markNotSurrounded(rows - 1, j, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == '*') // Restores '*' to 'O'
                    board[i][j] = 'O';
                else if (board[i][j] == 'O') // Captures 'O' surrounded by 'X'
                    board[i][j] = 'X';
            }
        }
    }

    // Mark 'O' not surrounded by 'X' as '*'
    private void markNotSurrounded(int x, int y, char[][] board) {
        board[x][y] = '*';
        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < board.length
                    && ny >= 0 && ny < board[0].length
                    && board[nx][ny] == 'O') {
                markNotSurrounded(nx, ny, board);
            }
        }
    }
}
