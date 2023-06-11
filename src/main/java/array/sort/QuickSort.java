package array.sort;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 22-01-2023
 */
public class QuickSort {

    public static void main(String[] args) {
//        int ar[] = {5,4,3,2,1};
        int ar[] = {19, 18, 8, 11, 5, 11, 2, 19, 2, 7, 1, 9, 11, 5, 19};

        quickSort(ar,0,ar.length-1);

        System.out.println(Arrays.toString(ar));
    }


    /***
     *  quick sort -- similar to merge sort works but better as it will not sort parts if its already sort
     *             -- works by taking the pivot element
     *             -- It's an un-stable sort.
     *             -- It's an inplace sorting algorithm
     *
     *  1. we can take pivot any element , random , corners or middle
     *  2. on each pass pivot will be in its right position
     *  3. all the element left from pivot must be less than pivot and all elements right from pivot must be greater than pivot element
     *  4. after each pass we will divide the array and sort it untill the array is fully sorted.
     *
     *  Complexity ==
     *      Best case , avg - O(n*logn)
     *      worst case      - O(n^2)
     *
     * **/
    static void quickSort(int[] ar,int low,int high){
        if(low>=high)return; // if low pointer reaches to high all the iteration completed

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;

        int pivot = ar[mid];  // choosing pivot element , taking the middle one

        // iterating the array from start to end
        // start should always less than end

        while (start<=end){
            while (ar[start]<pivot){  // move pointer from left until start is less than pivot
                start++;
            }
            while (ar[end]>pivot){ // move pointer from right till end is higher than pivot
                end--;
            }
            if(start<=end){
                // swapping the pointers to make element less than pivot in left and higher in right from pivot
                int temp = ar[start];
                ar[start] = ar[end];
                ar[end]=temp;
                start++;
                end--;
            }
        }

        quickSort(ar,low,end);
        quickSort(ar,start,high);
    }

}
