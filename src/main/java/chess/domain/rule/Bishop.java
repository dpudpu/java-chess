package chess.domain.rule;

import chess.domain.Piece;
import chess.domain.Position;

public class Bishop extends Piece {
    private Bishop(final Color color, final Position position) {
        super(Type.BISHOP, color, position);
    }

    public static Bishop createWhite(final Position position) {
        return new Bishop(Color.WHITE, position);
    }

    public static Bishop createBlack(final Position position) {
        return new Bishop(Color.BLACK, position);
    }

    @Override
    public boolean isValidMove(final Position other) {
        return this.getPosition().isDiagonal(other);
    }
}
