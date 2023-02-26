package Game;

import java.util.ArrayList;

public class Board {

    ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();

    public void initializeBoard() {
        //board. (new Piece(PieceType.Pawn,PlayerColor.White));
        //fill the board with Pawn pieces
        for (int i = 0; i < 8; i++) {
            board.add(new ArrayList<Piece>());
            for (int j = 0; j < 8; j++) {
                board.get(i).add(new Piece(PieceType.Empty, PlayerColor.Empty));
            }
        }

        //Update the board with the correct pieces
        for (int i = 0; i < 8; i++) {
            board.get(1).set(i, new Piece(PieceType.Pawn, PlayerColor.White));
            board.get(6).set(i, new Piece(PieceType.Pawn, PlayerColor.Black));
        }
        board.get(0).set(0, new Piece(PieceType.Rook, PlayerColor.White));
        board.get(0).set(7, new Piece(PieceType.Rook, PlayerColor.White));
        board.get(7).set(0, new Piece(PieceType.Rook, PlayerColor.Black));
        board.get(7).set(7, new Piece(PieceType.Rook, PlayerColor.Black));
        board.get(0).set(1, new Piece(PieceType.Knight, PlayerColor.White));
        board.get(0).set(6, new Piece(PieceType.Knight, PlayerColor.White));
        board.get(7).set(1, new Piece(PieceType.Knight, PlayerColor.Black));
        board.get(7).set(6, new Piece(PieceType.Knight, PlayerColor.Black));
        board.get(0).set(2, new Piece(PieceType.Bishop, PlayerColor.White));
        board.get(0).set(5, new Piece(PieceType.Bishop, PlayerColor.White));
        board.get(7).set(2, new Piece(PieceType.Bishop, PlayerColor.Black));
        board.get(7).set(5, new Piece(PieceType.Bishop, PlayerColor.Black));
        board.get(0).set(3, new Piece(PieceType.Queen, PlayerColor.White));
        board.get(0).set(4, new Piece(PieceType.King, PlayerColor.White));
        board.get(7).set(3, new Piece(PieceType.Queen, PlayerColor.Black));
        board.get(7).set(4, new Piece(PieceType.King, PlayerColor.Black));

    }

    public void printBoard() {
        //format the board so it looks like a chess board, and each print statement is of equal length
        System.out.println("-----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                System.out.print(convertPieceType(board.get(i).get(j).getPieceType()) + "|");
            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    //Convert piece types into single letters representing the piece
    public String convertPieceType(PieceType type) {
        return switch (type) {
            case Pawn -> "P";
            case Rook -> "R";
            case Knight -> "N";
            case Bishop -> "B";
            case Queen -> "Q";
            case King -> "K";
            case Empty -> " ";
            default -> " ";
        };
    }

    public void movePiece(int x1, int y1, int x2, int y2) {
        board.get(x2).set(y2, board.get(x1).get(y1));
        board.get(x1).set(y1, new Piece(PieceType.Empty, PlayerColor.Empty));
    }

    public void movePiece(Piece piece, int x2, int y2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.get(i).get(j).equals(piece)) {
                    board.get(x2).set(y2, board.get(i).get(j));
                    board.get(i).set(j, new Piece(PieceType.Empty, PlayerColor.Empty));
                }
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return board.get(x).get(y);
    }



}
