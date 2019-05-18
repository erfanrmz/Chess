import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private Chessman[][] chessmen;
    private Ground ground;
    public ButtonListener(Chessman[][] buttons , Ground ground)
    {
        this.ground = ground;
        this.chessmen = buttons;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
            {
                if (e.getSource() == chessmen[i][j])
                {
                    ArrayList<Chessman> canGoThere = ground.canGoThere(chessmen[i][j],ground);
                    for (Chessman man: canGoThere)
                    {
                        man.setBackground(new Color(249, 148, 146));
                    }

                }
            }

    }
}
