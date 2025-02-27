package chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = null;

    @BeforeEach
    public void setUp() {
        Board board = new Board(BoardGenerator.generate());
        game = Game.from(board);
    }

    @Test
    public void 다른_색깔의_말을_클릭할때() {
        Position origin = Position.of("7", "a");
        Position target = Position.of("6", "a");
        assertFalse(game.action(origin, target));
    }

    @Test
    public void 자기_색깔의_말을_클릭할때() {
        Position origin = Position.of("2", "a");
        Position target = Position.of("4", "a");
        assertTrue(game.action(origin, target));
    }

    @Test
    public void 턴이_제대로_바뀌었는지() {
        Position origin = Position.of("2", "a");
        Position target = Position.of("4", "a");
        game.action(origin, target);
        assertTrue(game.currentColor().equals(Piece.Color.BLACK));
    }

    @Test
    public void 실패했을때_턴이_그대로인지() {
        Position origin = Position.of("7", "a");
        Position target = Position.of("6", "a");
        game.action(origin, target);
        assertTrue(game.currentColor().equals(Piece.Color.WHITE));
    }

    @Test
    public void getPiecesTest() {
        int expected = 64;
        assertEquals(expected, game.getPieces().size());
    }

    @Test
    public void getPiecesExceptEmptyTest() {
        int expected = 32;
        assertEquals(expected, game.getPiecesExceptEmpty().size());
    }
}