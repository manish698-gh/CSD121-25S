package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.ui.Console;

/**
 * Abstract base class for all TicTacToe players.
 * Enforces that all player types must implement the method to choose their next move.
 */
public abstract class Player {

    private final String name;

    /**
     * Constructs a Player with the given name.
     * @param name The player's name
     */

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    /**
     * Prompts the player to pick their next move.
     * @param currentBoard The current state of the game board
     * @return The position on the board where the player wants to place their token
     *
     * TODO: Make this an abstract method in an abstract class,
     *          and use this implementation in a HumanPlayer subclass
     */
    public abstract Position pickNextMove(Board currentBoard);
}
