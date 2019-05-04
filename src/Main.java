import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Ground chess = new Ground();
        int moveNumber = 0;
        Scanner sc = new Scanner(System.in);
        while (((King) chess.getMan(30)).isMate() == false && ((King) chess.getMan(14)).isMate() == false) {
            chess.printground();
            char turn = 'W';
            if (moveNumber % 2 == 0)
                turn = 'W';
            else turn = 'B';
            int xF = 0;
            int yF = 0;
            String manName;
            String move;
            manName = sc.next();
            move = sc.next();
            yF = (int) move.charAt(0) - 65;
            xF = ((int) move.charAt(1)) - 49;
            int kingNum = turn == 'W'?14:30;
            Chessman man = chess.findMan(manName);
            if (chess.check(turn , chess))
            {
                System.out.println(((King)chess.getMan(kingNum)).isCheck());
                    ((King)chess.getMan(kingNum)).setCheck(true);
                System.out.println(((King)chess.getMan(kingNum)).isCheck());
            }
            if (man.getColor() == turn) {

                if (man.isDeath())
                    System.out.println("You cant move dead mans \n Choose another man:");

                else if (!man.isDeath() && !(((King)chess.getMan(kingNum)).isCheck())){
                    if (man.move(xF, yF, chess))
                        moveNumber++;
                    else
                        System.out.println("Wrong move , Try again!");
                }
//                else if (!man.isDeath() && (((King)chess.getMan(kingNum)).isCheck()))
//                {
//                    try {
//                        Ground testMove = (Ground)chess.clone();
//                        System.out.println("copy copy \n\n\n\n");
//                        testMove.printground();
//                    } catch (CloneNotSupportedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
            } else
                System.out.println("Its not " + (man.getColor() == 'B' ? "Black" : "White") + " turn");
        }
    }
}



