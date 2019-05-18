import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        //Graphic elements
        JFrame mainFrame = new JFrame("Chess");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1000, 800);
        mainFrame.setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JPanel knockDownBlack = new JPanel();
        JPanel knockDownWhite = new JPanel();
        JPanel turnPanel = new JPanel();
        mainFrame.add(turnPanel);
        mainFrame.setVisible(true);






        //Chess mans
        Chessman[] mans = new Chessman[32];
        for (int i = 0; i < 8; i++) {
            String name = "WP" + i;
            mans[i] = new Pawn(name, 'W', 1, i);
        }
        mans[8] = new Rook("WR1", 'W', 0, 0);

        mans[9] = new Rook("WR2", 'W', 0, 7);
        mans[10] = new Knight("WN1", 'W', 0, 1);
        mans[11] = new Knight("WN2", 'W', 0, 6);
        mans[12] = new Bishop("WB1", 'W', 0, 2);
        mans[13] = new Bishop("WB2", 'W', 0, 5);
        mans[14] = new King("WK1", 'W', 0, 3);
        mans[15] = new Queen("WQ1", 'W', 0, 4);
        for (int i = 0; i < 8; i++) {
            String name = "BP" + i;
            mans[i + 16] = new Pawn(name, 'B', 6, i);
        }
        mans[24] = new Rook("BR1", 'B', 7, 0);
        mans[25] = new Rook("BR2", 'B', 7, 7);
        mans[26] = new Knight("BN1", 'B', 7, 1);
        mans[27] = new Knight("BN2", 'B', 7, 6);
        mans[28] = new Bishop("BB1", 'B', 7, 2);
        mans[29] = new Bishop("BB2", 'B', 7, 5);
        mans[30] = new King("BK1", 'B', 7, 3);
        mans[31] = new Queen("BQ1", 'B', 7, 4);
        //
        Ground chess = new Ground(mans);
        for (int i = 0; i < 32; i++)
            chess.setCell(mans[i].getName(), mans[i].getX(), mans[i].getY());
        int moveNumber = 0;
        Scanner sc = new Scanner(System.in);
        int xF = 0;
        int yF = 0;
        Ground testMove = null;
        String manName;
        String move;
        while (!((King) chess.getMan(30)).isMate() && !((King) chess.getMan(14)).isMate()) {
            chess.printground();
            char turn = 'W';
            if (moveNumber % 2 == 0)
            {
                turn = 'W';
                turnPanel.setBackground(Color.white);
            }
            else
            {
                turn = 'B';
                turnPanel.setBackground(Color.BLACK);
            }

            int kingNum = turn == 'W'?14:30;

            if (chess.check(turn , chess)) {
                System.out.println(turn == 'W'?"White Check":"Black Check");
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



