public class Piece_Queen extends Piece_Template {
    
    public Piece_Queen(boolean isWhite, int x, int y, boolean hasMoved, String printable) {super(isWhite, x, y, hasMoved, printable);}

    public Piece_Queen(boolean isWhite, int x, int y, boolean hasMoved) {super(isWhite, x, y, hasMoved);}
    
    public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
        int x = getX();
        int y = getY();
        
        //Check if the move is within the bounds of the board
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {return false;}
        
        //Check if the move is a valid rook move (horizontal or vertical)
        if (newX == x || newY == y) {
            Piece_Rook rook = new Piece_Rook(isWhite(), x, y, getHasMoved());
            return rook.isValidMove(newX, newY, board);
        }
        //Check if the move is a valid bishop move (diagonal)
        else if (Math.abs(newX - x) == Math.abs(newY - y)) {
            Piece_Bishop bishop = new Piece_Bishop(isWhite(), x, y, getHasMoved());
            return bishop.isValidMove(newX, newY, board);
        }
        //Otherwise, the move is not valid
        else {return false;}
    }
}
