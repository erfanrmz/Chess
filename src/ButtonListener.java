import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private JButton[][] chessmenB;
    private Ground ground;
    private Chessman[][] chessmen;
    private JPanel turnPanel;
    private char turn;
    public ButtonListener(JButton[][] buttons , Ground ground , JPanel turnPanel)
    {
        this.ground = ground;
        this.chessmenB = buttons;
        chessmen = ground.getMans();
        this.turnPanel = turnPanel;

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (turnPanel.getBackground() == Color.black)
            turn = 'B';
        else
            turn = 'W';
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
            {
                if (e.getSource() == chessmenB[i][j] && chessmen[i][j].getColor() == turn )
                {
                    for (int k = 0 ; k < 8 ; k++)
                        for (int z = 0 ; z < 8 ; z++) {
                            if (z % 2 == 0 && k % 2 == 0)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else if (z % 2 == 1 && k % 2 == 1)
                                chessmenB[k][z].setBackground(new Color(219, 188, 170));
                            else
                                chessmenB[k][z].setBackground(new Color(122, 79, 52));
                        }

                    ArrayList<Chessman> canGoThere = ground.canGoThere(chessmen[i][j],ground);
                    for (Chessman chessman: canGoThere)
                    {
                        if (!chessman.getName().equals("   "))
                            chessmenB[chessman.getX()][chessman.getY()].setBackground(new Color(255, 80, 80));
                        else
                            chessmenB[chessman.getX()][chessman.getY()].setBackground(new Color(153, 246, 249));
                    }
                    if (!chessmen[i][j].getName().equals("   "))
                        chessmenB[i][j].setBackground(new Color(213, 200, 91));

                }
                else if (e.getSource() == chessmenB[i][j] && (chessmen[i][j].getColor() == 'N' || chessmen[i][j].getColor()!= turn))
                {


                for (int k = 0 ; k < 8 ; k++)
                    for (int z = 0 ; z < 8 ; z++) {
                        if (z % 2 == 0 && k % 2 == 0)
                            chessmenB[k][z].setBackground(new Color(219, 188, 170));
                        else if (z % 2 == 1 && k % 2 == 1)
                            chessmenB[k][z].setBackground(new Color(219, 188, 170));
                        else
                            chessmenB[k][z].setBackground(new Color(122, 79, 52));
                    }
                }
            }

    }
}
