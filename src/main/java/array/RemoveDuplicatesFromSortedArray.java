package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 23-08-2022
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int [] ar = {1,1,2,2,3,3,3,4,5,5,5};

        // using two pointers approach
        // here i is used for inserting and loop for traverse
        int i=0;
        for (int j = 0; j < ar.length; j++) {
            if(ar[i]!=ar[j]){
                ar[++i]=ar[j];
            }
        }

        int[] ar2=Arrays.copyOf(ar,i+1); // we can create new copy as in original there will be duplicates presents as we have filled unique from start
        System.out.println(Arrays.toString(ar2));

    }
}
