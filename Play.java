public class Play {
	static Chessboard chessboard = new Chessboard();
	
	static boolean isGameOngoing = false;
	static boolean isValidMove;

	static boolean hasWhiteWon;
	static boolean hasBlackWon;

	static void Game() {
		int startX;
		int startY;

		int endX;
		int endY;

		isGameOngoing = true;
		do {
			chessboard.printBoard();

			System.out.println("Enter a move.");
			//Input.InGameCommandHandler();
			
			do {
				Input.InGameCommandHandler();
				isValidMove = true;
				try {
					startX = Chessboard.CharToInt(Input.InputGetter().charAt(0));
					startY = Input.InputGetter().charAt(1);

					endX = Chessboard.CharToInt(Input.InputGetter().charAt(3));
					endY = Input.InputGetter().charAt(4);

					isValidMove = Chessboard.movePiece(startX, startY, endX, endY);
				}

				catch (Exception generalException) {
					isValidMove = false;
				}

				if (!isValidMove) {
					System.out.println("Please enter a valid input.");
				}
				
			} while (!isValidMove);
			
		hasWhiteWon = Chessboard.endCheckerWhite();		
		hasBlackWon = Chessboard.endCheckerBlack();

		if (hasWhiteWon == true || hasBlackWon == true) {
			isGameOngoing = false;
			chessboard.printBoard();
		}

		} while (isGameOngoing);

		if (hasWhiteWon) {
			System.out.println("White Won!!!");
		}
		else if (hasBlackWon) {
			System.out.println("Black Won!!!");
		}

		System.out.println("Thank you for playing Terminal Chess!!!");
	}
	

	
}