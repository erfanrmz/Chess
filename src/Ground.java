public class Ground {
    private String[][] cell;
    private Chessman[] mans;
    public Ground (){
        mans = new Chessman[32];
        cell = new String[8][8];
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
                cell[i][j] = "   ";
        for (int i = 0 ; i < 8 ; i++)
        {
            String name = "WP" + i;
            mans[i] = new Pawn (name , 'W',1,i);
            setCell(name , 1 ,i);
        }
        mans[8] = new Rook("WR1",'W',0,0);
        mans[9] = new Rook("WR2",'W',0,7);
        mans[10] = new Knight("WN1",'W',0,1);
        mans[11] = new Knight("WN2",'W',0,6);
        mans[12] = new Bishop("WB1",'W',0,2);
        mans[13] = new Bishop("WB2",'W',0,5);
        mans[14] = new King ("WK ",'W',0,3);
        mans[15] = new Queen("WQ ", 'W',0,4);
        for (int i = 0 ; i < 8 ; i++)
        {
            String name = "BP" + i;
            mans[i+16] = new Pawn (name , 'B',6,i);
            setCell(name , 6 ,i);
        }
        mans[24] = new Rook("BR1",'B',7,0);
        mans[25] = new Rook("BR2",'B',7,7);
        mans[26] = new Knight("BN1",'B',7,1);
        mans[27] = new Knight("BN2",'B',7,6);
        mans[28] = new Bishop("BB1",'B',7,2);
        mans[29] = new Bishop("BB2",'B',7,5);
        mans[30] = new King ("BK ",'B',7,3);
        mans[31] = new Queen("BQ ", 'B',7,4);
        for (int i = 0 ; i < 32 ; i++)
            setCell(mans[i].getName(),mans[i].getX(),mans[i].getY());




    }

    public void setCell(String cell , int i , int j) {
        this.cell[i][j] = cell;
    }
    public void printground()
    {
        for (int i = 0 ; i < 8 ; i++)
        {
            for (int j = 0 ; j < 8 ; j++)
                System.out.print("|" + cell[i][j]);
            System.out.println("|");
        }
    }
}
