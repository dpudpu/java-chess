package chess.domain.RuleImpl;

import chess.domain.Position;
import chess.domain.rule.King;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {
    King king;

    @BeforeEach
    void setUp() {
        Position position = Position.of("1", "e");
        king = King.createBlack(position);
    }

    @Test
    public void 정상_이동_테스트() {
        Position target = Position.of("1", "d");
        assertTrue(king.isValidMove(target));
    }

    @Test
    public void 정상_대각선_이동_테스트() {
        Position target = Position.of("2", "d");
        assertTrue(king.isValidMove(target));
    }

    @Test
    public void 비정상_대각선_두칸_이동_테스트() {
        Position target = Position.of("3", "c");
        assertFalse(king.isValidMove(target));
    }

    @Test
    public void 비정상_수직_두칸_이동_테스트() {
        Position target = Position.of("3", "e");
        assertFalse(king.isValidMove(target));
    }


}