public class Knight extends Chessman {
    public Knight(String name, char color, int x, int y) {
        super(name, color, x, y);
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        if (xF - getX() == -2 && yF - getY() == -1) {
            if (ground.checkEmpty(getX() - 2, getY() - 1) == false && ground.getCell(getX() - 2, getY() - 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 2, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 2, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 2, getY() - 1)).setY(-1);
                setX(getX() - 2);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() - 2, getY() - 1)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 2);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == +2 && yF - getY() == +1) {
            if (ground.checkEmpty(getX() + 2, getY() + 1) == false && ground.getCell(getX() + 2, getY() + 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 2, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 2, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 2, getY() + 1)).setY(-1);
                setX(getX() + 2);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() + 2, getY() + 1)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 2);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            }

        } else if (xF - getX() == +2 && yF - getY() == -1) {
            if (ground.checkEmpty(getX() + 2, getY() - 1) == false && ground.getCell(getX() + 2, getY() - 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 2, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 2, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 2, getY() - 1)).setY(-1);
                setX(getX() + 2);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() + 2, getY() - 1)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 2);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == -2 && yF - getY() == +1) {
            if (ground.checkEmpty(getX() - 2, getY() + 1) == false && ground.getCell(getX() - 2, getY() + 1).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 2, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 2, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 2, getY() + 1)).setY(-1);
                setX(getX() - 2);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() - 2, getY() + 1)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 2);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == -1 && yF - getY() == -2) {
            if (ground.checkEmpty(getX() - 1, getY() - 2) == false && ground.getCell(getX() - 1, getY() - 2).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() - 2)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() - 2)).setX(-1);
                ground.findMan(ground.getCell(getX() - 2, getY() - 2)).setY(-1);
                setX(getX() - 1);
                setY(getY() - 2);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() - 1, getY() - 2)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 1);
                setY(getY() - 2);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == +1 && yF - getY() == +2) {
            if (ground.checkEmpty(getX() + 1, getY() + 2) == false && ground.getCell(getX() + 1, getY() + 2).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() + 2)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() + 2)).setX(-1);
                ground.findMan(ground.getCell(getX() + 2, getY() + 2)).setY(-1);
                setX(getX() + 1);
                setY(getY() + 2);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() + 1, getY() + 2)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 1);
                setY(getY() + 2);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == +1 && yF - getY() == -2) {
            if (ground.checkEmpty(getX() + 1, getY() - 2) == false && ground.getCell(getX() + 1, getY() - 2).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() - 2)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() - 2)).setX(-1);
                ground.findMan(ground.getCell(getX() + 2, getY() - 2)).setY(-1);
                setX(getX() + 1);
                setY(getY() - 2);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() + 1, getY() - 2)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() + 1);
                setY(getY() - 2);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        } else if (xF - getX() == -1 && yF - getY() == +2) {
            if (ground.checkEmpty(getX() - 1, getY() + 2) == false && ground.getCell(getX() - 1, getY() + 2).charAt(0) != getColor()) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() + 2)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() + 2)).setX(-1);
                ground.findMan(ground.getCell(getX() - 2, getY() + 2)).setY(-1);
                setX(getX() - 1);
                setY(getY() + 2);
                ground.setCell(getName(), getX(), getY());
                return true;

            } else if (ground.checkEmpty(getX() - 1, getY() + 2)) {
                ground.setCell("   ", getX(), getY());
                setX(getX() - 1);
                setY(getY() + 2);
                ground.setCell(getName(), getX(), getY());
                return true;
            }
        }


        System.out.println("Wrong move , Try again");
        return false;
    }


}
