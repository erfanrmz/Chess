public class Knight extends Chessman {
    public Knight(String name, char color, int x, int y) {
        super(name, color, x, y);
    }

    @Override
    public boolean move(int xF, int yF,Ground ground) {
        return false;
    }


}
