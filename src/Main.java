import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        //Graphic elements
        GridLayout chesscells = new GridLayout(8, 8);
        JFrame mainFrame = new JFrame("Chess");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1000, 800);
        mainFrame.setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.orange);
        //boardPanel.setBackground(Color.gray);
        JPanel knockDownBlack = new JPanel();
        JPanel knockDownWhite = new JPanel();
        JPanel turnPanel = new JPanel();
        Chessman[][] mans = new Chessman[8][8];
        Ground chess = new Ground(mans);
        JButton[][] mansB = new JButton[8][8];

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage("images\\icon.png");
        mainFrame.setIconImage(img);


        //Chess mans
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
                mansB[i][j] = new JButton();
        for (int i = 2 ; i <= 5 ; i++)
            for (int j = 0 ; j <= 7 ; j++)
                mans[i][j] = new Empty("   ",'N',i,j);
        for (int i = 0; i < 8; i++) {
            String name = "WP" + i;
            mans[1][i] = new Pawn(name, 'W', 1, i);
            mansB[1][i].setIcon(new ImageIcon("images\\W_Pawn.png"));
        }
        mans[0][0] = new Rook("WR1", 'W', 0, 0);
        mansB[0][0].setIcon(new ImageIcon("images\\W_Rook.png"));
        mans[0][7] = new Rook("WR2", 'W', 0, 7);
        mansB[0][7].setIcon(new ImageIcon("images\\W_Rook.png"));
        mans[0][1] = new Knight("WN1", 'W', 0, 1);
        mansB[0][1].setIcon(new ImageIcon("images\\W_Knight.png"));
        mans[0][6] = new Knight("WN2", 'W', 0, 6);
        mansB[0][6].setIcon(new ImageIcon("images\\W_Knight.png"));
        mans[0][2] = new Bishop("WB1", 'W', 0, 2);
        mansB[0][2].setIcon(new ImageIcon("images\\W_Bishop.png"));
        mans[0][5] = new Bishop("WB2", 'W', 0, 5);
        mansB[0][5].setIcon(new ImageIcon("images\\W_Bishop.png"));
        mans[0][3] = new King("WK1", 'W', 0, 3);
        mansB[0][3].setIcon(new ImageIcon("images\\W_King.png"));
        mans[0][4] = new Queen("WQ1", 'W', 0, 4);
        mansB[0][4].setIcon(new ImageIcon("images\\W_Queen.png"));
        for (int i = 0; i < 8; i++) {
            String name = "BP" + i;
            mans[6][i] = new Pawn(name, 'B', 6, i);
            mansB[6][i].setIcon(new ImageIcon("images\\B_Pawn.png"));
        }
        mans[7][0] = new Rook("BR1", 'B', 7, 0);
        mansB[7][0].setIcon(new ImageIcon("images\\B_Rook.png"));
        mans[7][7] = new Rook("BR2", 'B', 7, 7);
        mansB[7][7].setIcon(new ImageIcon("images\\B_Rook.png"));
        mans[7][1] = new Knight("BN1", 'B', 7, 1);
        mansB[7][1].setIcon(new ImageIcon("images\\B_Knight.png"));
        mans[7][6] = new Knight("BN2", 'B', 7, 6);
        mansB[7][6].setIcon(new ImageIcon("images\\B_Knight.png"));
        mans[7][2] = new Bishop("BB1", 'B', 7, 2);
        mansB[7][2].setIcon(new ImageIcon("images\\B_Bishop.png"));
        mans[7][5] = new Bishop("BB2", 'B', 7, 5);
        mansB[7][5].setIcon(new ImageIcon("images\\B_Bishop.png"));
        mans[7][3] = new King("BK1", 'B', 7, 3);
        mansB[7][3].setIcon(new ImageIcon("images\\B_King.png"));
        mans[7][4] = new Queen("BQ1", 'B', 7, 4);
        mansB[7][4].setIcon(new ImageIcon("images\\B_Queen.png"));
        boardPanel.setLayout(chesscells);
        mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        sidePanel.setPreferredSize(new Dimension(200,800));
        mainFrame.getContentPane().add(sidePanel, BorderLayout.WEST);
        sidePanel.add(turnPanel);

        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
            {
                boardPanel.add(mansB[i][j]);
                mansB[i][j].setPreferredSize(new Dimension(100,100));
                if (j % 2 == 0 && i % 2 == 0)
                    mansB[i][j].setBackground(new Color(219, 188, 170));
                else if (j % 2 == 1 && i % 2 == 1)
                    mansB[i][j].setBackground(new Color(219, 188, 170));
                else
                    mansB[i][j].setBackground(new Color(122, 79, 52));
                mansB[i][j].addActionListener(new ButtonListener(mansB,chess,turnPanel));

            }
        JButton g = new JButton();

        mainFrame.setVisible(true);
