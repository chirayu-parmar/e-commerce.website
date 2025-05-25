import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void name() {
        Main mainTest = new Main("Hello");
        assertEquals("Hello", mainTest.getName());
    }
}