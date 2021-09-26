import java.io.*;

/**
 * Represents a Tic-Tac-Toe game.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 */
public class Game implements Constants {
    /**
     * The Board of the game.
     */
    private Board theBoard;

    /**
     * The Referee of the game.
     */
    private Referee theRef;

    /**
     * Constructs an object of Game and initializes the Board.
     */
    public Game() {
        theBoard = new Board();
    }

    /**
     * Sets the referee to the reference passed in the parameter.
     *
     * @param r the refree to be used in the game.
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
        theRef.runTheGame();
    }

    /**
     * Driver function.
     *
     * @param args command line arguments are not used.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Referee theRef;
        Player xPlayer, oPlayer;
        BufferedReader stdin;
        Game theGame = new Game();
        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter the name of the \'X\' player: ");
        String name = stdin.readLine();

        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        xPlayer = new Player(name, LETTER_X);
        xPlayer.setBoard(theGame.theBoard);

        System.out.print("\nPlease enter the name of the \'O\' player: ");
        name = stdin.readLine();
        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        oPlayer = new Player(name, LETTER_O);
        oPlayer.setBoard(theGame.theBoard);

        theRef = new Referee();
        theRef.setBoard(theGame.theBoard);
        theRef.setoPlayer(oPlayer);
        theRef.setxPlayer(xPlayer);

        theGame.appointReferee(theRef);
    }
}
