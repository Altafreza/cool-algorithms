package graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0, mins = 0, rows = grid.length, cols = grid[0].length;
        // putting the init rotten in queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : directions) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (validCo(nextX, nextY, rows, cols) && grid[nextX][nextY] == 1) {
                        q.add(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                        freshCount--;
                    }
                }
            }
            mins++;
        }

        return freshCount == 0 ? mins : -1;
    }

    public boolean validCo(int nextX, int nextY, int rows, int cols) {
        return !(nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols);
    }
}
