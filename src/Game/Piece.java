package Game;

public class Piece {
    PieceType type;
    PlayerColor color;


    public Piece(PieceType type, PlayerColor color) {
        this.type = type;
        this.color = color;
    }

    public PieceType getPieceType() {
        return type;
    }

    public PlayerColor getPlayerColor() {
        return color;
    }
}
