package array.ctci;

import CtCILibrary.AssortedMethods;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 *
 * @Author saurabh vaish
 * @Date 05-07-2023
 */
public class CTCI_8_ZeroMatrix {

    // comp - O(m*n) , space - O(n)
    // we can optimize to have less space by taking two arrays , one for row and column
    // if in any row or column any zero is present then we will add that in these arrays
    // then in last based on index will these arrays will make zero in mail array
    private static void zeroMatrix(int [][] mat){

        boolean[] row = new boolean[mat.length];
        boolean[] col = new boolean[mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0;i<row.length;i++){
            if(row[i]){
                for(int j=0;j<col.length;j++){
                    mat[i][j]=0;
                }
            }
        }

        for(int j=0;j<col.length;j++){
            if(col[j]){
                for(int i=0;i<row.length;i++){
                    mat[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int nrows = 3;
        int ncols = 3;
        int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);

        AssortedMethods.printMatrix(matrix);

        zeroMatrix(matrix);

        System.out.println();

        AssortedMethods.printMatrix(matrix);
    }
}
