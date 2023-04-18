public class Piece_Rook extends Piece_Template {
    private boolean hasMoved;

    public Piece_Rook(boolean isWhite, int x, int y, boolean hasMoved, String printable) {super(isWhite, x, y, hasMoved, printable);}

    public Piece_Rook(boolean isWhite, int x, int y, boolean hasMoved) {super(isWhite, x, y, hasMoved);}
    
    public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
        int x = getX();
        int y = getY();
        
        //Check if the move is within the bounds of the board
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {return false;}
        
        //Check if the move is a valid horizontal or vertical move
        if (newX == x || newY == y) {
            // Check if the path is clear
            int xDir = Integer.compare(newX, x);
            int yDir = Integer.compare(newY, y);
            int i = x + xDir;
            int j = y + yDir;
            while (i != newX || j != newY) {
                if (board[i][j] != null) {return false;}
                i += xDir;
                j += yDir;
            }
            //The path is clear, so the move is valid
            this.hasMoved = true;
            return true;
        }
        //Otherwise, the move is not valid
        else {return false;}
    }
    
    public boolean hasMoved() {return this.hasMoved;}
}
