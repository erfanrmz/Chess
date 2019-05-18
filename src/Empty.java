public class Empty extends Chessman {

    public Empty(String name, char color, int x, int y) {
        super(name, color, x, y);
    }

    @Override
    boolean move(int xF, int yF, Ground ground) {
        System.out.println("cant move Empty Room");
        return false;
    }

    @Override
    boolean checkMove(int xF, int yF, Ground ground) {
        return false;
    }
}
