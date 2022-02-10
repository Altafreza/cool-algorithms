package graphs.dfs;

public class WordSearch {
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];

        // this is a graph problem in which all the points
        // in the graph are graph nodes so we dfs on all points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // starting from 1st alpha of word if the whole word is present in the grid
                // we return true, we check by passing a state variable index
                // to know if the whole word is present
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) { // terminate 1
            return true; // this means that if index passed the word.length - 1
            // it has already found the word
        }
        // to decide if the word is found which is now our terminating condition
        // we see that char at index of word is reached thru dfs
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || //terminate 2
                word.charAt(index) != board[i][j] || visited[i][j])
            return false;
        visited[i][j] = true; // visit before exploxing this vertex
        if
        (
                searchWord(i + 1, j, index + 1, board, word) ||
                        searchWord(i - 1, j, index + 1, board, word) ||
                        searchWord(i, j + 1, index + 1, board, word) ||
                        searchWord(i, j - 1, index + 1, board, word)
        ) {
            return true;
        }

        visited[i][j] = false; // unvisit this vertex for further recursion becoz global array
        return false;

    }
}
