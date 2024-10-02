Here is a Python console application that solves the problem:

```python
class Boggle:
    def __init__(self, board, word):
        self.board = board
        self.word = word
        self.rows = len(board)
        self.cols = len(board[0])
        self.visited = [[False]*self.cols for _ in range(self.rows)]

    def is_valid(self, row, col, word):
        if row<0 or row>=self.rows or col<0 or col>=self.cols or self.visited[row][col] or word[0]!=self.board[row][col]:
            return False
        return True

    def search(self, row, col, word):
        if not word:
            return True
        if not self.is_valid(row, col, word):
            return False
        self.visited[row][col] = True
        for r, c in [(0,1), (1,0), (0,-1), (-1,0)]:
            if self.search(row+r, col+c, word[1:]):
                return True
        self.visited[row][col] = False
        return False

    def exist(self):
        for i in range(self.rows):
            for j in range(self.cols):
                if self.search(i, j, self.word):
                    return True
        return False

def main():
    board = [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
    ]
    word = input("Enter a word: ")
    b = Boggle(board, word)
    print(b.exist())

if __name__ == "__main__":
    main()
```

This Python console application takes a word as input and checks if it exists in the 2D board. The `Boggle` class has methods to check if a word exists in the board. The `exist` method iterates over each cell in the board and uses the `search` method to check if the word exists starting from that cell. The `search` method uses depth-first search to check if the word exists. The `is_valid` method checks if a cell is valid and if the first character of the word matches the character in the cell. The `main` function initializes the board and takes the word as input.