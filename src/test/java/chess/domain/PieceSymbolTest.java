package chess.domain;

import chess.domain.piece.Empty;
import chess.domain.piece.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceSymbolTest {
    @Test
    void Symbol_리턴_테스트() {
        Position position = Position.of("1", "a");
        Piece rook = Rook.createWhite(position);

        String expected = PieceSymbol.getSymbol(rook);
        String actual = PieceSymbol.WHITE_ROOK.getSymbol();

        assertEquals(expected, actual);
    }

    @Test
    void Symbol_EMPTY_리턴_테스트() {
        Position position = Position.of("1", "a");
        Piece piece = Empty.create(position);

        String expected = PieceSymbol.getSymbol(piece);
        String actual = PieceSymbol.EMPTY_SYMBOL;

        assertEquals(expected, actual);
    }
}