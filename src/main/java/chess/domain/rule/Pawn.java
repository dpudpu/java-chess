package chess.domain.rule;

import chess.domain.Piece;
import chess.domain.Position;
import chess.domain.Row;

public class Pawn extends Piece {
    private static final Row STARTING_WHITE_ROW = Row.from(2);
    private static final Row STARTING_BLACK_ROW = Row.from(7);

    private static final int ZERO_VECTOR = 0;

    Pawn(final Color color, final Position position) {
        super(Type.PAWN, color, position);
    }

    public static Pawn createWhite(final Position position) {
        return new Pawn(Color.WHITE, position);
    }

    public static Pawn createBlack(final Position position) {
        return new Pawn(Color.BLACK, position);
    }

    @Override
    public boolean isValidMove(final Position other) {
        final int vector = this.getPosition().vectorOfRow(other);
        return this.getPosition().isPerpendicular(other) && (isBottomMovable(vector) || isTopMovable(vector));
    }

    private boolean isTopMovable(final int vector) {
        return getDistance() <= vector && vector < ZERO_VECTOR;
    }

    private boolean isBottomMovable(final int vector) {
        return getDistance() >= vector && vector > ZERO_VECTOR;
    }

    //TODO
    private int getDistance() {
        if (isWhite()) {
            return getPosition().isSameRow(STARTING_WHITE_ROW) ? 2 : 1;
        }
        return getPosition().isSameRow(STARTING_BLACK_ROW) ? -2 : -1;
    }

    @Override
    protected boolean isValidAttack(final Position other) {
        if (!this.getPosition().isDiagonal(other)) {
            return false;
        }
        final int vector = this.getPosition().vectorOfRow(other);
        return this.getPosition().sumRowAndColumn(other) == 2 && isSameSign(vector);
    }

    private boolean isSameSign(final int vector) {
        return Integer.compare(0, getDistance()) == Integer.compare(0, vector);
    }
}
