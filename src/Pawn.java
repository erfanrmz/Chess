public class Pawn extends Chessman {
    private boolean firstMove;
    public Pawn(String name, char color, int x, int y) {
        super(name, color, x, y);
        firstMove = false;
    }

    @Override
    public void move(int xF, int yF) {

    }
}
