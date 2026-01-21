import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        char player = 'X';
        int moves = 0;

        System.out.println("Tic Tac Toe Game");
        System.out.println("Enter row and column (0 to 2)");

        while (true) {

            // print board every time
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Player " + player + " turn");
            int r = sc.nextInt();
            int c = sc.nextInt();

            // to check valid positions or not
            if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != '-') {
                System.out.println("Invalid move");
                continue;
            }

            board[r][c] = player;
            moves++;

            // win condition checking
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player ||
                    board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                    System.out.println("Player " + player + " wins");
                    return;
                }
            }

            if (board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                System.out.println("Player " + player + " wins");
                return;
            }

            if (moves == 9) {
                System.out.println("Game Draw");
                return;
            }

            player = (player == 'X') ? 'O' : 'X';
        }
    }
}
