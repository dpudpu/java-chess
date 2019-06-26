package chess.domain;

public enum PieceSymbol {
    WHITE_PAWN(Piece.Color.WHITE, Piece.Type.PAWN, "♙"),
    WHITE_BISHOP(Piece.Color.WHITE, Piece.Type.BISHOP, "♗"),
    WHITE_KING(Piece.Color.WHITE, Piece.Type.KING, "♔"),
    WHITE_KNIGHT(Piece.Color.WHITE, Piece.Type.KNIGHT, "♘"),
    WHITE_QUEEN(Piece.Color.WHITE, Piece.Type.QUEEN, "♕"),
    WHITE_ROOK(Piece.Color.WHITE, Piece.Type.ROOK, "♖"),
    BLACK_PAWN(Piece.Color.BLACK, Piece.Type.PAWN, "♟️"),
    BLACK_BISHOP(Piece.Color.BLACK, Piece.Type.BISHOP, "♝"),
    BLACK_KING(Piece.Color.BLACK, Piece.Type.KING, "♚"),
    BLACK_KNIGHT(Piece.Color.BLACK, Piece.Type.KNIGHT, "♞"),
    BLACK_QUEEN(Piece.Color.BLACK, Piece.Type.QUEEN, "♛"),
    BLACK_ROOK(Piece.Color.BLACK, Piece.Type.ROOK, "♜");

    public static final String EMPTY_SYMBOL = " ";

    private final Piece.Color color;
    private final Piece.Type type;
    private final String symbol;

    PieceSymbol(final Piece.Color color, final Piece.Type type, final String symbol) {
        this.color = color;
        this.type = type;
        this.symbol = symbol;
    }

    public static String getSymbol(Piece piece) {
        for (final PieceSymbol pieceSymbol : values()) {
            if (piece.isSameColor(pieceSymbol.color) && piece.isSameType(pieceSymbol.type)) {
                return pieceSymbol.symbol;
            }
        }
        return EMPTY_SYMBOL;
    }

    public String getSymbol() {
        return symbol;
    }
}
