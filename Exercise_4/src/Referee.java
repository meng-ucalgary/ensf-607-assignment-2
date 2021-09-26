/**
 * Represents a refree of the Tic-Tac-Toe.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 */
public class Referee {
    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    /**
     * Constructs an object of Referee
     */
    public Referee() {
    }

    /**
     * Starts the game of Tic-Tac-Toe after setting up the players.
     */
    public void runTheGame() {
        this.xPlayer.setOpponent(this.oPlayer);
        this.oPlayer.setOpponent(this.xPlayer);

        this.board.display();
        this.xPlayer.play();
    }

    /**
     * Sets the board of the game.
     *
     * @param board the board of the game.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Sets the Player with mark 'O'.
     *
     * @param oPlayer the player using mark 'O'.
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Sets the Player with mark 'X'.
     *
     * @param xPlayer the player using mark 'X'.
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}
