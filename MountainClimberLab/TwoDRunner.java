public class TwoDRunner{
    public static void main(String[] args){
        int value[][] = {{0, 2, 2},
                         {204, 2, 10},
                         {10, 4, 3}};
        TwoDArrayProb test = new TwoDArrayProb(value);
        System.out.println(test.sum());
        System.out.println(test.isSquare());
        test.addMatrix(new int[][]{ {0, 0, 0},
                                    {0, 0, 0},
                                    {0, 0, 0}});
        System.out.println();
        System.out.println(test.diagDifference());
        System.out.println(test.isColumnMagic());
    }
}