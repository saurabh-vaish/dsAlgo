package bitwise;

import java.util.Arrays;

/**
 *
 *
 * @Author saurabh vaish
 * @Date 03-08-2022
 */
public class CountTheSetBits2 {

    // Write a program to return an array of number of 1’s in the binary representation of every number in the range [0, n].
    // set bits are the bit which are 1
    public static void main(String[] args) {

        int n = 6;

        System.out.println(Arrays.toString(method1(n)));
    }


    // n-1 of a number is 1 bit less so when we subtract it from n we will get that 1 bit
    // we need to keep check until it becomes 0
    // Complexity == O(k) * O(no of set bit)
    private static int[] method1(int k) {
        int [] ar = new int[k+1];
        for (int i = 0; i <=k; i++) {
            int count=0;
            int n=i;
            while (n>0){
                count++;
                n = n & (n -1 );
            }
            ar[i]=count;
        }
        return ar;
    }

}
