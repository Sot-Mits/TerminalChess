import java.util.Scanner;

public class Input {
    /* Putting keyboardInput here instead of inside InputHandler() so I can close it at the end of main() (technically at the Quit() function).
	   Reason being that VS Code is pestering me about memory leaks and closing the scanner inside InputHandler() causes wonky behaviour
	   Trust me I tried lol. */
	static final Scanner keyboardInput = new Scanner(System.in);
	/* Putting this outside InputHandler() so I can use the function recursively.
	   I thought it'd be worse since it's not enclosed in the function but honestly it's made the code so much simpler. */
	private static String userInput;
	/* Function to ensure userInput is lowercase (makes everything else easier) and legal.
		Primary function for getting input. 
		Other function is for when commands are on the table.*/
	public static void InputSetter() {
		userInput = keyboardInput.nextLine();

		//If the user enters legal input.
		if (userInput.length() != 0) {
			System.out.println(); //This is here because I think it makes it look prettier :)
			userInput = userInput.toLowerCase();
			return;
		}	   
		//If the input isn't blank.
		System.out.println("Please enter a valid input.");
		InputSetter();
	} 

	public static String InputGetter() {return userInput;}

    protected static String Truncator(String toBeTruncated, char start, char end) {
		String truncatedString;
		//For what I'm using Truncator(), start + 1 works better I think
		try {
			truncatedString = toBeTruncated.substring(Input.InputGetter().indexOf(start) + 1, Input.InputGetter().indexOf(end));
		}
		catch (Exception General) {
			truncatedString = toBeTruncated.substring(Input.InputGetter().indexOf(start) + 1, Input.InputGetter().length());
		}
		return truncatedString;
	}

	//*
	public static void InGameCommandHandler() {
		InputSetter();

		if (userInput.charAt(0) == '-') {
			Commands.Execution();
			return;
		}
	} //*/


	public static void CommandHandler() {
		InputSetter();	

		if (userInput.charAt(0) == '-') {
			Commands.Execution();
			return;
		}
		//Same rationale as InputHandler()
		System.out.println("No command found. Try Again."); 
		CommandHandler();
	}
}
