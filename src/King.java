public class King extends Chessman {
    private boolean check;
    private boolean mate;

    public King(String name, char color, int x, int y) {
        super(name, color, x, y);
        check = false;
        mate = false;
    }

    public boolean isMate() {
        return mate;
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        if (xF -getX() == 1 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == 1 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == 1 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                ground.setCell("   ", getX(), getY());
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                ground.findMan(ground.getCell(xF, yF)).setX(-1);
                ground.findMan(ground.getCell(xF, yF)).setY(-1);
                setX(xF);
                setY(yF);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }
        return false;
    }
}
