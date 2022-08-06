package bitwise;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 04-08-2022
 */
public class FlippingOfImage {

    // program the image is given as 2d binary , flip image then  invert and return image
    public static void main(String[] args) {

        int [][] img = {{1,1,0},{1,0,1},{0,0,0}};  // {{1,0,0},{0,1,0},{1,1,1}}

        // reverse the array and do XOR to invert it
        for (int[] row:img){
            // reverse
            for (int i = 0; i < (img[0].length+1)/2; i++) { // till half
                int temp = row[i] ^ 1;  // getting temp and doing XOR with 1 to get reverse
                row[i] = row[img[0].length -i - 1] ^ 1;  // getting last and replace and XOR the last no
                row[img[0].length- i -1]=temp ;  // swap
            }
        }

        for (int row[]:img) {
            System.out.println(Arrays.toString(row));
        }
    }
}
