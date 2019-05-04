public abstract class Chessman {
    private String name;
    private char color;
    private int x;
    private int y;
    private boolean death;

    public Chessman(String name, char color, int x, int y) {
        death = false;
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public char getColor() {
        return color;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void setDeath(boolean death) {
        this.death = death;
    }

    public boolean isDeath() {
        return death;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    abstract boolean move(int xF, int yF, Ground ground);
    abstract boolean checkMove(int xF, int yF, Ground ground);
}
