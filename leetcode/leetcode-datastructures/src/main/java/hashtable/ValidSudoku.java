package hashtable;

import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            int m = 3 * (i / 3);
            int n = 3 * (i % 3);
            for (int j = 0; j < 9; j++) {
                /*  the add method in hashset add the element only if the element is not present in the HashSet
                 else the function will return False if the element is already in the HashSet. */
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;

                /* keep clear about sub-boxes coordination */
                int x = m + j / 3, y = n + j % 3;
                if (board[x][y] != '.' && !box.add(board[m + j / 3][n + j % 3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 21, 73, 14},
                {8, 42, 13, 44},
                {10, 52, 32, 34}
        };

        for (int j = 0; j < 16; j++) {
            int a = j / 4, b = j % 4;
            if(j % 4 == 0) System.out.println();
            System.out.print(grid[a][b] + " ");
        }

        }
    //}

}
