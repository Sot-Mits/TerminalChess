public class Piece_Knight extends Piece_Template {
    
    public Piece_Knight(boolean isWhite, int x, int y, boolean hasMoved, String printable) {super(isWhite, x, y, hasMoved, printable);}

    public Piece_Knight(boolean isWhite, int x, int y, boolean hasMoved) {super(isWhite, x, y, hasMoved);}
    
    public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
        int x = getX();
        int y = getY();
        
        //Check if the move is within the bounds of the board
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            return false;
        }
        
        //Check if the move is a valid L-shape move
        int deltaX = Math.abs(newX - x);
        int deltaY = Math.abs(newY - y);
        if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) {
            // Check if the ending position is not occupied by a piece of the same color
            Piece_Template piece = board[newX][newY];
            if (piece == null || piece.isWhite() != isWhite()) {return true;}
        }
        //Otherwise, the move is not valid
        return false;
    }
}
