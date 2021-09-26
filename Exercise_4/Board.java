/**
 * Represents a board of the Tic-Tac-Toe game.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 */
public class Board implements Constants {
    /**
     * Holds all the marks made on the board.
     */
    private char theBoard[][];

    /**
     * Holds the count of the number of marks made on the board.
     */
    private int markCount;

    /**
     * Constructs an object of a 3x3 Board filled with spaces. Spaces indicate
     * not-marked.
     */
    public Board() {
        markCount = 0;
        theBoard = new char[3][];

        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];

            for (int j = 0; j < 3; j++) {
                theBoard[i][j] = SPACE_CHAR;
            }
        }
    }

    /**
     * Retrieves the mark made on a particular cell, specified by row number and
     * column number
     *
     * @param row row number of the mark.
     * @param col column number of the mark/
     * @return the mark at [row, col].
     */
    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * Checks if the board is full and no spaces are left.
     *
     * @return {@code true} if board is full, {@code false} otherwise.
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * Checks if the player with 'X' has won the game.
     *
     * @return {@code true} if xPlayer wins, {@code false} otherwise.
     */
    public boolean xWins() {
        if (checkWinner(LETTER_X) == 1)
            return true;
        else
            return false;
    }

    /**
     * Checks if the player with 'O' has won the game.
     *
     * @return {@code true} if oPlayer wins, {@code false} otherwise.
     */
    public boolean oWins() {
        if (checkWinner(LETTER_O) == 1)
            return true;
        else
            return false;
    }

    /**
     * Prints the tic-tac-toe board and all the marks made on this board.
     */
    public void display() {
        displayColumnHeaders();
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            System.out.print("    row " + row + ' ');
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /**
     * Adds a mark on the board on a particular cell specified by [row, col]
     *
     * @param row  row number of the mark
     * @param col  column number of the mark
     * @param mark the mark to be added - 'X' or 'O' at [row, col]
     */
    public void addMark(int row, int col, char mark) {
        theBoard[row][col] = mark;
        markCount++;
    }

    /**
     * Clears the tic-tac-toe board by removing all the marks.
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        markCount = 0;
    }

    /**
     * Checks which mark is the winner of the game. The mark is supplied as a
     * parameter to this method.
     *
     * @param mark the mark - 'X' or 'O' - to be tested for win
     * @return 1 if the mark is the winner, 0 otherwise
     */
    public int checkWinner(char mark) {
        int row, col;
        int result = 0;

        for (row = 0; result == 0 && row < 3; row++) {
            int row_result = 1;
            for (col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                result = 1;
        }

        for (col = 0; result == 0 && col < 3; col++) {
            int col_result = 1;
            for (row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                result = 1;
        }

        if (result == 0) {
            int diag1Result = 1;
            for (row = 0; diag1Result != 0 && row < 3; row++)
                if (theBoard[row][row] != mark)
                    diag1Result = 0;
            if (diag1Result != 0)
                result = 1;
        }
        if (result == 0) {
            int diag2Result = 1;
            for (row = 0; diag2Result != 0 && row < 3; row++)
                if (theBoard[row][3 - 1 - row] != mark)
                    diag2Result = 0;
            if (diag2Result != 0)
                result = 1;
        }
        return result;
    }

    /**
     * Helper method used for displaying the board. It prints the column headers.
     */
    private void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * Helper method used for displaying the board. It prints the hypens.
     */
    private void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * Helper method used for displaying the board. It prints the spaces.
     */
    private void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }
}
