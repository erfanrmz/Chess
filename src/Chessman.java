public abstract class Chessman {
    private String name;
    private char color;
    private int x;
    private int y;
    public Chessman(String name , char color , int x , int y , Ground ground)
    {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
        ground.setCell(name,x,y);
    }
    abstract public void move (int xF,int yF);
}
