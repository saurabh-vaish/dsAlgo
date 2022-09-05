package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 24-08-2022
 */
public class RotateArrayNPlace {

    public static void main(String[] args) {

        int [] ar = {1,2,3,4,5};
        leftRotateByNPlace(ar,2);

        int [] ar2 = {1,2,3,4,5};
        rotate(ar2,2);

        System.out.println(Arrays.toString(ar2));
    }

    private static void leftRotateByNPlace(int [] ar,int n){
        if(ar.length==0)return;
        if(ar.length==2 && n==1){
            int temp=ar[1];
            ar[1]=ar[2];
            ar[2]=temp;
        }
        int temp[]= new int[n];
        for (int i = 0; i < n; i++) {
            temp[i]=ar[i];
        }
        for (int i = 0; i < ar.length-n; i++) {
            ar[i]=ar[i+n];
        }
        for (int i = 0; i < n; i++) {
            ar[ar.length-n+i]=temp[i];
        }
    }


    // O(n) , O(1)
    public static void rotate(int[] ar, int k) {
        if(ar == null || ar.length < 2){
            return;
        }
        int l= ar.length;
//        k = k % ar.length;
        reverse(ar, 0, l-k-1);
        reverse(ar, l-k, l-1);
        reverse(ar, 0, l-1);
    }

    private static void reverse(int[] ar, int i, int j){
        int tmp = 0;
        while(i < j){
            tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
            i++;
            j--;
        }
    }
}
