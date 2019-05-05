import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Ground chess = new Ground();
        int moveNumber = 0;
        Scanner sc = new Scanner(System.in);
        int xF = 0;
        int yF = 0;
        Ground testMove = null;
        String manName;
        String move;
        while (((King) chess.getMan(30)).isMate() == false && ((King) chess.getMan(14)).isMate() == false) {
            chess.printground();
            char turn = 'W';
            if (moveNumber % 2 == 0)
                turn = 'W';
            else turn = 'B';

            int kingNum = turn == 'W'?14:30;

            if (chess.check(turn , chess)) {
                System.out.println(turn == 'W'?"White":"Black" + " Check");
                    ((King)chess.getMan(kingNum)).setCheck(true);
            }
            else
                ((King)chess.getMan(kingNum)).setCheck(false);
            manName = sc.next();
            move = sc.next();
            yF = (int) move.charAt(0) - 65;
            xF = ((int) move.charAt(1)) - 49;
            Chessman man = chess.findMan(manName);
            if (man.getColor() == turn) {

                if (man.isDeath())
                    System.out.println("You cant move dead mans \n Choose another man:");

                else if (!man.isDeath() && !(((King)chess.getMan(kingNum)).isCheck())){
                    if (man.move(xF, yF, chess))
                        moveNumber++;
                    else
                        System.out.println("Wrong move , Try again!");
                }
                else if (!man.isDeath() && (((King)chess.getMan(kingNum)).isCheck()))
                {
                    int lastx = man.getX();
                    int lasty = man.getY();
                    if (chess.checkEmpty(xF,yF))
                    {
                        if (man.move(xF,yF,chess))
                        {
                            if (chess.check(turn,chess))
                            {
                                man.setX(lastx);
                                man.setY(lasty);
                                chess.setCell("   ",xF,yF);
                                chess.setCell(man.getName(),man.getX(),man.getY());
                                System.out.println("Wrong move , Try again!");
                            }
                            else
                                moveNumber++;
                        }
                        else
                            System.out.println("Wrong move , Try again");
                    }
                    else if (chess.getCell(xF,yF).charAt(0) != turn)
                    {
                        Chessman deadman = chess.findMan(chess.getCell(xF,yF));
                        if (man.move(xF,yF,chess))
                        {
                            if (chess.check(turn,chess))
                            {
                                man.setX(lastx);
                                man.setY(lasty);
                                chess.setCell("   ",xF,yF);
                                chess.setCell(man.getName(),man.getX(),man.getY());
                                deadman.setDeath(false);
                                deadman.setX(xF);
                                deadman.setY(yF);
                                chess.setCell(deadman.getName(),deadman.getX(),deadman.getY());
                                System.out.println("Wrong move , Try again!");
                            }
                            else
                                moveNumber++;
                        }
                        else
                            System.out.println("Wrong move , Try again");
                    }
                }

            } else
                System.out.println("Its not " + (man.getColor() == 'B' ? "Black" : "White") + " turn");
        }
    }
}



