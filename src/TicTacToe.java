import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("   1   2   3");
        for (int i = 0; i < ROW; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COL; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  -----------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            return false;
        }
        return board[row][col].equals(" ");
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        clearBoard();
        display();

        String currentPlayer = "X";
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Player " + currentPlayer + ", please enter your move (row [1-3], column [1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                display();

                if (isWin(currentPlayer)) {
                    System.out.println("Congratulations Player " + currentPlayer + ", you win!");
                    gameOver = true;
                } else if (isTie()) {
                    System.out.println("The game is tied.");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == "X") ? "O" : "X";
                }
            } else {
                System.out.println("Invalid move, please try again.");
            }
        }
    }
}
