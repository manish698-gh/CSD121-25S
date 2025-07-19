// File: src/test/java/lab5/players/LinusTest.java
package lab5.players;

import lab5.game.Board;
import lab5.game.Position;
import lab5.game.Col;
import lab5.game.Row;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinusTest {

    @Test
    void linusPicksFirstAvailable() {

        Board board = new Board("XO-"
                + "-X-"
                + "O--");

        linus linus = new linus("Linus");
        Position move = linus.pickNextMove(board);

        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void linusOnEmptyBoard() {
        Board board = new Board();

        linus linus = new linus("Linus");
        Position move = linus.pickNextMove(board);

        assertEquals(new Position(Row.Top, Col.Left), move);
    }
}
