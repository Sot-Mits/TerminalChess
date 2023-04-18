public class Help {

    public static boolean introLoop = true;

    public void Intro() {
        System.out.println("Welcome to Terminal Chess!");

        do {
            //Commands.clear();
            System.out.println("Press -p to play.");
            System.out.println("Press -h to get help.");
            //Shutdown should (in theory) always be graceful.
            System.out.println("Press -q to exit the program.");
            System.out.println();
            System.out.println("Please enter your input.");
            Input.CommandHandler();
        } while(introLoop);
    }

    static void GoOn() {
        System.out.println("Press any key to continue");
        Input.keyboardInput.next();
        Commands.clear();
    }

    public static void MainPage() {
        System.out.println("Welcome to Terminal Chess, the chess app designed to play right from your terminal!");
        System.out.println("Type in any of the following commands to learn about the corresponding topic.");
        System.out.println();
        System.out.println("If for whatever reason you want to leave any of the help pages (including this one), simply press enter.");
        System.out.println();
        System.out.println("-h");
        System.out.println("-h main");
        System.out.println("\tDisplays this page.");
        System.out.println();
        System.out.println("-h pieces");
        System.out.println("\tLists all pieces and explains their moves as well as the move notation system.");
        System.out.println();
        System.out.println("-h chessboard");
        System.out.println("\tExplains the chessboard notation and layout.");
        System.out.println();
        System.out.println("-h savefile");
        System.out.println("\tExplains the employed savefile system.");
        System.out.println();
        System.out.println("-h commands");
        System.out.println("\tLists all commands and applicable arguments."); //Say that arguments in argument-less commands are discarded.
        GoOn();
    } 

    public static void PiecesPage() {
        System.out.println("Do you really not know what each piece does?");
        GoOn();
    }

    public static void ChessboardPage() {
        System.out.println("An empty chessboard looks like this:");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        //System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 88 88 |       |       |       |       |       |       |       |       | 88 88");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 88 88 |       |       |       |       |       |       |       |       | 88 88");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 77 77 |       |       |       |       |       |       |       |       | 77 77");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 77 77 |       |       |       |       |       |       |       |       | 77 77");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 33 33 |       |       |       |       |       |       |       |       | 33 33");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 33 33 |       |       |       |       |       |       |       |       | 33 33");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 22 22 |       |       |       |       |       |       |       |       | 22 22");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 22 22 |       |       |       |       |       |       |       |       | 22 22");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 11 11 |       |       |       |       |       |       |       |       | 11 11");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" 11 11 |       |       |       |       |       |       |       |       | 11 11");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        //System.out.println("       |       |       |       |       |       |       |       |       |       ");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        GoOn();
        
        System.out.println("A starting chessboard will look something like this:");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 88 88 | BR BR | BN BN | BB BB | BQ BQ | BK BK | BB BB | BN BN | BR BR | 88 88");
        System.out.println(" 88 88 | BR BR | BN BN | BB BB | BQ BQ | BK BK | BB BB | BN BN | BR BR | 88 88");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 77 77 | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | 77 77 ");
        System.out.println(" 77 77 | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | 77 77 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66 ");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55 ");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44 ");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 33 33 |       |       |       |       |       |       |       |       | 33 33 ");
        System.out.println(" 33 33 |       |       |       |       |       |       |       |       | 33 33 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 22 22 | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | 22 22 ");
        System.out.println(" 22 22 | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | 22 22 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 11 11 | WR WR | WN WN | WB WB | WQ WQ | WK WK | WB WB | WN WN | WR WR | 11 11 ");
        System.out.println(" 11 11 | WR WR | WN WN | WB WB | WQ WQ | WK WK | WB WB | WN WN | WR WR | 11 11 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        System.out.println("The first letter represents the colour, and the second colour represents the rank.");
        System.out.println("For example \"BB\" is a black bishop.");
        GoOn();

        System.out.println("To make a move simply enter the initial position and the final postion like this:");
        System.out.println("a2 a3");
        System.out.println("Which will give the following result:");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println(" // // | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | \\\\ \\\\");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 88 88 | BR BR | BN BN | BB BB | BQ BQ | BK BK | BB BB | BN BN | BR BR | 88 88");
        System.out.println(" 88 88 | BR BR | BN BN | BB BB | BQ BQ | BK BK | BB BB | BN BN | BR BR | 88 88");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 77 77 | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | 77 77 ");
        System.out.println(" 77 77 | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | BP BP | 77 77 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66 ");
        System.out.println(" 66 66 |       |       |       |       |       |       |       |       | 66 66 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55 ");
        System.out.println(" 55 55 |       |       |       |       |       |       |       |       | 55 55 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44 ");
        System.out.println(" 44 44 |       |       |       |       |       |       |       |       | 44 44 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 33 33 | WP WP |       |       |       |       |       |       |       | 33 33 ");
        System.out.println(" 33 33 | WP WP |       |       |       |       |       |       |       | 33 33 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 22 22 |       | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | 22 22 ");
        System.out.println(" 22 22 |       | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | WP WP | 22 22 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" 11 11 | WR WR | WN WN | WB WB | WQ WQ | WK WK | WB WB | WN WN | WR WR | 11 11 ");
        System.out.println(" 11 11 | WR WR | WN WN | WB WB | WQ WQ | WK WK | WB WB | WN WN | WR WR | 11 11 ");
        System.out.println("-------+-------+-------+-------+-------+-------+-------+-------+-------+-------");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        System.out.println(" \\\\ \\\\ | AA AA | BB BB | CC CC | DD DD | EE EE | FF FF | GG GG | HH HH | // //");
        GoOn();
    }

    /*
    public static void SavefilePage() {
        Input.keyboardInput.next();
    } //*/ 

    public static void CommandsPage() {
        System.out.println("Commands are invoked by pressing '-', at the start of an input.");
        System.out.println("The TerminalChess program has the following commands to make your chess playing experience easier:");
        System.out.println();
        System.out.println("Certain commands have arguments that provide additional functionality.");
        System.out.println("Only one argument can be used at a time.");
        System.out.println();
        System.out.println("-p or -play");
        System.out.println("Starts a new round of chess.");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println("\tnew");
        System.out.println("\tStarts a new round even if a save is detected.");
        System.out.println();
        System.out.println("\tforce");
        System.out.println("\tForces a new round to start even if there's another round ongoing.");
        System.out.println();
        System.out.println("-h or -help");
        System.out.println("\tExplains the basics of the program and chess.");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println("\tmain");
        System.out.println("\tDisplays this page.");
        System.out.println();
        System.out.println("\tpieces");
        System.out.println("\tLists all pieces and explains their moves as well as the move notation system.");
        System.out.println();
        System.out.println("\tchessboard");
        System.out.println("\tExplains the chessboard notation and layout.");
        System.out.println();
        System.out.println("\tsavefile");
        System.out.println("\tExplains the employed savefile system.");
        System.out.println();
        System.out.println("\tcommands");
        System.out.println("\tLists all commands and applicable arguments.");
        System.out.println();
        System.out.println("-s or -save");
        System.out.println("Saves the current round of chess to a .json file.");
        System.out.println("Only works if there's a round ongoing.");
        System.out.println();
        System.out.println("-q or -quit");
        System.out.println("Quits the program.");
        System.out.println("If there's a round ongoing the user will be prompted to save or not.");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println("\tforce");
        System.out.println("\tForces the program to quit without saving.");      
        GoOn();
    }

}