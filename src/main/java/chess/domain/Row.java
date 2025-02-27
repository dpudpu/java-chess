package chess.domain;

import java.util.*;

public class Row implements Comparable<Row> {
    private static final Map<Integer, Row> ROWS = new HashMap<>();
    static final int MIN = 1;
    static final int MAX = 8;

    private final int row;

    static {
        for (int i = MIN; i <= MAX; i++) {
            ROWS.put(i, new Row(i));
        }
    }

    private Row(final int row) {
        this.row = row;
    }

    public static Row from(final int row) {
        Optional<Row> optRow = Optional.ofNullable(ROWS.get(row));
        return optRow.orElseThrow(IllegalArgumentException::new);
    }

    static Row from(final String row) {
        return from(Integer.parseInt(row));
    }

    Row next(int delta) {
        return ROWS.get(row + delta);
    }

    int calculateAbsolute(final Row other) {
        return Math.abs(this.row - other.row);
    }

    int calculateSubtraction(final Row other) {
        return this.row - other.row;
    }

    int vectorOf(final Row other) {
        return this.row - other.row;
    }

    static List<Row> values() {
        return new ArrayList<>(ROWS.values());
    }

    @Override
    public int compareTo(final Row o) {
        return o.row - this.row;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Row row1 = (Row) o;
        return row == row1.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }

    @Override
    public String toString() {
        return String.valueOf(row);
    }
}
