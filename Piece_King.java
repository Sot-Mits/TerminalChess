public class Piece_King extends Piece_Template {
	private boolean hasMoved;
	
	public Piece_King(boolean isWhite, int x, int y, boolean hasMoved, String printable) {super(isWhite, x, y, hasMoved, printable);}

	public Piece_King(boolean isWhite, int x, int y, boolean hasMoved) {super(isWhite, x, y, hasMoved);}
	
	public boolean isValidMove(int newX, int newY, Piece_Template[][] board) {
		int x = getX();
		int y = getY();
		
		//Check if the move is within the bounds of the board
		if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {return false;}
		
		//Check if the move is a valid king move
		if ((Math.abs(newX - x) == 1 && Math.abs(newY - y) <= 1) || (Math.abs(newX - x) <= 1 && Math.abs(newY - y) == 1)) {
			// Check if the target square is empty or contains an opponent's piece
			if (board[newX][newY] == null || board[newX][newY].isWhite() != isWhite()) {
				hasMoved = true;
				return true;
			}
		}
		
		//Check if the move is a castling move
		if (!hasMoved && newY == y) {
			if (newX == x + 2 && board[x + 1][y] == null && board[x + 2][y] == null && board[x + 3][y] instanceof Piece_Rook && !((Piece_Rook) board[x + 3][y]).hasMoved()) {
				hasMoved = true;
				return true;
			}
			else if (newX == x - 2 && board[x - 1][y] == null && board[x - 2][y] == null && board[x - 3][y] == null && board[x - 4][y] instanceof Piece_Rook && !((Piece_Rook) board[x - 4][y]).hasMoved()) {
				hasMoved = true;
				return true;
			}
		}
		
		return false;
	}
}
