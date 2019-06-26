package chess.domain.rule;

import chess.domain.Piece;
import chess.domain.Position;

public class Queen extends Piece {
    private Queen(final Color color, final Position position) {
        super(Type.QUEEN, color, position);
    }

    public static Queen createWhite(final Position position) {
        return new Queen(Color.WHITE, position);
    }

    public static Queen createBlack(final Position position) {
        return new Queen(Color.BLACK, position);
    }

    @Override
    public boolean isValidMove(final Position other) {
        return this.getPosition().isDiagonal(other)
                || this.getPosition().isPerpendicular(other)
                || this.getPosition().isLevel(other);
    }
}
