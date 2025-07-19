package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.PlayerToken;

import java.util.List;

public class omola extends Player {

    public omola(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        PlayerToken myToken = currentBoard.getNextTurnToken();
        PlayerToken opponent = myToken.opponent();
        List<Position> available = currentBoard.getEmptyCells();

        // Try to win
        for (Position pos : available) {
            Board copy = new Board(currentBoard);
            copy.placeNextToken(pos); // current turn
            if (copy.getWinner() == myToken) {
                return pos;
            }
        }

        // Try to block opponent
        for (Position pos : available) {
            Board copy = new Board(currentBoard);
            copy.place(pos, opponent);
            if (copy.getWinner() == opponent) {
                return pos;
            }
        }

        // Otherwise pick the first available
        return available.get(0);
    }
}
