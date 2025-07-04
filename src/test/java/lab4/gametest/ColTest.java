package lab4.gametest;

import lab4.game.Col;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColTest {

    @Test
    public void testValidInputs() {
        assertEquals(Col.Left, Col.from("1"));
        assertEquals(Col.Left, Col.from("l"));
        assertEquals(Col.Middle, Col.from("2"));
        assertEquals(Col.Middle, Col.from("m"));
        assertEquals(Col.Middle, Col.from("c"));
        assertEquals(Col.Right, Col.from("3"));
        assertEquals(Col.Right, Col.from("r"));
    }

    @Test
    public void testCaseInsensitiveInputs() {
        assertEquals(Col.Left, Col.from("L"));
        assertEquals(Col.Middle, Col.from("M"));
        assertEquals(Col.Middle, Col.from("C"));
        assertEquals(Col.Right, Col.from("R"));
    }

    @Test
    public void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> Col.from("0"));
        assertThrows(IllegalArgumentException.class, () -> Col.from("left"));
        assertThrows(IllegalArgumentException.class, () -> Col.from(""));
        assertThrows(IllegalArgumentException.class, () -> Col.from(" "));

    }
}
