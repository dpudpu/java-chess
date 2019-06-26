package chess.domain.piece;

import chess.domain.Piece;
import chess.domain.Position;

public class Knight extends Piece {
    private Knight(final Color color, final Position position) {
        super(Type.KNIGHT, color, position);
    }

    public static Knight createWhite(final Position position) {
        return new Knight(Color.WHITE, position);
    }

    public static Knight createBlack(final Position position) {
        return new Knight(Color.BLACK, position);
    }

    @Override
    public boolean isValidMove(final Position other) {
        return this.getPosition().isMoveAnyWhereSum(other, 3) && this.getPosition().isMoveAnyWhereSub(other, 1);
    }

    @Override
    protected String getWhiteSymbol() {
        return "♘";
    }

    @Override
    protected String getBlackSymbol() {
        return "♞";
    }
}
