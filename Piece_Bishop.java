public class Piece_Bishop extends Piece_Template {
    
    public Piece_Bishop(boolean isWhite, int x, int y, boolean hasMoved, String printable) {super(isWhite, x, y, hasMoved, printable);}

    public Piece_Bishop(boolean isWhite, int x, int y, boolean hasMoved) {super(isWhite, x, y, hasMoved);}
    
    public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
        int x = getX();
        int y = getY();
        
        //Check if the move is within the bounds of the board
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {return false;}
        
        //Check if the move is a valid diagonal move
        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            int xDirection = (newX - x) > 0 ? 1 : -1;
            int yDirection = (newY - y) > 0 ? 1 : -1;
            int i = x + xDirection;
            int j = y + yDirection;
            while (i != newX && j != newY) {
                if (board[i][j] != null) {return false;}
                i += xDirection;
                j += yDirection;
            }
            return true;
        }
        //Otherwise, the move is not valid
        else {return false;}
    }
}
