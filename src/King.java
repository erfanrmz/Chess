public class King extends Chessman {
    private boolean check;
    private boolean mate;

    public King(String name, char color, int x, int y) {
        super(name, color, x, y);
        check = false;
        mate = false;
    }

    public boolean isMate() {
        return mate;
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        return false;

    }
}
