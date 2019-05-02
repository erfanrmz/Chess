public abstract class Chessman {
    private String name;
    private char color;
    private int x;
    private int y;
    private boolean death;
    public Chessman(String name , char color , int x , int y)
    {
        death = false;
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    abstract public void move (int xF, int yF);
}