//        mainFrame.getContentPane().repaint();
        //

        for (int i = 0; i < 8; i++)
            for (int j = 0 ; j < 8 ; j++)
            chess.setCell(mans[i][j].getName(), mans[i][j].getX(), mans[i][j].getY());
        int moveNumber = 0;
        Scanner sc = new Scanner(System.in);
        int xI = 0;
        int yI = 0;
        int xF = 0;
        int yF = 0;
        String manName;
        String move;

        while (!((King) chess.findMan("WK1")).isMate() && !((King) chess.findMan("BK1")).isMate()) {

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

            String kingName = turn == 'W'?"WK1":"BK1";

            if (chess.check(turn , chess)) {
                System.out.println(turn == 'W'?"White Check":"Black Check");
                    ((King)chess.findMan(kingName)).setCheck(true);
                    mansB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(186, 112, 200));
            }
            else
            {

                ((King)chess.findMan(kingName)).setCheck(false);
                if (chess.findMan(kingName).getY() % 2 == 0 && chess.findMan(kingName).getX() % 2 == 0)
                    mansB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                else if (chess.findMan(kingName).getY()  % 2 == 1 && chess.findMan(kingName).getX()  % 2 == 1)
                    mansB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                else
                    mansB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(122, 79, 52));

            }

            manName = sc.next();
            yI = (int) manName.charAt(0) - 65;
            xI = ((int) manName.charAt(1)) - 49;
            move = sc.next();
            yF = (int) move.charAt(0) - 65;
            xF = ((int) move.charAt(1)) - 49;

            Chessman man = chess.getMan(xI,yI);
            if (man.getColor() == turn) {

                if (man.isDeath())
                    System.out.println("You cant move dead mans \n Choose another man:");

                else if (!man.isDeath() && !(((King)chess.findMan(kingName)).isCheck())){
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
                            {
                                chess.swapMans(xI,yI,xF,yF);
                                mansB[xI][yI].setIcon(null);
                                mansB[xF][yF].setIcon(chess.getMan(xF,yF).getIcon());
                                moveNumber++;
                            }
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
                            {
                                chess.swapMans(xI,yI,xF,yF);
                                mansB[xI][yI].setIcon(null);
                                mansB[xF][yF].setIcon(chess.getMan(xF,yF).getIcon());
                                moveNumber++;
                            }
                        }
                        else
                            System.out.println("Wrong move , Try again");
                    }
                }
                else if (!man.isDeath() && (((King)chess.findMan(kingName)).isCheck()))
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
                            else {
                                chess.swapMans(xI, yI, xF, yF);
                                mansB[xI][yI].setIcon(null);
                                mansB[xF][yF].setIcon(chess.getMan(xF,yF).getIcon());
                                moveNumber++;
                            }
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
                            else {

                                chess.swapMans(xI, yI, xF, yF);
                                mansB[xI][yI].setIcon(null);
                                mansB[xF][yF].setIcon(chess.getMan(xF,yF).getIcon());
                                moveNumber++;
                            }
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



