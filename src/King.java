/**
 * This is king peace class
 * @author erfan ramezani
 * @version 1.0
 * @since 4-29-2019
 */
public class King extends Chessman {
    private boolean check;
    private boolean mate;

    public King(String name, char color, int x, int y) {
        super(name, color, x, y);
        if (color == 'W')
            setIcon("images\\W_King.png");
        else
            setIcon("images\\B_King.png");
        check = false;
        mate = false;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public void setMate(boolean mate) {
        this.mate = mate;
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(xF, yF)).setDeath(true);
                if(getColor() == 'W')
                    ground.getKnockDownB().add(ground.findMan(ground.getCell(xF,yF)));
                else if (getColor() == 'B')
                    ground.getKnockDownW().add(ground.findMan(ground.getCell(xF,yF)));
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
    public boolean checkMove (int xF , int yF , Ground ground)
    {
        if (xF -getX() == 1 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == 0)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == 1 && yF - getY() == 1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == -1 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == 1 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        else if (xF -getX() == 0 && yF - getY() == -1)
        {
            if (ground.checkEmpty(xF,yF))
            {
                return true;
            }
            else if (!ground.checkEmpty(xF,yF) && ground.getCell(xF, yF).charAt(0) != getColor())
            {
                return true;
            }
        }
        return false;
    }
}
