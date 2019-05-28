import java.util.ArrayList;

/**
 * board of game
 *
 * @author erfan ramezani
 * @version 1.0
 * @since 4-29-2019
 */
public class Ground  {
    private String[][] cell;
    private Chessman[][] mans;
    private ArrayList<Chessman> knockDownB;
    private ArrayList<Chessman> knockDownW;

    public Ground(Chessman[][] mans) {
        this.mans = mans;
        cell = new String[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                cell[i][j] = "   ";
            knockDownB = new ArrayList<Chessman>();
            knockDownW = new ArrayList<Chessman>();
    }

    public ArrayList<Chessman> getKnockDownB() {
        return knockDownB;
    }

    public ArrayList<Chessman> getKnockDownW() {
        return knockDownW;
    }

    public Chessman getMan(int i, int j) {
        return mans[i][j];
    }

    public Chessman[][] getMans() {
        return mans;
    }

    public String getCell(int i, int j) {
        return cell[i][j];
    }

    public void setCell(String cell, int i, int j) {
        this.cell[i][j] = cell;
    }

    /**
     * find the Chessman with name.
     *
     * @param name name of a chessman
     * @return Chessman that have the name
     */
    public Chessman findMan(String name) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ; j < 8 ; j++)
            {
            if (name.equals(mans[i][j].getName()))
                return mans[i][j];
            }
        }
        return null;
    }

    /**
     * checks that the cell is empty or not.
     *
     * @param i x of the cell
     * @param j y of the cell
     * @return true if the cell is empty otherwise false
     */
    public boolean checkEmpty(int i, int j) {
        if (cell[i][j].equals("   "))
            return true;
        return false;
    }

    /**
     * prints the ground
     */

    public void printground() {
        System.out.println("    A   B   C   D   E   F   G   H");
        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++)
                System.out.print("|" + cell[i][j]);
            System.out.println("| " + (i + 1));
        }
        System.out.println("    A   B   C   D   E   F   G   H");
    }

    /**
     * find chessmen that threat the cell
     *
     * @param x      x of the cell
     * @param y      y of the cell
     * @param ground the ground that this cell is in that
     * @return an arraylist of chessmen that threats the cell
     */
    public ArrayList<Chessman> findThreatingMans(int x, int y, Ground ground) {
        ArrayList<Chessman> Threats = new ArrayList<>();
        Chessman[][] mans = ground.getMans();
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ; j < 8 && !mans[i][j].isDeath();j++)
            if (mans[i][j].checkMove(x, y, ground))
                Threats.add(mans[i][j]);
        }
        return Threats;
    }
    public ArrayList<Chessman> canGoThere(Chessman chessman, Ground ground) {
        ArrayList<Chessman> canGoThere = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ; j < 8;j++)
                if (chessman.checkMove(i, j, ground))
                    canGoThere.add(getMan(i,j));
        }
        return canGoThere;
    }

    /**
     * search that the cell have threat or not
     *
     * @param x      x of the cell
     * @param y      y of the cell
     * @param ground the ground that this cell is in that
     * @return true if the cell have threat otherwise false
     */

    public Boolean haveThreat(int x, int y, Ground ground, char color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0 ; j < 8 && !mans[i][j].isDeath() ; j++)
            if (mans[i][j].checkMove(x, y, ground) && mans[i][j].getColor() != color)
                return true;

        }
        return false;


    }

    /**
     * checks if the king is checked
     *
     * @param color  color of the king might be checked
     * @param ground the ground that play in it
     * @return true if the king is checked otherwise false
     */
    public Boolean check(char color, Ground ground) {
        if (color == 'W' && haveThreat(findMan("WK1").getX(), findMan("WK1").getY(), ground, findMan("WK1").getColor())) {
            return true;
        } else if (color == 'B' && haveThreat(findMan("BK1").getX(), findMan("BK1").getY(), ground, findMan("BK1").getColor())) {
            return true;
        }
        return false;
    }
    public void swapMans(int xI , int yI , int xF , int yF)
    {
        Chessman swap = getMan(xI,yI);
        mans[xI][yI] = mans[xF][yF];
        mans[xF][yF] = swap;
    }


}
