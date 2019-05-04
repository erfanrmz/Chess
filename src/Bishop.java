public class Bishop extends Chessman {
    public Bishop(String name, char color, int x, int y) {
        super(name, color, x, y);
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        if (xF - getX() > 0 && yF - getY() > 0 && xF - getX() == yF - getY()) {
            for (int i = getX() + 1 , j = getY() +1 ; i < xF  && j < yF; i++ , j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                ground.findMan(ground.getCell(xF,yF)).setDeath(true);
                ground.findMan(ground.getCell(xF,yF)).setX(-1);
                ground.findMan(ground.getCell(xF,yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
        }
        else if (xF - getX() < 0 && yF - getY() > 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() -1 , j = getY() +1 ; i > xF && j < yF ; i-- , j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                ground.findMan(ground.getCell(xF,yF)).setDeath(true);
                ground.findMan(ground.getCell(xF,yF)).setX(-1);
                ground.findMan(ground.getCell(xF,yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
        }
        else if (xF - getX() < 0 && yF - getY() < 0 && xF - getX() == yF - getY()) {
            for (int i = getX() -1 , j = getY() - 1 ; i > xF && j > yF ; i-- , j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                ground.findMan(ground.getCell(xF,yF)).setDeath(true);
                ground.findMan(ground.getCell(xF,yF)).setX(-1);
                ground.findMan(ground.getCell(xF,yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
        }
        else if (xF - getX() > 0 && yF - getY() < 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() +1 , j = getY() - 1 ; i < xF && j > yF ; i++ , j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                ground.findMan(ground.getCell(xF,yF)).setDeath(true);
                ground.findMan(ground.getCell(xF,yF)).setX(-1);
                ground.findMan(ground.getCell(xF,yF)).setY(-1);
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(),getX(),getY());
                return true;
            }
        }
        return false;
    }
    public boolean checkMove (int xF , int yF , Ground ground)
    {
        if (xF - getX() > 0 && yF - getY() > 0 && xF - getX() == yF - getY()) {
            for (int i = getX() + 1 , j = getY() +1 ; i < xF  && j < yF; i++ , j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF - getX() < 0 && yF - getY() > 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() -1 , j = getY() +1 ; i > xF && j < yF ; i-- , j++)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF - getX() < 0 && yF - getY() < 0 && xF - getX() == yF - getY()) {
            for (int i = getX() -1 , j = getY() - 1 ; i > xF && j > yF ; i-- , j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF - getX() > 0 && yF - getY() < 0 && xF - getX() == (yF - getY())*-1) {
            for (int i = getX() +1 , j = getY() - 1 ; i < xF && j > yF ; i++ , j--)
                if (!ground.checkEmpty(i, j))
                    return false;
            if (ground.checkEmpty(xF, yF)) {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF,yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        return false;
    }
}
