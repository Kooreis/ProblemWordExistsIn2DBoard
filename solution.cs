Here is a C# console application that solves the problem:

```csharp
using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        char[,] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        string word = "ABCCED";

        Console.WriteLine(Exist(board, word));
    }

    public static bool Exist(char[,] board, string word)
    {
        if (board == null || board.Length == 0) return false;

        bool[,] visited = new bool[board.GetLength(0), board.GetLength(1)];

        for (int i = 0; i < board.GetLength(0); i++)
        {
            for (int j = 0; j < board.GetLength(1); j++)
            {
                if (DFS(board, word, 0, i, j, visited)) return true;
            }
        }

        return false;
    }

    private static bool DFS(char[,] board, string word, int index, int row, int col, bool[,] visited)
    {
        if (index == word.Length) return true;

        if (row < 0 || col < 0 || row == board.GetLength(0) || col == board.GetLength(1) || visited[row, col] || board[row, col] != word[index]) return false;

        visited[row, col] = true;

        if (DFS(board, word, index + 1, row - 1, col, visited) ||
            DFS(board, word, index + 1, row + 1, col, visited) ||
            DFS(board, word, index + 1, row, col - 1, visited) ||
            DFS(board, word, index + 1, row, col + 1, visited)) return true;

        visited[row, col] = false;

        return false;
    }
}
```

This program uses a depth-first search (DFS) to traverse the 2D board. It starts from each cell in the board and explores the neighboring cells in all four directions (up, down, left, right). If the current cell contains the same character as the current character in the word and this cell has not been visited before, it continues to the next character in the word and the neighboring cells. If it reaches the end of the word, it means the word exists in the board. If it cannot find the next character in the word from the neighboring cells, it backtracks to the previous cell and continues the search.