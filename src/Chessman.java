import javax.swing.*;

/**
 * This is an abstract peace for every chessmen
 *
 * @author erfan ramezani
 * @version 1.0
 * @since 4-29-2019
 */

public abstract class Chessman {
    private String name;
    private char color;
    private int x;
    private int y;
    private boolean death;
    private Icon icon;

    public Chessman(String name, char color, int x, int y) {
        super();
        death = false;
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(String link) {
        icon = new ImageIcon(link);
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

    /**
     * @param xF     final x
     * @param yF     final y
     * @param ground move on which ground
     * @return true if move is right and move it to xF and yF otherwise false
     */
    abstract boolean move(int xF, int yF, Ground ground);

    /**
     * @param xF     final x
     * @param yF     final y
     * @param ground move on which ground
     * @return true if move is right otherwise false
     */
    abstract boolean checkMove(int xF, int yF, Ground ground);
}
