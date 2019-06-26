package chess.domain.piece;

import chess.domain.Piece;
import chess.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    Pawn firstWhitePawn;
    Pawn firstBlackPawn;
    Pawn secondWhitePawn;
    Pawn secondBlackPawn;

    @BeforeEach
    void setUp() {
        firstWhitePawn = Pawn.createWhite(Position.of("2", "g"));
        firstBlackPawn = Pawn.createBlack(Position.of("7", "g"));

        secondWhitePawn = Pawn.createWhite(Position.of("3", "g"));
        secondBlackPawn = Pawn.createBlack(Position.of("6", "g"));
    }

    @Test
    public void FIRST_WHITE_Pawn_한칸_이동() {
        Position other = Position.of("3", "g");

        assertTrue(firstWhitePawn.isValidMove(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_두칸_이동() {
        Position other = Position.of("4", "g");

        assertTrue(firstWhitePawn.isValidMove(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_뒤_이동_불가능() {
        Position other = Position.of("1", "g");

        assertFalse(firstWhitePawn.isValidMove(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_세칸_이동_불가능() {
        Position other = Position.of("5", "g");

        assertFalse(firstWhitePawn.isValidMove(other));
    }

    @Test
    public void FIRST_BLACK_Pawn__한칸_이동() {
        Position other = Position.of("6", "g");

        assertTrue(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void FIRST_BLACK_Pawn__두칸_이동() {
        Position other = Position.of("5", "g");

        assertTrue(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_뒤로_이동_불가능() {
        Position other = Position.of("8", "g");

        assertFalse(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_세칸_이동_불가능() {
        Position other = Position.of("4", "g");

        assertFalse(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_한칸_이동() {
        Position other = Position.of("5", "g");

        assertTrue(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_두칸_이동_불가능() {
        Position other = Position.of("4", "g");

        assertFalse(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_한칸_이동_가능() {
        Position other = Position.of("4", "g");

        assertTrue(secondWhitePawn.isValidMove(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_두칸_이동_불가능() {
        Position other = Position.of("5", "g");

        assertFalse(secondWhitePawn.isValidMove(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_뒤로_이동_불가능() {
        Position other = Position.of("2", "g");

        assertFalse(firstBlackPawn.isValidMove(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_공격_왼쪽_대각선_가능() {
        Piece other = Rook.createBlack(Position.of("3", "f"));
        assertTrue(firstWhitePawn.isValidAttack(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_공격_오른쪽_대각선_가능() {
        Position position = Position.of("3", "h");
        Piece other = Rook.createBlack(position);
        assertTrue(firstWhitePawn.isValidAttack(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_공격_뒤_오른쪽_대각선_불가능() {
        Position position = Position.of("1", "h");
        Piece other = Rook.createBlack(position);
        assertFalse(firstWhitePawn.isValidAttack(other));
    }

    @Test
    public void FIRST_WHITE_Pawn_공격_뒤_왼쪽_대각선_불가능() {
        Position position = Position.of("1", "f");
        Piece other = Rook.createBlack(position);
        assertFalse(firstWhitePawn.isValidAttack(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_공격_왼쪽_대각선() {
        Position position = Position.of("6", "f");
        Piece other = Rook.createWhite(position);
        assertTrue(firstBlackPawn.isValidAttack(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_공격_오른쪽_대각선() {
        Position position = Position.of("6", "h");
        Piece other = Rook.createWhite(position);
        assertTrue(firstBlackPawn.isValidAttack(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_공격_뒤_오른쪽_불가능() {
        Position position = Position.of("8", "h");
        Piece other = Rook.createWhite(position);
        assertFalse(firstBlackPawn.isValidAttack(other));
    }

    @Test
    public void FIRST_BLACK_Pawn_공격_뒤_왼쪽_불가능() {
        Position position = Position.of("8", "f");
        Piece other = Rook.createWhite(position);
        assertFalse(firstBlackPawn.isValidAttack(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_공격_오른쪽_대각선() {
        Position position = Position.of("4", "h");
        Piece other = Rook.createBlack(position);
        assertTrue(secondWhitePawn.isValidAttack(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_공격_왼쪽_대각선() {
        Position position = Position.of("4", "f");
        Piece other = Rook.createBlack(position);
        assertTrue(secondWhitePawn.isValidAttack(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_공격_뒤_왼쪽_대각선_불가능() {
        Position position = Position.of("2", "f");
        Piece other = Rook.createBlack(position);
        assertFalse(secondWhitePawn.isValidAttack(other));
    }

    @Test
    public void SECOND_WHITE_Pawn_공격_뒤_오른쪽_대각선_불가능() {
        Position position = Position.of("2", "h");
        Piece other = Rook.createBlack(position);
        assertFalse(secondWhitePawn.isValidAttack(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_공격_오른쪽_대각선_가능() {
        Position position = Position.of("5", "h");
        Piece other = Rook.createWhite(position);
        assertTrue(secondBlackPawn.isValidAttack(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_공격_왼쪽_대각선_가능() {
        Position position = Position.of("5", "f");
        Piece other = Rook.createWhite(position);
        assertTrue(secondBlackPawn.isValidAttack(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_공격_뒤_왼쪽_불가능() {
        Position position = Position.of("8", "f");
        Piece other = Rook.createWhite(position);
        assertFalse(secondBlackPawn.isValidAttack(other));
    }

    @Test
    public void SECOND_BLACK_Pawn_공격_뒤_오른쪽_불가능() {
        Position position = Position.of("8", "h");
        Piece other = Rook.createWhite(position);
        assertFalse(secondBlackPawn.isValidAttack(other));
    }
}