package array.ctci;

import CtCILibrary.AssortedMethods;

/**
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place
 *
 * @Author saurabh vaish
 * @Date 06-07-2023
 */
public class CTCI_7_RotateMatrix {

    // comp - O(n2) , space = O(1)
    // to rotate an matrix by 90 degree we need to shift elements , top->right , right->bottom, bottom->left, left->top
    // for swapping we will do it index by index
    // and we will do it layer by layer
    private static boolean rotate(int [][] mat){

        // row , col length must be same
        if(mat.length==0 || mat.length != mat[0].length )return false;

        int row = mat.length;

        for(int layer=0;layer<row/2;layer++){
            int first = layer;
            int last = row-1-layer;

            for(int i=first;i<last;i++){
                int offset = i-first;

                int top = mat[first][i];  // top layer

                // left --> top
                mat[first][i] = mat[last-offset][first];  // shifting left elements to top row

                // top--> right
                mat[i][last] = top; // shifting top to right

                // right --> bottom
                mat[last][last-offset] = mat[i][last];  // shifting right elements to bottom row

                // bottom --> left
                mat[last-offset][first]=mat[last][last-offset];  // shifting bottom elements to left row
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(3, 3, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }

}
