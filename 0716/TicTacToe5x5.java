import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        int moves = 0;

        while (true) {
            int row, col;

            while (true) {
                System.out.print("玩家 " + currentPlayer + " 請輸入位置 (row col)：");
                if (!scanner.hasNextInt()) {
                    scanner.next(); 
                    System.out.println("請輸入兩個整數！");
                    continue;
                }

                row = scanner.nextInt();

                if (!scanner.hasNextInt()) {
                    scanner.next(); 
                    System.out.println("請輸入兩個整數！");
                    continue;
                }

                col = scanner.nextInt();

                if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                    System.out.println("輸入超出範圍，請重新輸入！");
                } else if (board[row][col] != '.') {
                    System.out.println("該位置已被佔用，請重新輸入！");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();
            moves++;

            if (isWin(currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            }

            if (moves == SIZE * SIZE) {
                System.out.println("平手！");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isWin(char player) {
        
        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        
        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][SIZE - 1 - i] != player) {
                win = false;
                break;
            }
        }
        return win;
    }
}
