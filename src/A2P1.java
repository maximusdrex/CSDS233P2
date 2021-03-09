import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A2P1 {

    public static boolean inMatrix(int[ ] [ ] matrix, int x)
    {
        for(int i = 0; i < matrix.length; i++) {
            int next = matrix[i][matrix[i].length -1];
            if(next >= x) {
                int j = matrix[i].length - 2;
                while(next >= x) {
                    if(next == x) {
                        return true;
                    } else if (j == 0){
                        break;
                    } else {
                        next = matrix[i][j];
                        j--;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int[][] matrix = new int[size][size];
        try {
            File matFile = new File(args[1]);
            Scanner matscan = new Scanner(matFile);
            int count = 0;
            while(matscan.hasNextLine()) {
                String[] line = matscan.nextLine().split(" ");
                int[] intLine = new int[size];
                for(int i = 0; i < size; i++) {
                    intLine[i] = Integer.parseInt(line[i]);
                }
                matrix[count] = intLine;
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, file does not exist");
        }
        int x = 6;
        if(args.length > 2) {
            x = Integer.parseInt(args[2]);
        }

        long start = System.nanoTime();
        Boolean isInMat = inMatrix(matrix, x);
        long finish = System.nanoTime();
        long diff = finish - start;

        System.out.println(diff + " " + isInMat.toString());
    }

    //just for debugging
    private static void debugInfo(int[][] mat, int x) {
        //Print matrix (temp testing)
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j< mat[i].length; j++) {
                System.out.print(Integer.toString(mat[i][j]) + " ");
            }
            System.out.print("\n");
        }

        System.out.println("x = " + Integer.toString(x));
    }
}
