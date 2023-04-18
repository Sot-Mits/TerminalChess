public class Piece_Pawn extends Piece_Template {
    private boolean hasMoved;
    private int enPassantTurn;
    
    public Piece_Pawn(boolean isWhite, int x, int y, boolean hasMoved, String printable) {
        super(isWhite, x, y, hasMoved, printable);
        //this.hasMoved = false;
        enPassantTurn = 0;
    }

    public Piece_Pawn(boolean isWhite, int x, int y, boolean hasMoved) {
        super(isWhite, x, y, hasMoved);
        enPassantTurn = 0;
    }
    
    public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
        int x = getX();
        int y = getY();
        
        //Check if the move is within the bounds of the board
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {return false;}
        
        //Check if the move is a valid pawn move
        int direction = isWhite() ? 1 : -1;
        if (newX == x && board[newX][newY] == null) {
            // Move forward one square
            if (newY == y + direction) {
                hasMoved = true;
                return true;
            }
            //Move forward two squares on first move
            else if (!hasMoved && newY == y + 2 * direction && board[x][y + direction] == null) {
                hasMoved = true;
                enPassantTurn = Chessboard.getTurn();
                return true;
            }
        }
        //Capture an opponent's piece diagonally
        else if (Math.abs(newX - x) == 1 && newY == y + direction && board[newX][newY] != null && board[newX][newY].isWhite() != isWhite()) {
            hasMoved = true;
            return true;
        }
        //Check for en passant
        else if (Math.abs(newX - x) == 1 && newY == y + direction && board[newX][newY] == null && board[newX][y] instanceof Piece_Pawn && ((Piece_Pawn) board[newX][y]).enPassantTurn == Chessboard.getTurn() - 1 && ((Piece_Pawn) board[newX][y]).isWhite() != isWhite()) {
            hasMoved = true;
            return true;
        }
        
        return false;
    }
}
