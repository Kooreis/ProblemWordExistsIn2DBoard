def is_valid(self, row, col, word):
        if row<0 or row>=self.rows or col<0 or col>=self.cols or self.visited[row][col] or word[0]!=self.board[row][col]:
            return False
        return True