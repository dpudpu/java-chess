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

    public boolean isSameType(Type other) {
        return this.type == other;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    boolean isSameColor(Color other) {
        return this.color == other;
    }

    boolean isEmpty() {
        return this.type == Type.EMPTY;
    }

    boolean isKing() {
        return this.type == Type.KING;
    }

    boolean isPawn() {
        return this.type == Type.PAWN;
    }

    boolean isSameColumn(final Column other) {
        return this.position.isSameColumn(other);
    }

    void move(final Position position) {
        this.position = position;
    }

    double getScore() {
        return this.type.score;
    }

    public String getName() {
        return this.type.name;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public String getSymbol() {
        return this.color == Color.BLACK ? getBlackSymbol() : getWhiteSymbol();
    }

    protected abstract String getWhiteSymbol();

    protected abstract String getBlackSymbol();

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
