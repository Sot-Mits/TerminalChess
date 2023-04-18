public class Commands {
	public static void Execution() {
		String command; 
		//For commands that have arguments; truncates string after whitespace (if there's a whitespace)
		command = Input.Truncator(Input.InputGetter(), '-', ' ');

		//Play
		if ((command.equals("p")) || (command.equals("play"))) {
			if (Help.introLoop == true) { 
				Help.introLoop = false;
			}
			else if (Help.introLoop == false) {
				boolean breakGameLoop = true;
				do {
					System.out.println("Already in a game. Start a new one? (y/n)");
					Input.InputSetter();
					//Yes ik this looks horrendous
					if ((Input.InputGetter().equals("y")) || (Input.InputGetter().equals("ye")) || (Input.InputGetter().equals("yes"))) {
						Play.isGameOngoing = false;
						Play.Game();
					}
					else if ((Input.InputGetter().equals("n")) || (Input.InputGetter().equals("no")) || (Input.InputGetter().equals("nah"))) {
						breakGameLoop = false;
						System.out.println("Operation aborted; continuing current game");
					}
					else {
						System.out.println("No valid input detected. Try again.");	
					}
				} while (breakGameLoop); //todo - figure condition for this 
			}
		}

		//Help
		else if ((command.equals("h")) || (command.equals("help"))) {
			String helpArgument;
			helpArgument = Input.Truncator(Input.InputGetter(), ' ', Character.MIN_VALUE);

			switch (helpArgument) {
				case "pieces":
					Help.PiecesPage();
					break;
				case "chessboard":
					Help.ChessboardPage();
					break;
				/* 
				case "savefile":
					Help.SavefilePage();
					break; /*/
				case "commands":
					Help.CommandsPage();
					break;
				case "main":
					Help.MainPage();
					break;
				default:
					Help.MainPage();
			}			
		}

		//Quit
		else if ((command.equals("q")) || (command.equals("quit"))) {
			Quit();
		}

		//Else
		
		else {System.out.println(command + " not recognized. Try again.");}		
	}

	static void clear() {
        //Still have no idea how this works.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

	public static void Quit() {
		System.out.println("Quitting program...");
		Input.keyboardInput.close();
		System.exit(0);  
	}	
}