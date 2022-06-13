package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 12-06-2022
 */
public class SortInEventPlace {

    public static void main(String[] args) {

        int [] ar = new int[]{2,31,1,5,4,7};
        int [] ar2 = new int[]{2,31,1,5,4,7};

        int [] even = new int[ar.length/2];

        for (int i = 1; i < ar.length; i=i+2) {
            even[i/2]=ar[i];
        }

        System.out.println(Arrays.toString(ar));
        Arrays.sort(even);
        System.out.println(Arrays.toString(even));

        for (int i = 0; i < even.length; i++) {
            ar[2*i+1]=even[i];
        }

        System.out.println(Arrays.toString(ar));

        for (int i = 1; i < ar2.length; i=i+1) { // only traverse even positions
            for (int j = 1; j < ar2.length-2; j=j+1) { // only traverse even positions
                if(ar2[j]>ar2[j+2]){
                    int temp = ar2[j+2];
                    ar2[j+2]=ar2[j];
                    ar2[j]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(ar2));
    }
}
