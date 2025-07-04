package lab4.gametest;

import lab4.game.Board;
import lab4.game.Col;
import lab4.game.Row;
import lab4.game.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testEmptyBoardInProgress() {
        Board board = new Board();
        assertEquals(Board.Status.InProgress, board.getStatus());
        assertFalse(board.isFull());
    }

    @Test
    void testHorizontalWin() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    void testVerticalWin() {
        Board board = new Board();
        board.placeO(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Bottom, Col.Left));
        assertEquals(Board.Status.OWins, board.getStatus());
    }

    @Test
    void testDiagonalWinTopLeftToBottomRight() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeX(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Bottom, Col.Right));
        assertEquals(Board.Status.XWins, board.getStatus());
    }

    @Test
    void testDiagonalWinTopRightToBottomLeft() {
        Board board = new Board();
        board.placeO(new Position(Row.Top, Col.Right));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Left));
        assertEquals(Board.Status.OWins, board.getStatus());
    }

    @Test
    void testDraw() {
        Board board = new Board();
        board.placeX(new Position(Row.Top, Col.Left));
        board.placeO(new Position(Row.Top, Col.Middle));
        board.placeX(new Position(Row.Top, Col.Right));
        board.placeX(new Position(Row.Middle, Col.Left));
        board.placeO(new Position(Row.Middle, Col.Middle));
        board.placeX(new Position(Row.Middle, Col.Right));
        board.placeO(new Position(Row.Bottom, Col.Left));
        board.placeX(new Position(Row.Bottom, Col.Middle));
        board.placeO(new Position(Row.Bottom, Col.Right));
        assertTrue(board.isFull());
        assertEquals(Board.Status.Draw, board.getStatus());
    }

    @Test
    void testIsOccupiedAt() {
        Board board = new Board();
        Position pos = new Position(Row.Top, Col.Left);
        assertFalse(board.isOccupiedAt(pos));
        board.placeX(pos);
        assertTrue(board.isOccupiedAt(pos));
    }

    @Test
    void testToStringOutput() {
        Board board = new Board();
        String expected = "...\n...\n...\n";
        assertEquals(expected, board.toString());
    }
}
