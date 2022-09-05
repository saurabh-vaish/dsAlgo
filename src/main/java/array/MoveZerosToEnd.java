package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 24-08-2022
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {

        int [] ar = {0,1,0,3,12}; // {1,3,12,0,0}
//        method1(ar);
//        optimal(ar);
        optimal2(ar);
        System.out.println(Arrays.toString(ar));
    }

    // O(n) * O(no of zeros)
    private static void optimal(int []ar){
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]==0){
                int k=i+1;
                while (k< ar.length && ar[k]==0){
                    k++;
                }
                if(k== ar.length) {
                    break;
                }
                    int temp = ar[k];
                    ar[k] = ar[i];
                    ar[i] = temp;
            }
        }
    }

    // O(n) , O(1)
    private static void optimal2(int []ar){
        int k=0;
        while (k< ar.length){
            if(ar[k]==0)break; // finding first occurrence
            else k++;
        }
        int i=k;
        int j=k+1;

        while (i< ar.length && j< ar.length){
            if(ar[j]!=0){    // replace every non zero
                int temp=ar[i];
                ar[i]=ar[j];
                ar[j]=temp;
                i++;
            }
            j++;
        }
    }

    // O(n) , 0(n)  , as using extra space
    private static void method1(int []ar){
        int[] t = new int[ar.length];
        int k=0;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]!=0) {
                t[k++]=ar[i];
            }
        }
        for (int i = 0; i < ar.length; i++) {
            ar[i]=t[i];
        }

    }

}
