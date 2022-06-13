package array;

import java.util.Arrays;

/**
 * @Problem -- Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
 *              
 *              Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

                Output:       [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 *      Time Complexity: O(N*M + N*M)

        Space Complexity: O(N)
 */
public class MatrixRowColZero {
    
    public static void main(String[] args) {
        
        int[][] ar = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        // int[][] ar = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        System.out.println("old array ==");

        for (int[] a : ar) {
            System.out.println(Arrays.toString(a) +" ");
        }
        
        int[][] brueForceAr = usingBruteForce(Arrays.copyOf(ar, ar.length));

    }

    private static int[][] usingBruteForce(int[][] ar) {
        int[] dummy1 = new int[ar.length];
        int[] dummy2 = new int[ar[0].length];

        // filling the array with -1 to prevent from default values
        Arrays.fill(dummy1, -1); 
        Arrays.fill(dummy2, -1);

        int[][] newAr = new int[ar.length][ar[0].length];

        for (int i = 0; i < ar.length; i++) { // row length
            for (int j = 0; j < ar[0].length; j++) { // col length
                if (ar[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;

                } 
                // else {
                //     newAr[i][j] = ar[i][j];
                // }
            }
        }
        
        for (int i = 0; i < ar.length; i++) { 
            for (int j = 0; j < ar[0].length; j++) { 
                if (dummy1[i] == 0 || dummy2[j] == 0) {  // every time whenever row or col is zero then change the main array
                    newAr[i][j] = 0;
                } else {
                    newAr[i][j] = ar[i][j];
                }
            }
        }
        
        return newAr;
    }
}