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