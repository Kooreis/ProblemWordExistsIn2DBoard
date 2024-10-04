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