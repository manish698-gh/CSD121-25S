package lab5.players;

import lab5.game.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OmolaTest {

    @Test
    void testOmolaWinsWhenPossible() {
        Board board = new Board("XX.\nOO.\n...");
        omola omola = new omola("Omola");
        Position move = omola.pickNextMove(board);
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void testOmolaBlocksOpponentWin() {
        Board board = new Board("XX.\nO..\n...");
        omola omola = new omola("Omola");
        Position move = omola.pickNextMove(board);
        assertEquals(new Position(Row.Top, Col.Right), move);
    }

    @Test
    void testOmolaPicksFirstIfNoThreat() {
        Board board = new Board();
        omola omola = new omola("Omola");
        Position move = omola.pickNextMove(board);
        assertTrue(board.isEmptyAt(move));
    }
}
