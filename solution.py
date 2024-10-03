class Boggle:
    def __init__(self, board, word):
        self.board = board
        self.word = word
        self.rows = len(board)
        self.cols = len(board[0])
        self.visited = [[False]*self.cols for _ in range(self.rows)]