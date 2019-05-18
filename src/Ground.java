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
    private Chessman[] mans;

    public Ground(Chessman[] mans) {
        this.mans = mans;
        cell = new String[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                cell[i][j] = "   ";
    }

    public Chessman getMan(int i) {
        return mans[i];
    }

    public Chessman[] getMans() {
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
        for (int i = 0; i < 32; i++) {
            if (name.equals(mans[i].getName()))
                return mans[i];
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
        Chessman[] mans = ground.getMans();
        for (int i = 0; i < 32 && !mans[i].isDeath(); i++) {
            if (mans[i].checkMove(x, y, ground))
                Threats.add(mans[i]);
        }
        return Threats;
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
        for (int i = 0; i < 32 && !mans[i].isDeath(); i++) {
            if (mans[i].checkMove(x, y, ground) && mans[i].getColor() != color)
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
        if (color == 'W' && haveThreat(mans[14].getX(), mans[14].getY(), ground, mans[14].getColor())) {
            return true;
        } else if (color == 'B' && haveThreat(mans[30].getX(), mans[30].getY(), ground, mans[30].getColor())) {
            return true;
        }
        return false;
    }


}
