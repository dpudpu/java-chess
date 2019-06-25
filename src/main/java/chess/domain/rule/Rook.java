package chess.domain.rule;

import chess.domain.Position;
import chess.domain.Rule;

public class Rook extends Rule {
    private static Rook INSTANCE = new Rook();

    private Rook() {
        super(Type.ROOK);
    }

    public static Rook getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isValidMove(final Position origin, final Position target) {
        return origin.isLevel(target) || origin.isPerpendicular(target);
    }
}