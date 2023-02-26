package AI;

import Game.Board;

public class ChessBot {


    public ChessBot() {}

    public void run() {
        //create a new board
        Board board = new Board();
        //initialize the board
        board.initializeBoard();
        //print the board
        board.printBoard();


    }
}
