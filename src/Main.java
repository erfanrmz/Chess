import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Ground chess = new Ground();
        int moveNumber = 0;
        Scanner sc = new Scanner(System.in);
        while (((King) chess.getMans(30)).isMate() == false && ((King) chess.getMans(14)).isMate() == false) {
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
            Chessman man = chess.findMan(manName);
            if (man.getColor() == turn) {


                if (man.isDeath())
                    System.out.println("You cant move dead mans \n Choose another man:");
                else {
                    if (man.move(xF, yF, chess) == true)
                        moveNumber++;
                }
            } else
                System.out.println("Its not " + (man.getColor() == 'B' ? "Black" : "White") + " turn");
        }
    }
}