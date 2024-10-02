```java
import java.util.Scanner;

public class Main {
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns:");
        int cols = scanner.nextInt();
        char[][] board = new char[rows][cols];
        System.out.println("Enter the characters in the board:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        System.out.println("Enter the word to search:");
        String word = scanner.next();
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            if (dfs(board, word, index + 1, row + dx[i], col + dy[i], visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
```