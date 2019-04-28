public class Ground {
    private String[][] cell;
    public Ground (){
        cell = new String[8][8];
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
                cell[i][j] = "   ";
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
