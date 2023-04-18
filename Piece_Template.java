public abstract class Piece_Template {
    private boolean isWhite;
    //Position of chess piece
    private int x, y;
    private boolean hasMoved;
    //What will be printed to standard output
    private String printable;
    
    public Piece_Template(boolean isWhite, int x, int y, boolean hasMoved) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
        this.hasMoved = hasMoved;
    }

    public Piece_Template(boolean isWhite, int x, int y, boolean hasMoved, String printable) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
        this.hasMoved = hasMoved;
        this.printable = printable;
    }
    
    //Getters and Setters
    public boolean isWhite() {return isWhite;}
    
    public int getX() {return x;}
    
    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    
    public void setY(int y) {this.y = y;}

    public boolean getHasMoved() {return hasMoved;}

    public void setHasMoved(boolean hasMoved) {this.hasMoved = hasMoved;}

    public String getPrintable() {return printable;}
    
    public abstract boolean isValidMove(int newX, int newY, Piece_Template[][] board);
}