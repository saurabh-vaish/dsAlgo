package array;

import CtCILibrary.AssortedMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/studio/problems/spiral-matrix_800309
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int ar[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(spiralMatrix(ar));
    }

    // for printing matrix in spiral form we need to print each direction separately
    // first left to right , then top to bottom , then right to left and bottom to top
    private static List<Integer> spiralMatrix(int[][] ar) {
        int n = ar.length;
        int m = ar[0].length;

        int left=0;
        int right = m-1;
        int bottom = n-1;
        int top = 0;

        List<Integer> list = new ArrayList<>();

        while (left<=right && top<=bottom){

            // left  to right
            for (int i = left; i <= right; i++) {
                list.add(ar[top][i]);
            }
            top++;

            // right to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(ar[i][right]);
            }
            right--;

            // right to left
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(ar[bottom][i]);
                }
                bottom--;
            }

            // bottom to top
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(ar[i][left]);
                }
                left++;
            }
        }

        return list;

    }


}
