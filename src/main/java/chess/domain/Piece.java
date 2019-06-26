package chess.domain;

import java.util.Objects;

public abstract class Piece {
    private final Type type;
    private final Color color;
    private Position position;

    public Piece(final Type type, final Color color, final Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    public boolean isValidMove(final Position other) {
        return false;
    }

    public boolean isValidAttack(final Piece other) {
        return !isSameColor(other.color) && isValidAttack(other.position);
    }

    protected boolean isValidAttack(final Position other) {
        return isValidMove(other);
    }

    public double getScore() {
        return this.type.score;
    }

    public String getName() {
        return this.type.name;
    }

    public boolean isSameType(Type other) {
        return this.type == other;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isSameColor(Color other) {
        return this.color == other;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    //
//    static Piece empty(final Position position) {
//        return new Piece(position, Color.EMPTY, Empty.getInstance());
//    }
//
//    boolean isValidAttack(final Piece other) {
//        return !isSameColor(other) && piece.isValidAttack(this.position, other.position);
//    }
//
//    private boolean isSameColor(final Piece other) {
//        return this.color == other.color;
//    }
//
//    boolean isSameColor(final Color other) {
//        return color == other;
//    }
//
    boolean isSameColumn(final Column other) {
        return this.position.isSameColumn(other);
    }

    //
//    public boolean isValidMove(final Piece other) {
//        return piece.isValidMove(this.position, other.position);
//    }
//
//    boolean isEmpty() {
//        return Color.EMPTY == color;
//    }
//
//    boolean isPawn() {
//        return this.piece.isSameType(Rule.Type.PAWN);
//    }
//
//    boolean isKing() {
//        return this.piece.isSameType(Rule.Type.KING);
//    }
//
//    boolean isSameType(final Rule.Type other) {
//        return piece.isSameType(other);
//    }
//
//    Piece get(final Position position) {
//        Rule piece = this.piece;
//        piece = getSecondPawnIfFirst(piece);
//        return Piece.of(position, this.color, piece);
//    }
//
//    private Rule getSecondPawnIfFirst(Rule piece) {
//        if (this.piece == Pawn.FIRST_BOTTOM) {
//            piece = Pawn.SECOND_BOTTOM;
//        }
//        if (this.piece == Pawn.FIRST_TOP) {
//            piece = Pawn.SECOND_TOP;
//        }
//        return piece;
//    }
//
//    double getScore() {
//        return piece.getScore();
//    }
//
    public String getSymbol() {
        return PieceSymbol.getSymbol(this);
    }
//
//    public Position getPosition() {
//        return position;
//    }

    public boolean isEmpty() {
        return this.type == Type.EMPTY;
    }

    public boolean isKing() {
        return this.type == Type.KING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Piece piece = (Piece) o;
        return type == piece.type &&
                color == piece.color &&
                Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, position);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", color=" + color +
                ", position=" + position +
                '}';
    }

    public boolean isPawn() {
        return this.type == Type.PAWN;
    }

    public void move(final Position position) {
        this.position = position;
    }

    public enum Color {
        WHITE("WHITE"),
        BLACK("BLACK"),
        EMPTY("EMPTY");

        private final String name;

        Color(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Type {
        PAWN("Pawn", 1),
        QUEEN("Queen", 9),
        ROOK("Rook", 5),
        KNIGHT("Knight", 2.5),
        KING("King", 0),
        EMPTY("Empty", 0),
        BISHOP("Bishop", 3);

        private final String name;
        private final double score;

        Type(final String name, final double score) {
            this.name = name;
            this.score = score;
        }
    }
}
