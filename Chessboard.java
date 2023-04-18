public class Chessboard {
    private static Piece_Template[][] board;
    private static int turnNumber;

    public Chessboard() {
        //this.board = new Piece_Template[8][8];
        Chessboard.board = new Piece_Template[8][8];

        //Set up the initial positions of the pieces
        //Whites
        board[0][0] = new Piece_Rook(true, 0, 0, false, "WR");
        board[1][0] = new Piece_Knight(true, 1, 0, false, "WN");
        board[2][0] = new Piece_Bishop(true, 2, 0, false, "WB");
        board[3][0] = new Piece_Queen(true, 3, 0, false, "WQ");
        board[4][0] = new Piece_King(true, 4, 0, false, "WK");
        board[5][0] = new Piece_Bishop(true, 5, 0, false, "WB");
        board[6][0] = new Piece_Knight(true, 6, 0, false, "WN");
        board[7][0] = new Piece_Rook(true, 7, 0, false, "WR");
        for (int i = 0; i < 8; i++) {board[i][1] = new Piece_Pawn(true, i, 1, false, "WP");}
        //Blacks
        board[0][7] = new Piece_Rook(false, 7, 0, false, "BR");
        board[1][7] = new Piece_Knight(false, 7, 1, false, "BN");
        board[2][7] = new Piece_Bishop(false, 7, 2, false, "BB");
        board[3][7] = new Piece_Queen(false, 7, 3, false, "BQ");
        board[4][7] = new Piece_King(false, 7, 4, false, "BK");
        board[5][7] = new Piece_Bishop(false, 7, 5, false, "BB");
        board[6][7] = new Piece_Knight(false, 7, 6, false, "BN");
        board[7][7] = new Piece_Rook(false, 7, 7, false, "BR");
        for (int i = 0; i < 8; i++) {board[i][6] = new Piece_Pawn(false, i, 6, false, "BP");}
        Chessboard.turnNumber = 1;
    }
    
    //I'm looking at this 2 months later and I have absolutely no clue what I did.
    public static boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece_Template piece = board[startX][startY];
        // Check if the starting position is not empty
        if (piece == null) {
            return false;
        }
        // Check if it is the correct player's turn
        if ((piece.isWhite() && !isWhiteTurn()) || (!piece.isWhite() && isWhiteTurn())) {
            return false;
        }
        // Check if the move is valid
        if (piece.isValidMove(endX, endY, board)) {
            // Handle en passant
            if (piece instanceof Piece_Pawn && startX != endX && board[endX][endY] == null) {
                int capturedX = startX;
                int capturedY = endY;
                if (piece.isWhite()) {
                    capturedX--;
                } else {
                    capturedX++;
                }
                board[capturedX][capturedY] = null;
            }
            // Handle castling
            if (piece instanceof Piece_King && Math.abs(startY - endY) == 2) {
                int rookStartX = startX;
                int rookEndX = startX;
                int rookStartY;
                int rookEndY;
                if (endY == 2) {
                    rookStartY = 0;
                    rookEndY = 3;
                } else {
                    rookStartY = 7;
                    rookEndY = 5;
                }
                Piece_Template rook = board[rookStartX][rookStartY];
                board[rookStartX][rookStartY] = null;
                board[rookEndX][rookEndY] = rook;
                rook.setX(rookEndX);
                rook.setY(rookEndY);
                rook.setHasMoved(true);
            }
            // Move the piece to the ending position
            board[endX][endY] = piece;
            board[startX][startY] = null;
            // Update the position of the piece
            piece.setX(endX);
            piece.setY(endY);
            piece.setHasMoved(true);
            Chessboard.turnNumber++;
            return true;
        }
        // Otherwise, the move is not valid
        return false;
    }
 
    public static boolean endCheckerBlack() {
        boolean isWhiteKingGone = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece_Template piece = board[i][j];
                if (piece instanceof Piece_King && piece.isWhite() == true) {
                    isWhiteKingGone = false;
                }

            }
        }
        return isWhiteKingGone;
    }

    public static boolean endCheckerWhite() {
        boolean isBlackKingGone = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece_Template piece = board[i][j];
                if (piece instanceof Piece_King && piece.isWhite() == false) {
                    isBlackKingGone = false;
                }

            }
        }
        return isBlackKingGone;
    }

    public static int CharToInt(char input) {
		switch(input) {
			case 'a':
				return 1;
			case 'b':
				return 2;
			case 'c':
				return 3;
			case 'd':
				return 4;
			case 'e':
				return 5;
			case 'f':
				return 6;
			case 'g':
				return 7;
			case 'h':
				return 8;
		}
		return -69; //nice
	}
    
    public static boolean isWhiteTurn() {
        return ((turnNumber % 2) == 1);
    }

    public static int getTurn() {
        return turnNumber;
    }

    String printBoardPiece(int x, int y) {
        if (board[x][y] == null) {return "     ";}
        String toBePrinted = board[x][y].getPrintable() + " " + board[x][y].getPrintable();
        return toBePrinted;
    }
    
    public void printBoard() {
        Commands.clear();
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        //System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 88 88 | " + printBoardPiece(0, 7) + " | " + printBoardPiece(1, 7) + " | " + printBoardPiece(2, 7) + " | " + printBoardPiece(3, 7) + " | " + printBoardPiece(4, 7) + " | " + printBoardPiece(5, 7) + " | " + printBoardPiece(6, 7) + " | " + printBoardPiece(7, 7) + " | 88 88");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 88 88 | " + printBoardPiece(0, 7) + " | " + printBoardPiece(1, 7) + " | " + printBoardPiece(2, 7) + " | " + printBoardPiece(3, 7) + " | " + printBoardPiece(4, 7) + " | " + printBoardPiece(5, 7) + " | " + printBoardPiece(6, 7) + " | " + printBoardPiece(7, 7) + " | 88 88");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 77 77 | " + printBoardPiece(0, 6) + " | " + printBoardPiece(1, 6) + " | " + printBoardPiece(2, 6) + " | " + printBoardPiece(3, 6) + " | " + printBoardPiece(4, 6) + " | " + printBoardPiece(5, 6) + " | " + printBoardPiece(6, 6) + " | " + printBoardPiece(7, 6) + " | 77 77 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 77 77 | " + printBoardPiece(0, 6) + " | " + printBoardPiece(1, 6) + " | " + printBoardPiece(2, 6) + " | " + printBoardPiece(3, 6) + " | " + printBoardPiece(4, 6) + " | " + printBoardPiece(5, 6) + " | " + printBoardPiece(6, 6) + " | " + printBoardPiece(7, 6) + " | 77 77 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 66 66 | " + printBoardPiece(0, 5) + " | " + printBoardPiece(1, 5) + " | " + printBoardPiece(2, 5) + " | " + printBoardPiece(3, 5) + " | " + printBoardPiece(4, 5) + " | " + printBoardPiece(5, 5) + " | " + printBoardPiece(6, 5) + " | " + printBoardPiece(7, 5) + " | 66 66 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 66 66 | " + printBoardPiece(0, 5) + " | " + printBoardPiece(1, 5) + " | " + printBoardPiece(2, 5) + " | " + printBoardPiece(3, 5) + " | " + printBoardPiece(4, 5) + " | " + printBoardPiece(5, 5) + " | " + printBoardPiece(6, 5) + " | " + printBoardPiece(7, 5) + " | 66 66 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 55 55 | " + printBoardPiece(0, 4) + " | " + printBoardPiece(1, 4) + " | " + printBoardPiece(2, 4) + " | " + printBoardPiece(3, 4) + " | " + printBoardPiece(4, 4) + " | " + printBoardPiece(5, 4) + " | " + printBoardPiece(6, 4) + " | " + printBoardPiece(7, 4) + " | 55 55 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 55 55 | " + printBoardPiece(0, 4) + " | " + printBoardPiece(1, 4) + " | " + printBoardPiece(2, 4) + " | " + printBoardPiece(3, 4) + " | " + printBoardPiece(4, 4) + " | " + printBoardPiece(5, 4) + " | " + printBoardPiece(6, 4) + " | " + printBoardPiece(7, 4) + " | 55 55 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 44 44 | " + printBoardPiece(0, 3) + " | " + printBoardPiece(1, 3) + " | " + printBoardPiece(2, 3) + " | " + printBoardPiece(3, 3) + " | " + printBoardPiece(4, 3) + " | " + printBoardPiece(5, 3) + " | " + printBoardPiece(6, 3) + " | " + printBoardPiece(7, 3) + " | 44 44 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 44 44 | " + printBoardPiece(0, 3) + " | " + printBoardPiece(1, 3) + " | " + printBoardPiece(2, 3) + " | " + printBoardPiece(3, 3) + " | " + printBoardPiece(4, 3) + " | " + printBoardPiece(5, 3) + " | " + printBoardPiece(6, 3) + " | " + printBoardPiece(7, 3) + " | 44 44 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 33 33 | " + printBoardPiece(0, 2) + " | " + printBoardPiece(1, 2) + " | " + printBoardPiece(2, 2) + " | " + printBoardPiece(2, 2) + " | " + printBoardPiece(4, 2) + " | " + printBoardPiece(5, 2) + " | " + printBoardPiece(6, 2) + " | " + printBoardPiece(7, 2) + " | 33 33 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 33 33 | " + printBoardPiece(0, 2) + " | " + printBoardPiece(1, 2) + " | " + printBoardPiece(2, 2) + " | " + printBoardPiece(3, 2) + " | " + printBoardPiece(4, 2) + " | " + printBoardPiece(5, 2) + " | " + printBoardPiece(6, 2) + " | " + printBoardPiece(7, 2) + " | 33 33 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 22 22 | " + printBoardPiece(0, 1) + " | " + printBoardPiece(1, 1) + " | " + printBoardPiece(2, 1) + " | " + printBoardPiece(3, 1) + " | " + printBoardPiece(4, 1) + " | " + printBoardPiece(5, 1) + " | " + printBoardPiece(6, 1) + " | " + printBoardPiece(7, 1) + " | 22 22 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 22 22 | " + printBoardPiece(0, 1) + " | " + printBoardPiece(1, 1) + " | " + printBoardPiece(2, 1) + " | " + printBoardPiece(3, 1) + " | " + printBoardPiece(4, 1) + " | " + printBoardPiece(5, 1) + " | " + printBoardPiece(6, 1) + " | " + printBoardPiece(7, 1) + " | 22 22 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 11 11 | " + printBoardPiece(0, 0) + " | " + printBoardPiece(1, 0) + " | " + printBoardPiece(2, 0) + " | " + printBoardPiece(3, 0) + " | " + printBoardPiece(4, 0) + " | " + printBoardPiece(5, 0) + " | " + printBoardPiece(6, 0) + " | " + printBoardPiece(7, 0) + " | 11 11 ");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 11 11 | " + printBoardPiece(0, 0) + " | " + printBoardPiece(1, 0) + " | " + printBoardPiece(2, 0) + " | " + printBoardPiece(3, 0) + " | " + printBoardPiece(4, 0) + " | " + printBoardPiece(5, 0) + " | " + printBoardPiece(6, 0) + " | " + printBoardPiece(7, 0) + " | 11 11 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
    }
}