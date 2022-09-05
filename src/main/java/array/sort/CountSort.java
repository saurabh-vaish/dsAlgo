package array.sort;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 27-08-2022
 */
public class CountSort {

    // in given array of integers of size k from range 1 to N
    // sort them using count sort
    public static void main(String[] args) {
        int [] ar = {5, 6, 5, 2};
        int k=7;
        int n = ar.length;

//        countSortBasic(ar,k,n);

        countSortOptimized(ar,k,n);

        System.out.println(Arrays.toString(ar));
    }


    // complexity == O(N + K)
    // space = O(K)
    static void countSortOptimized(int [] ar,int k,int n){
        int[] count = new int[k];

        // after this step count will have non-zero on positions same as array elements
        for (int i = 0; i < n; i++) {
            count[ar[i]]++;         // inserting element in count ar based on element of ar as index
        }

        // after this step the count array will be in ascending order of there index sum
        for (int i = 1; i < k; i++) {
            count[i]=count[i-1]+count[i]; // calculating the prefix sum till k
        }

        int[] res = new int[n];
        int index=0;
        for (int i = n-1; i >=0; i--) {  // looping array from end
            int number = ar[i];                // getting the array element
            int countNumber = count[number];    // getting number in count array
            res[countNumber-1]=number;          // store array element in res array
            count[number]--;                // decreasing frequency in count []
        }

        for (int i = 0; i < res.length; i++) {
            ar[i]=res[i];
        }

//        System.arraycopy(res, 0, ar, 0, res.length);
    }


    // complexity == O(N * K)
    // space = O(K)
    static void countSortBasic(int [] ar,int k,int n){
        int[] count = new int[k];

        // after this step count will have non-zero on positions same as array elements
        for (int i = 0; i < n; i++) {
            count[ar[i]]++;         // inserting element in count ar based on element of ar as index
        }

        int index=0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {        // looping till count[i] as if non-zero will insert from start
                ar[index++] = i;                // replacing original array
            }
        }
    }
}
