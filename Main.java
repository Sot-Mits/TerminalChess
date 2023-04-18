/* A simple chess program for the terminal
   I'll probably upload this to GrubHub. */

/* Makes me so happy I finally get to utilise the overtly autistic input handling.
   SUCK IT WILLIAM! */

public class Main {
	//Declaring all objects here for the simplicity of it.
	//Is it more simple?
	public static Main main = new Main();
	public static Help help = new Help();
	public static Input input = new Input();
	public static Commands commands = new Commands();
	public static Play play = new Play();
	public static Chessboard chessboard = new Chessboard();
	//Pieces pieces = new Pieces();

	//main
	//*
	public static void main(String[] args) {
		Commands.clear();
		help.Intro();

		Commands.clear();
		Play.Game();

		Commands.Quit();
	} //*/
}

