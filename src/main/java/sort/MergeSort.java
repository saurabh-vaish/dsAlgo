package sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author saurabh vaish
 * @Date 12-06-2022
 */
public class MergeSort {

    public static void main(String[] args) {

        int ar[] = new int[]{4,3,1,2,5};

        int [] newAr = mergeSort(ar);

        System.out.println(Arrays.toString(newAr));

        mergeSortInPlace(ar,0, ar.length );
        System.out.println(Arrays.toString(ar));

    }

    // using divide and conquer then merge
    // first we will devide the array untill it has one element left
    // compare element from both arrays and store in new array
    // Time - O( n * long(n)) , n for total element and logn for doing work
    // In this method original array will not get modified
    // space - O(n) // stack space
    private static int[] mergeSort(int[] ar) {
        if(ar.length==1)return ar;

        int mid = ar.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(ar,0,mid)); // creating copy of array and sending back
        int[] right = mergeSort(Arrays.copyOfRange(ar,mid,ar.length));
        
        return merge(left,right);

    }

    // merging both array in new array
    private static int[] merge(int[] left, int[] right) {
        // create array for both sizes
        int [] mix = new int[left.length+ right.length];

        // using two pointers to check both array simultaneously
        int i=0,j=0,k=0;

        // run and store until one the array is empty
        while (i<left.length && j< right.length){
            if(left[i]<right[j]){
                mix[k]=left[i];
                i++;
            }else{
                mix[k]=right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        while (i< left.length){
            mix[k]=left[i];
            i++;
            k++;
        }

        while (j< right.length){
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }



    // using divide and conquer then merge
    // first we will devide the array untill it has one element left
    // compare element from both arrays and store in new array then modify original array
    // Time - O( n * long(n)) , n for total element and logn for doing work
    // In this method original array will get modified
    // space - O(n) // stack space
    private static void mergeSortInPlace(int[] ar,int start,int end) {
        if(end-start==1)return;

        int mid = (start + end)/2;

        mergeSortInPlace(ar,start,mid);
        mergeSortInPlace(ar,mid,ar.length);

        mergeInPlace(ar,start,mid,end);

    }

    // merging both array and update original array
    private static void mergeInPlace(int[] ar,int start,int mid,int end) {
        // create array for both sizes
        int [] mix = new int[end-start]; // length of array

        // using two pointers to check both array simultaneously
        int i=start;
        int j=mid;
        int k=0;

        // run and store until one the array is empty
        while (i<mid && j< end){
            if(ar[i]<ar[j]){
                mix[k]=ar[i];
                i++;
            }else{
                mix[k]=ar[j];
                j++;
            }
            k++;
        }


        // copy remaining elements
        while (i< mid){
            mix[k]=ar[i];
            i++;
            k++;
        }

        while (j< end){
            mix[k] = ar[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            ar[start+l]=mix[l];
        }

    }


}
