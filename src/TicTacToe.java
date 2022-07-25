import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        System.out.println("Welcome to Tic Tac Toe!");
        Boolean playAgain;
        do {
            //clear board, set player one to X
            clearBoard();
            display();
            int moveCnt = 0;
            //get move coordinates for P1 move, convert indices 1-3 to 0-2 by subtracting 1, loop until coordinates are a valid move
            System.out.println("Player One, you are X's.");
            getMoveCol(board, "X");
            display();
            System.out.println("Player Two, you are O's.");
            getMoveCol(board, "O");
            display();
            System.out.println("Player One:");
            getMoveCol(board, "X");
            display();
            System.out.println("Player Two:");
            getMoveCol(board, "O");
            display();
            System.out.println("Player One:");
            getMoveCol(board, "X");
            display();
            moveCnt = 5;
            if (isWin("X")) {
                System.out.println("Player One wins! 3 X's in a row.");
            }
            else {
                System.out.println("Player Two:");
                getMoveCol(board, "O");
                display();
                moveCnt = 6;
                if (isWin("O")) {
                    System.out.println("Player Two wins! 3 O's in a row.");
                }
                else {
                    System.out.println("Player One:");
                    getMoveCol(board, "X");
                    display();
                    moveCnt = 7;
                    if (isWin("X")) {
                        System.out.println("Player One wins! 3 X's in a row.");
                    }
                    else
                    {
                        System.out.println("Player Two:");
                        getMoveCol(board, "O");
                        display();
                        if (isWin("O"))
                        {
                            System.out.println("Player Two wins! 3 O's in a row.");
                        }
                        else
                        {
                            System.out.println("Player One:");
                            getMoveCol(board, "X");
                            display();
                            if (isWin("X"))
                            {
                                System.out.println("Player One wins! 3 X's in a row.");
                            }
                            else if (isTie()) {
                                System.out.println("Tie!");}
                        }
                    }
                }
            }
            Scanner in2 = new Scanner(System.in);
            playAgain = SafeInput.getYNConfirm(in2, "Play again (Y/N)? ");
        }while (playAgain = true);
        System.out.println("Thank you for playing!");
    }


    private static void clearBoard()
    {
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                System.out.printf("|%3s", board[row][col]);
            }
            System.out.println("|");
        }
    }

    private static Boolean isValidMove(int row, int col)
    {
        Boolean retVal = false;
        if(board[col][row].equals(" "))
        {
            retVal = true;
        }
        return retVal;
    }

    private static boolean isRowWin(String player)
    {
        for( int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isWin(String player)
    {
        if(isRowWin(player))
        {
            return true;
        }
        else if(isColWin(player))
        {
            return true;
        }
        else if(isDiagonalWin(player))
        {
            return true;
        }
        else
            return false;
    }

    private static boolean isColWin(String player)
    {
        for( int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }
        else  if (board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
        {
            return true;
        }
        else
            return false;

    }

    private static Boolean isTie()
    {
        if (!(board[0][0].equals(board[0][1])) || !(board[0][0].equals(board[0][2])) || !(board[1][0].equals(board[1][1])) || !(board[1][0].equals(board[1][2])) || !(board[2][0].equals(board[2][1])) || !(board[2][0].equals(board[2][2])) || !(board[0][0].equals(board[1][1])) || !(board[0][0].equals(board[1][2])) || !(board[0][1].equals(board[1][1])) || !(board[0][1].equals(board[2][1])) || !(board[0][2].equals(board[1][2]))|| !(board[0][2].equals(board[2][2])) || !(board[0][0].equals(board[1][1])) || !(board[0][0].equals(board[2][2])) || !(board[2][0].equals(board[1][1])) || !(board[2][0].equals(board[0][2])))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //puts player move into 2d array if valid
    private static void getMoveCol(String[][] values, String PlayerMove)
    {
        int userRow = 0;
        int userCol = 0;
        Boolean validMove;
        do
        {
            Scanner in = new Scanner(System.in);
            userRow = SafeInput.getRangedInt(in, "Please enter the horizontal (x) coordinate of your move: ", 1, 3);
            Scanner in1 = new Scanner(System.in);
            userCol = SafeInput.getRangedInt(in1, "Please enter the vertical (y) coordinate of your move: ", 1, 3);
            userRow = userRow -1;
            userCol = userCol - 1;
            validMove = isValidMove(userRow, userCol);
            if (!validMove)
            {
                System.out.println("Please enter a valid (not already taken) move.");
            }
        }while(!validMove);
        values[userCol][userRow] = PlayerMove;
    }
}