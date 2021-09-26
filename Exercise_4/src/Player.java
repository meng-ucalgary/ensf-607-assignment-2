import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a player of the Tic-Tac-Toe.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 */
public class Player {
    /**
     * Name of the player playing the game.
     */
    private String name;

    /**
     * Mark used by player. Its either 'X' or 'O'.
     */
    private char mark;

    /**
     * The board on which game is being played.
     */
    private Board board;

    /**
     * The opponent player of the game.
     */
    private Player opponent;

    /**
     * Constructs an object of person with supplied parameters.
     *
     * @param name name of the player.
     * @param mark mark of the player.
     */
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Facilitates the playing of the game. After every move is made, the board is
     * displayed and results are checked before passing the turn to the opponent.
     */
    public void play() {
        this.makeMove();
        this.board.display();

        if (this.board.xWins() == false) {
            if (this.board.oWins() == false) {
                if (this.board.isFull() == false) {
                    this.opponent.play();
                }

                else {
                    System.out.printf("%nTHE GAME IS OVER: Tie!%nGame Ended...");
                }
            }

            else {
                String winnerName = this.mark == 'O' ? this.name : this.opponent.name;
                System.out.printf("%nTHE GAME IS OVER: %s is the winner!%nGame Ended...%n", winnerName);
            }
        }

        else {
            String winnerName = this.mark == 'X' ? this.name : this.opponent.name;
            System.out.printf("%nTHE GAME IS OVER: %s is the winner!%nGame Ended...%n", winnerName);
        }
    }

    /**
     * Allows to make a valid move and mark on the board.
     */
    public void makeMove() {
        while (true) {
            int row = this.getRowOrColIndex(
                    String.format("%s, what row should your next %c be placed in? ", this.name, this.mark));
            int col = this.getRowOrColIndex(
                    String.format("%s, what column should your next %c be placed in? ", this.name, this.mark));

            if (this.board.getMark(row, col) == ' ') {
                this.board.addMark(row, col, this.mark);
                break;
            }

            else {
                System.out.printf("(%d, %d) is already marked.%nPlease choose another (row, column)%n", row, col);
            }
        }

    }

    /**
     * Sets the opponent of the game.
     *
     * @param opponent the opponent of the game.
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Sets the board of the game.
     *
     * @param theBoard the board of the game.
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    /**
     * Fetches the row or column index where the player want to make a move
     *
     * @return the index of row or column within the theBoard[][]
     */
    private int getRowOrColIndex(String prompt) {
        System.out.printf("%s: ", prompt);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index;

        while (true) {
            try {
                index = Integer.parseInt(br.readLine());

                if (index > 2 || index < 0) {
                    throw new IOException("Move not valid");
                }

                return index;
            }

            catch (NumberFormatException e) {
                System.out.printf("Invalid number. Please try again: ");
            }

            catch (IOException e) {
                System.out.printf("%s. Please try again: ", e.getMessage());
            }
        }
    }
}
