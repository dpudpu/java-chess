package chess.domain.piece;

import chess.domain.Piece;
import chess.domain.Position;

public class King extends Piece {

    private King(final Color color, final Position position) {
        super(Type.KING, color, position);
    }

    public static King createWhite(final Position position) {
        return new King(Color.WHITE, position);
    }

    public static King createBlack(final Position position) {
        return new King(Color.BLACK, position);
    }

    @Override
    public boolean isValidMove(final Position other) {
        return isLengthOne(other) || isLengthTwo(other);
    }

    private boolean isLengthOne(final Position other) {
        return this.getPosition().isMoveAnyWhereSum(other, 1);
    }

    private boolean isLengthTwo(final Position other) {
        return this.getPosition().isMoveAnyWhereSum(other, 2)
                && this.getPosition().isMoveAnyWhereSub(other, 0);
    }
}
