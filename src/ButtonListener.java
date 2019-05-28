import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private JButton[][] chessmenB;
    private Ground chess;
    private Chessman[][] chessmen;
    private JPanel turnPanel;
    private char turn;
    private JLabel jLabel;
    private JButton[] knockDownBB;
    private JButton[] knockDownWB;

    public ButtonListener(JButton[][] buttons, Ground chess, JPanel turnPanel, JLabel jLabel,JButton[] knockDownBB , JButton[] knockDownWB) {
        this.chess = chess;
        this.chessmenB = buttons;
        chessmen = chess.getMans();
        this.turnPanel = turnPanel;
        this.jLabel = jLabel;
        this.knockDownBB = knockDownBB;
        this.knockDownWB = knockDownWB;
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (turnPanel.getBackground() == Color.black)
            turn = 'B';
        else
            turn = 'W';
        String kingName = turn == 'W' ? "WK1" : "BK1";
        Boolean selected = false;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (chessmen[i][j].isSelect())
                    selected = true;
        if (chess.check(turn, chess)) {
            System.out.println(turn == 'W' ? "White Check" : "Black Check");
            jLabel.setText(turn == 'W' ? "White Check" : "Black Check");
            ((King) chess.findMan(kingName)).setCheck(true);
            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(186, 112, 200));
        } else {

            ((King) chess.findMan(kingName)).setCheck(false);
            if (chess.findMan(kingName).getY() % 2 == 0 && chess.findMan(kingName).getX() % 2 == 0)
                chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
            else if (chess.findMan(kingName).getY() % 2 == 1 && chess.findMan(kingName).getX() % 2 == 1)
                chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
            else
                chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(122, 79, 52));
        }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (e.getSource() == chessmenB[i][j] && chessmen[i][j].getColor() == turn && !selected) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++) {
                            if (z % 2 == 0 && k % 2 == 0)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else if (z % 2 == 1 && k % 2 == 1)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else
                                chessmenB[k][z].setBackground(new Color(122, 79, 52));
                        }

                    ArrayList<Chessman> canGoThere = chess.canGoThere(chessmen[i][j], chess);
                    for (Chessman chessman : canGoThere) {
                        if (!chessman.getName().equals("   "))
                            chessmenB[chessman.getX()][chessman.getY()].setBackground(new Color(255, 80, 80));
                        else
                            chessmenB[chessman.getX()][chessman.getY()].setBackground(new Color(153, 246, 249));
                    }
                    if (!chessmen[i][j].getName().equals("   "))
                        chessmenB[i][j].setBackground(new Color(213, 200, 91));
                    chessmen[i][j].setSelect(true);
                    if (chess.check(turn, chess)) {
                        System.out.println(turn == 'W' ? "White Check" : "Black Check");
                        jLabel.setText(turn == 'W' ? "White Check" : "Black Check");
                        ((King) chess.findMan(kingName)).setCheck(true);
                        chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(186, 112, 200));
                    } else {

                        ((King) chess.findMan(kingName)).setCheck(false);
                        if (chess.findMan(kingName).getY() % 2 == 0 && chess.findMan(kingName).getX() % 2 == 0)
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                        else if (chess.findMan(kingName).getY() % 2 == 1 && chess.findMan(kingName).getX() % 2 == 1)
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                        else
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(122, 79, 52));
                    }
                } else if (e.getSource() == chessmenB[i][j] && selected) {
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++) {
                            if (z % 2 == 0 && k % 2 == 0)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else if (z % 2 == 1 && k % 2 == 1)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else
                                chessmenB[k][z].setBackground(new Color(122, 79, 52));
                        }

                    int xI = 0;
                    int yI = 0;
                    int xF = 0, yF = 0;
                    for (int k = 0; k < 8; k++)
                        for (int z = 0; z < 8; z++) {
                            if (chessmen[k][z].isSelect()) {
                                xI = k;
                                yI = z;
                                chessmen[k][z].setSelect(false);
                            }

                        }

                    xF = i;
                    yF = j;
                    Chessman man = chessmen[xI][yI];
                    if (man.getColor() == turn) {

                        if (man.isDeath())
                            System.out.println("You cant move dead mans \n Choose another man:");

                        else if (!man.isDeath() && !(((King) chess.findMan(kingName)).isCheck())) {
                            int lastx = man.getX();
                            int lasty = man.getY();

                            if (chess.checkEmpty(xF, yF)) {
                                if (man.move(xF, yF, chess)) {
                                    if (chess.check(turn, chess)) {
                                        man.setX(lastx);
                                        man.setY(lasty);
                                        chess.setCell("   ", xF, yF);
                                        chess.setCell(man.getName(), man.getX(), man.getY());
                                        System.out.println("Wrong move , Try again!");
                                    } else {
                                        chess.swapMans(xI, yI, xF, yF);
                                        chessmen[xI][yI] = new Empty("   ", 'N', xI, yI);
                                        chessmenB[xI][yI].setIcon(null);
                                        chessmenB[xF][yF].setIcon(chess.getMan(xF, yF).getIcon());
                                        if (turn == 'W') {
                                            turn = 'B';
                                            turnPanel.setBackground(Color.black);
                                            jLabel.setText("Black Turn");
                                        } else if (turn == 'B') {
                                            turn = 'W';
                                            jLabel.setText("White Turn");
                                            turnPanel.setBackground(Color.white);
                                        }
                                    }
                                } else
                                    System.out.println("Wrong move , Try again");
                            } else if (chess.getCell(xF, yF).charAt(0) != turn) {
                                Chessman deadman = chess.findMan(chess.getCell(xF, yF));
                                if (man.move(xF, yF, chess)) {
                                    if (chess.check(turn, chess)) {
                                        man.setX(lastx);
                                        man.setY(lasty);
                                        chess.setCell("   ", xF, yF);
                                        chess.setCell(man.getName(), man.getX(), man.getY());
                                        deadman.setDeath(false);
                                        deadman.setX(xF);
                                        deadman.setY(yF);
                                        chess.setCell(deadman.getName(), deadman.getX(), deadman.getY());
                                        System.out.println("Wrong move , Try again!");
                                    } else {
                                        chess.swapMans(xI, yI, xF, yF);
                                        chessmen[xI][yI] = new Empty("   ", 'N', xI, yI);
                                        chessmenB[xI][yI].setIcon(null);
                                        chessmenB[xF][yF].setIcon(chess.getMan(xF, yF).getIcon());
                                        if (turn == 'W') {
                                            turn = 'B';
                                            turnPanel.setBackground(Color.black);
                                            jLabel.setText("Black Turn");
                                        } else if (turn == 'B') {
                                            turn = 'W';
                                            jLabel.setText("White Turn");
                                            turnPanel.setBackground(Color.white);
                                        }
                                    }
                                } else
                                    System.out.println("Wrong move , Try again");
                            }
                        } else if (!man.isDeath() && (((King) chess.findMan(kingName)).isCheck())) {
                            int lastx = man.getX();
                            int lasty = man.getY();
                            Boolean pawn = man.getClass().getName().equals("Pawn") && !((Pawn) man).isFirstMove();
                            if (chess.checkEmpty(xF, yF)) {

                                if (man.move(xF, yF, chess)) {
                                    if (chess.check(turn, chess)) {
                                        man.setX(lastx);
                                        man.setY(lasty);
                                        chess.setCell("   ", xF, yF);
                                        chess.setCell(man.getName(), man.getX(), man.getY());
                                        if (pawn) {
                                            ((Pawn) man).setFirstMove(false);
                                        }
                                        System.out.println("Wrong move , Try again!");
                                    } else {
                                        chess.swapMans(xI, yI, xF, yF);
                                        chessmen[xI][yI] = new Empty("   ", 'N', xI, yI);
                                        chessmenB[xI][yI].setIcon(null);
                                        chessmenB[xF][yF].setIcon(chess.getMan(xF, yF).getIcon());
                                        if (turn == 'W') {
                                            turn = 'B';
                                            turnPanel.setBackground(Color.black);
                                            jLabel.setText("Black Turn");
                                        } else if (turn == 'B') {
                                            turn = 'W';
                                            jLabel.setText("White Turn");
                                            turnPanel.setBackground(Color.white);
                                        }
                                    }
                                } else
                                    System.out.println("Wrong move , Try again");
                            } else if (chess.getCell(xF, yF).charAt(0) != turn) {
                                Chessman deadman = chess.findMan(chess.getCell(xF, yF));
                                if (man.move(xF, yF, chess)) {
                                    if (chess.check(turn, chess)) {
                                        man.setX(lastx);
                                        man.setY(lasty);
                                        chess.setCell("   ", xF, yF);
                                        chess.setCell(man.getName(), man.getX(), man.getY());
                                        deadman.setDeath(false);
                                        deadman.setX(xF);
                                        deadman.setY(yF);
                                        chess.setCell(deadman.getName(), deadman.getX(), deadman.getY());
                                        System.out.println("Wrong move , Try again!");
                                    } else {

                                        chess.swapMans(xI, yI, xF, yF);
                                        chessmen[xI][yI] = new Empty("   ", 'N', xI, yI);
                                        chessmenB[xI][yI].setIcon(null);
                                        chessmenB[xF][yF].setIcon(chess.getMan(xF, yF).getIcon());
                                        if (turn == 'W') {
                                            turn = 'B';
                                            turnPanel.setBackground(Color.black);
                                            jLabel.setText("Black Turn");
                                        } else if (turn == 'B') {
                                            turn = 'W';
                                            jLabel.setText("White Turn");
                                            turnPanel.setBackground(Color.white);
                                        }
                                    }
                                } else
                                    System.out.println("Wrong move , Try again");
                            }
                        }

                    } else
                        System.out.println("Its not " + (man.getColor() == 'B' ? "Black" : "White") + " turn");
                    kingName = turn == 'W'?"WK1":"BK1";

                    if (chess.check(turn, chess)) {
                        System.out.println(turn == 'W' ? "White Check" : "Black Check");
                        jLabel.setText(turn == 'W' ? "White Check" : "Black Check");
                        ((King) chess.findMan(kingName)).setCheck(true);
                        chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(186, 112, 200));
                    } else {

                        ((King) chess.findMan(kingName)).setCheck(false);
                        if (chess.findMan(kingName).getY() % 2 == 0 && chess.findMan(kingName).getX() % 2 == 0)
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                        else if (chess.findMan(kingName).getY() % 2 == 1 && chess.findMan(kingName).getX() % 2 == 1)
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(219, 188, 170));
                        else
                            chessmenB[chess.findMan(kingName).getX()][chess.findMan(kingName).getY()].setBackground(new Color(122, 79, 52));
                    }
                    for (int k = 0 ; k < chess.getKnockDownW().size() ; k++)
                    {
                        knockDownWB[k].setIcon(chess.getKnockDownW().get(k).getIcon());
                    }
                    for (int k = 0 ; k < chess.getKnockDownB().size() ; k++)
                    {
                        knockDownBB[k].setIcon(chess.getKnockDownB().get(k).getIcon());
                    }

                }
            }
    }
}
