package chess.domain;

import chess.domain.piece.Empty;
import chess.exception.DiedKingException;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private final Map<Position, Piece> map;

    public Board(final Map<Position, Piece> map) {
        this.map = new TreeMap<>(map);
    }

    boolean action(final Position origin, final Position target) {
        if (hasObstacle(origin, target)) {
            return false;
        }
        Piece originPiece = map.get(origin);
        Piece targetPiece = map.get(target);

        if (targetPiece.isEmpty()) {
            return move(originPiece, targetPiece);
        }
        return attack(originPiece, targetPiece);
    }

    private boolean hasObstacle(final Position origin, final Position target) {
        for (Position route : origin.findRoutes(target)) {
            if (!map.get(route).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean attack(final Piece origin, final Piece target) {
        if (!origin.isValidAttack(target)) {
            return false;
        }
        if (target.isKing()) {
            throw new DiedKingException("attacked King");
        }
        chanePiece(origin, target);
        return true;
    }

    private boolean move(final Piece origin, final Piece target) {
        if (origin.isValidMove(target.getPosition())) {
            chanePiece(origin, target);
            return true;
        }
        return false;
    }

    private void chanePiece(final Piece origin, final Piece target) {
        map.put(origin.getPosition(), Empty.create(origin.getPosition()));
        origin.move(target.getPosition());
        map.put(target.getPosition(), origin);
    }

    boolean isSameColor(final Position origin, Piece.Color color) {
        return map.get(origin).isSameColor(color);
    }

    ScoreCalculator createScoreCalculator() {
        List<Piece> pieces = new ArrayList<>(map.values());
        return new ScoreCalculator(pieces);
    }

    List<Piece> getPiecesExceptEmpty() {
        return map.values().stream()
                .filter(piece -> !piece.isEmpty())
                .collect(Collectors.toList());
    }

    List<Piece> values() {
        return new ArrayList<>(map.values());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Board board = (Board) o;
        return Objects.equals(map, board.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
