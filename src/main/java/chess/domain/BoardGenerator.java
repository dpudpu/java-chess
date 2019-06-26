package chess.domain;

import chess.domain.rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BoardGenerator {
    private static final int ROW_8 = 8;
    private static final int ROW_7 = 7;
    private static final int ROW_6 = 6;
    private static final int ROW_3 = 3;
    private static final int ROW_2 = 2;
    private static final int ROW_1 = 1;

    private BoardGenerator() {
    }

    public static Map<Position, Piece> generate() {
        Map<Position, Piece> map = new TreeMap<>();

        initBlackPieces(map, ROW_8);
        initBlackPawns(map, ROW_7);
        initEmptyPieces(map, ROW_6, ROW_3);
        initWhitePawns(map, ROW_2);
        initWhitePieces(map, ROW_1);

        return map;
    }

    private static void initBlackPieces(final Map<Position, Piece> map, final int rowIndex) {
        List<Position> positions = getColumns(rowIndex);
        map.put(positions.get(0), Rook.createBlack(positions.get(0)));
        map.put(positions.get(1), Knight.createBlack(positions.get(1)));
        map.put(positions.get(2), Bishop.createBlack(positions.get(2)));
        map.put(positions.get(3), Queen.createBlack(positions.get(3)));
        map.put(positions.get(4), King.createBlack(positions.get(4)));
        map.put(positions.get(5), Bishop.createBlack(positions.get(5)));
        map.put(positions.get(6), Knight.createBlack(positions.get(6)));
        map.put(positions.get(7), Rook.createBlack(positions.get(7)));
    }

    private static void initBlackPawns(final Map<Position, Piece> map, final int rowIndex) {
        List<Position> positions = getColumns(rowIndex);
        for (Position position : positions) {
            map.put(position, Pawn.createBlack(position));
        }
    }

    private static void initEmptyPieces(final Map<Position, Piece> map, final int starIndex, final int endIndex) {
        for (int i = starIndex; i >= endIndex; i--) {
            final List<Position> positions = getColumns(i);
            for (Position position : positions) {
                map.put(position, Empty.create(position));
            }
        }
    }

    private static void initWhitePawns(final Map<Position, Piece> map, final int rowIndex) {
        List<Position> positions = getColumns(rowIndex);
        for (Position position : positions) {
            map.put(position, Pawn.createWhite(position));
        }
    }

    private static void initWhitePieces(final Map<Position, Piece> map, final int rowIndex) {
        List<Position> positions = getColumns(rowIndex);
        map.put(positions.get(0), Rook.createWhite(positions.get(0)));
        map.put(positions.get(1), Knight.createWhite(positions.get(1)));
        map.put(positions.get(2), Bishop.createWhite(positions.get(2)));
        map.put(positions.get(3), Queen.createWhite(positions.get(3)));
        map.put(positions.get(4), King.createWhite(positions.get(4)));
        map.put(positions.get(5), Bishop.createWhite(positions.get(5)));
        map.put(positions.get(6), Knight.createWhite(positions.get(6)));
        map.put(positions.get(7), Rook.createWhite(positions.get(7)));
    }

    private static List<Position> getColumns(final int rowIndex) {
        List<Position> positions = new ArrayList<>();
        for (int i = Column.MIN; i <= Column.MAX; i++) {
            Position position = Position.of(String.valueOf(rowIndex), String.valueOf((char) i));
            positions.add(position);
        }
        return positions;
    }
}
