package chess.domain.RuleImpl;

import chess.domain.Position;
import chess.domain.rule.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {
    Queen queen;

    @BeforeEach
    void setUp() {
        Position position = Position.of("1", "d");
        queen = Queen.createWhite(position);
    }

    @Test
    public void 정상_대각선_이동_테스트() {
        Position target = Position.of("4", "a");

        assertTrue(queen.isValidMove(target));
    }

    @Test
    public void 정상_세로_이동_테스트() {
        Position target = Position.of("5", "d");

        assertTrue(queen.isValidMove(target));
    }

    @Test
    public void 정상_가로_이동_테스트() {
        Position target = Position.of("1", "h");

        assertTrue(queen.isValidMove(target));
    }

    @Test
    public void 비정상_이동_테스트() {
        Position target = Position.of("3", "c");

        assertFalse(queen.isValidMove(target));
    }


}