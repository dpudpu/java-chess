package chess.domain.piece;

import chess.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTest {
    Bishop bishop;

    @BeforeEach
    void setUp() {
        Position position = Position.of("1", "f");
        bishop = Bishop.createBlack(position);
    }

    @Test
    public void 정상_이동_테스트() {
        Position other = Position.of("6", "a");

        assertTrue(bishop.isValidMove(other));
    }

    @Test
    public void 비정상_이동_테스트() {
        Position other = Position.of("2", "f");

        assertFalse(bishop.isValidMove(other));
    }
}