import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isGameOver() {
        return hasPlayerWon('X') || hasPlayerWon('O') || isBoardFull();
    }

    private boolean hasPlayerWon(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");

        while (!isGameOver()) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter your move (row[0-2] column[0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            makeMove(row, col);
        }

        printBoard();
        if (hasPlayerWon('X')) {
            System.out.println("Player X wins!");
        } else if (hasPlayerWon('O')) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
