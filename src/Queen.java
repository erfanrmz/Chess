/**
 * This is queen peace class
 * @author erfan ramezani
 * @version 1.0
 * @since 4-29-2019
 */
public class Queen extends Chessman {
    public Queen(String name, char color, int x, int y) {
        super(name, color, x, y);
        if (color == 'W')
            setIcon("images\\W_Queen.png");
        else
            setIcon("images\\B_Queen.png");
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        if (xF - getX() > 0 && yF - getY() == 0) {
            for (int i = getX() + 1; i < xF; i++)
                if (!ground.checkEmpty(i, getY()))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() == 0) {
            for (int i = getX() - 1; i > xF; i--)
                if (!ground.checkEmpty(i, getY()))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (yF - getY() < 0 && xF - getX() == 0) {
            for (int i = getY() - 1; i > yF; i--)
                if (!ground.checkEmpty(getX(), i))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (yF - getY() > 0 && xF - getX() == 0) {
            for (int i = getY() + 1; i < yF; i++)
                if (!ground.checkEmpty(getX(), i))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() > 0 && yF - getY() > 0 && xF - getX() == yF - getY()) {
            for (int i = getX() + 1, j = getY() + 1; i < xF && j < yF; i++, j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() > 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() - 1, j = getY() + 1; i > xF && j < yF; i--, j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() < 0 && xF - getX() == yF - getY()) {
            for (int i = getX() - 1, j = getY() - 1; i > xF && j > yF; i--, j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() > 0 && yF - getY() < 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() + 1, j = getY() - 1; i < xF && j > yF; i++, j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        return false;

    }
    public boolean checkMove (int xF , int yF , Ground ground)
    {
        if (xF - getX() > 0 && yF - getY() == 0) {
            for (int i = getX() + 1; i < xF; i++)
                if (!ground.checkEmpty(i, getY()))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() == 0) {
            for (int i = getX() - 1; i > xF; i--)
                if (!ground.checkEmpty(i, getY()))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (yF - getY() < 0 && xF - getX() == 0) {
            for (int i = getY() - 1; i > yF; i--)
                if (!ground.checkEmpty(getX(), i))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (yF - getY() > 0 && xF - getX() == 0) {
            for (int i = getY() + 1; i < yF; i++)
                if (!ground.checkEmpty(getX(), i))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (xF - getX() > 0 && yF - getY() > 0 && xF - getX() == yF - getY()) {
            for (int i = getX() + 1, j = getY() + 1; i < xF && j < yF; i++, j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() > 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() - 1, j = getY() + 1; i > xF && j < yF; i--, j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (xF - getX() < 0 && yF - getY() < 0 && xF - getX() == yF - getY()) {
            for (int i = getX() - 1, j = getY() - 1; i > xF && j > yF; i--, j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        } else if (xF - getX() > 0 && yF - getY() < 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() + 1, j = getY() - 1; i < xF && j > yF; i++, j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            } else if (!ground.checkEmpty(xF, yF) && ground.getCell(xF, yF).charAt(0) != getColor()) {
                return true;
            }
        }
        return false;

    }

}
