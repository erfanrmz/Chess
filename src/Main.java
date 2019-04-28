public class Main {
    public static void main(String[] arg)  {
        Ground Chess = new Ground();
        Pawn WP1 = new Pawn("WP1" , 'W',1,0,Chess);
        Pawn WP2 = new Pawn("WP2" , 'W',1,1,Chess);
        Pawn WP3 = new Pawn("WP3" , 'W',1,2,Chess);
        Pawn WP4 = new Pawn("WP4" , 'W',1,3,Chess);
        Pawn WP5 = new Pawn("WP5" , 'W',1,4,Chess);
        Pawn WP6 = new Pawn("WP6" , 'W',1,5,Chess);
        Pawn WP7 = new Pawn("WP7" , 'W',1,6,Chess);
        Pawn WP8 = new Pawn("WP8" , 'W',1,7,Chess);
        Pawn BP1 = new Pawn("BP1" , 'B',6,0,Chess);
        Pawn BP2 = new Pawn("BP2" , 'B',6,1,Chess);
        Pawn BP3 = new Pawn("BP3" , 'B',6,2,Chess);
        Pawn BP4 = new Pawn("BP4" , 'B',6,3,Chess);
        Pawn BP5 = new Pawn("BP5" , 'B',6,4,Chess);
        Pawn BP6 = new Pawn("BP6" , 'B',6,5,Chess);
        Pawn BP7 = new Pawn("BP7" , 'B',6,6,Chess);
        Pawn BP8 = new Pawn("BP8" , 'B',6,7,Chess);

        Chess.printground();
    }
}