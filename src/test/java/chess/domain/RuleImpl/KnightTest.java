package chess.domain.RuleImpl;

import chess.domain.Position;
import chess.domain.rule.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    Knight knight;

    @BeforeEach
    void setUp() {
        knight = Knight.createWhite(Position.of("1", "b"));
    }

    @Test
    public void 나이트가_잘_움직이는지() {
        Position other = Position.of("3", "c");
        assertTrue(knight.isValidMove(other));
    }

    @Test
    public void 나이트가_이동안할떄() {
        Position other = Position.of("2", "c");
        assertFalse(knight.isValidMove(other));
    }
}