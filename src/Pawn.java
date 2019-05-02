public class Pawn extends Chessman {
    private boolean firstMove;

    public Pawn(String name, char color, int x, int y) {
        super(name, color, x, y);
        firstMove = false;
    }

    @Override
    public boolean move(int xF, int yF, Ground ground) {
        if (getColor() == 'W') {
            if (xF - getX() == 2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() + 2, getY())) {
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
            } else if (xF - getX() == 1 && yF - getY() == 1 && ground.checkEmpty(getX() + 1, getY() + 1) == false) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 1, getY() + 1)).setY(-1);
                setX(getX() + 1);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (xF - getX() == 1 && yF - getY() == -1 && ground.checkEmpty(getX() + 1, getY() - 1) == false) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() + 1, getY() - 1)).setY(-1);
                setX(getX() + 1);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else {
                System.out.println("Wrong move , Try again");
                return false;
            }
        }
        if (getColor() == 'B') {
            if (xF - getX() == -2 && yF - getY() == 0 && firstMove == false && ground.checkEmpty(getX() - 2, getY())) {
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
            } else if (xF - getX() == -1 && yF - getY() == 1 && ground.checkEmpty(getX() - 1, getY() + 1) == false) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 1, getY() + 1)).setY(-1);
                setX(getX() - 1);
                setY(getY() + 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else if (xF - getX() == -1 && yF - getY() == -1 && ground.checkEmpty(getX() - 1, getY() - 1) == false) {
                ground.setCell("   ", getX(), getY());
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setDeath(true);
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setX(-1);
                ground.findMan(ground.getCell(getX() - 1, getY() - 1)).setY(-1);
                setX(getX() - 1);
                setY(getY() - 1);
                ground.setCell(getName(), getX(), getY());
                return true;
            } else {
                System.out.println("Wrong move , Try again");
                return false;
            }
        }
        return false;
    }
}
