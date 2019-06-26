package chess.domain.RuleImpl;

import chess.domain.Position;
import chess.domain.rule.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RookTest {
    Rook rook = Rook.createWhite(Position.of("1", "a"));

    @Test
    void isValidMoveTest() {
        Position target = Position.of("8", "a");
        assertTrue(rook.isValidMove(target));

    }
}