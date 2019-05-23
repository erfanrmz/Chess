
import javax.swing.*;
import java.awt.*;


/**
 * This is pawn peace class
 * @author erfan ramezani
 * @version 1.0
 * @since 4-29-2019
 */
public class Pawn extends Chessman {
    private boolean firstMove;

    public Pawn(String name, char color, int x, int y) {
        super(name, color, x, y);
        firstMove = false;
        if (color == 'W')
            setIcon("images\\W_Pawn.png");
        else
            setIcon("images\\B_Pawn.png");
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        Chessman[][] mans = ground.getMans();
        if (getColor() == 'W') {
            if (xF - getX() == 2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() + 2, getY()) && ground.checkEmpty(getX()+1,getY())) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 2);
                ground.setCell(getName(), getX(), getY());
                firstMove = true;
                return true;
            } else if (xF - getX() == 1 && yF - getY() == 0 && ground.checkEmpty(getX() + 1, getY())) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 1);
                ground.setCell(getName(), getX(), getY());
                firstMove = true;
                return true;
            } else if (xF - getX() == 1 && yF - getY() == 1 && ground.checkEmpty(getX() + 1, getY() + 1) == false && ground.getCell(getX() + 1, getY() + 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setY(-1);
                setX(getX() + 1);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (xF - getX() == 1 && yF - getY() == -1 && ground.checkEmpty(getX() + 1, getY() - 1) == false && ground.getCell(getX() + 1, getY() - 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setY(-1);
                setX(getX() + 1);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else {
                return false;
            }
        }
        if (getColor() == 'B') {
            if (xF - getX() == -2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() - 2, getY()) && ground.checkEmpty(getX()-1,getY())) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 2);
                ground.setCell(getName(), getX(), getY());
                firstMove = true;
                return true;
            } else if (xF - getX() == -1 && yF - getY() == 0 && ground.checkEmpty(getX() - 1, getY())) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 1);
                ground.setCell(getName(), getX(), getY());
                firstMove = true;
                return true;
            } else if (xF - getX() == -1 && yF - getY() == 1 && ground.checkEmpty(getX() - 1, getY() + 1) == false && ground.getCell(getX() - 1, getY() + 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setY(-1);
                setX(getX() - 1);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (xF - getX() == -1 && yF - getY() == -1 && ground.checkEmpty(getX() - 1, getY() - 1) == false && ground.getCell(getX() - 1, getY() - 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setY(-1);
                setX(getX() - 1);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean checkMove (int xF , int yF , Ground ground)
    {
        if (getColor() == 'W') {
            if (xF - getX() == 2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() + 2, getY()) && ground.checkEmpty(getX()+1,getY())) {
                return true;
            } else if (xF - getX() == 1 && yF - getY() == 0 && ground.checkEmpty(getX() + 1, getY())) {
                return true;
            } else if (xF - getX() == 1 && yF - getY() == 1 && ground.checkEmpty(getX() + 1, getY() + 1) == false && ground.getCell(getX() + 1, getY() + 1).charAt(0) != getColor()) {
                return true;
            } else if (xF - getX() == 1 && yF - getY() == -1 && ground.checkEmpty(getX() + 1, getY() - 1) == false && ground.getCell(getX() + 1, getY() - 1).charAt(0) != getColor()) {
                return true;
            } else {
                return false;
            }
        }
        if (getColor() == 'B') {
            if (xF - getX() == -2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() - 2, getY()) && ground.checkEmpty(getX()-1,getY())) {
                return true;
            } else if (xF - getX() == -1 && yF - getY() == 0 && ground.checkEmpty(getX() - 1, getY())) {
                return true;
            } else if (xF - getX() == -1 && yF - getY() == 1 && ground.checkEmpty(getX() - 1, getY() + 1) == false && ground.getCell(getX() - 1, getY() + 1).charAt(0) != getColor()) {
                return true;
            } else if (xF - getX() == -1 && yF - getY() == -1 && ground.checkEmpty(getX() - 1, getY() - 1) == false && ground.getCell(getX() - 1, getY() - 1).charAt(0) != getColor()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
