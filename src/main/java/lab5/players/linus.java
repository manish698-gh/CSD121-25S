package lab5.players;

import lab5.game.Board;
import lab5.game.Position;

import java.util.List;

/**
 * A simple computer player that always picks the first available position
 * from top-left to bottom-right.
 */
public class linus extends Player {

    public linus(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        List<Position> available = currentBoard.getEmptyCells();
        return available.get(0); // always pick the first available position
    }
}
