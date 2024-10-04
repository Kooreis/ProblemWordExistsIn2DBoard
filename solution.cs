public static bool Exist(char[,] board, string word)
    {
        if (board == null || board.Length == 0) return false;

        bool[,] visited = new bool[board.GetLength(0), board.GetLength(1)];