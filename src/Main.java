import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        //Graphic elements
        GridLayout chesscells = new GridLayout(8, 8);
        JFrame mainFrame = new JFrame("Chess");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(0, 0, 1600, 800);
        mainFrame.setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JLabel jlabel = new JLabel("White Turn");
        jlabel.setFont(new Font("Verdana",3,100));
        jlabel.setForeground(new Color(79, 107, 122));
        sidePanel.setBackground(Color.orange);
        //boardPanel.setBackground(Color.gray);
        JPanel knockDownBlack = new JPanel();
        JPanel knockDownWhite = new JPanel();
        JPanel turnPanel = new JPanel();
        turnPanel.setBackground(Color.white);
        Chessman[][] mans = new Chessman[8][8];
        Ground chess = new Ground(mans);
        JButton[][] mansB = new JButton[8][8];
        JButton[] knockDownWB = new JButton[16];
        JButton[] knockDownBB = new JButton[16];
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage("images\\icon.png");
        mainFrame.setIconImage(img);
        boolean select = false;


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
        sidePanel.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().add(boardPanel, BorderLayout.CENTER);
        sidePanel.setPreferredSize(new Dimension(800,800));
        mainFrame.getContentPane().add(sidePanel, BorderLayout.WEST);
        knockDownBlack.setSize(new Dimension(800,200));
        knockDownWhite.setSize(new Dimension(800,200));
        turnPanel.setSize(new Dimension(800,400));
        sidePanel.add(knockDownBlack);
        sidePanel.add(turnPanel);
        turnPanel.add(jlabel);
        sidePanel.add(knockDownWhite);
        knockDownBlack.setLayout(new GridLayout(2,8));
        knockDownWhite.setLayout(new GridLayout(2,8));
        for (int i = 0 ; i < 16 ; i++)
            {
                knockDownBB[i] = new JButton();
                knockDownBlack.add(knockDownBB[i]);
                knockDownWB[i] = new JButton();
                knockDownWhite.add(knockDownWB[i]);
                if (i % 2 == 0 && i < 8)
                {
                    knockDownBB[i].setBackground(new Color(166, 212, 219));
                    knockDownWB[i].setBackground(new Color(166, 212, 219));
                }
                else if (i % 2 == 1 && i < 8)
                {
                    knockDownBB[i].setBackground(new Color(79, 107, 122));
                    knockDownWB[i].setBackground(new Color(79, 107, 122));

                }
                if (i % 2 == 0 && i >= 8)
                {
                    knockDownBB[i].setBackground(new Color(79, 107, 122));
                    knockDownWB[i].setBackground(new Color(79, 107, 122));
                }
                else if (i % 2 == 1 && i >= 8)
                {
                    knockDownBB[i].setBackground(new Color(166, 212, 219));
                    knockDownWB[i].setBackground(new Color(166, 212, 219));



                }

            }
        for (int i = 7 ; i >= 0 ; i--)
            for (int j = 7 ; j >= 0 ; j--)
            {
                boardPanel.add(mansB[i][j]);
                mansB[i][j].setPreferredSize(new Dimension(100,100));
                if (j % 2 == 0 && i % 2 == 0)
                    mansB[i][j].setBackground(new Color(219, 188, 170));
                else if (j % 2 == 1 && i % 2 == 1)
                    mansB[i][j].setBackground(new Color(219, 188, 170));
                else
                    mansB[i][j].setBackground(new Color(122, 79, 52));
                mansB[i][j].addActionListener(new ButtonListener(mansB,chess,turnPanel,jlabel,knockDownBB,knockDownWB));

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


    }
}



