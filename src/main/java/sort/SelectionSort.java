package sort;


import java.util.Arrays;

/**
 *  Implementation of selection sort algorithm.
 *
 *  Selection sort is a simple sorting algorithm that works by replacing the element at currect position
 *
 *  In every pass we find the max or min element and swap it with the element at right position.
 *
 * @Complexity == Best Case == O(n^2)
 *                Worst Case == O(n^2) [ reverse order ]
 *
 */
public class SelectionSort {

    public static void sortDescendingOrder(int [] arr){

        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1; // last element position in the array
            int min = findMinElementIndex(arr,0,last);
            swap(arr,min,last);
        }

    }

    public static int findMinElementIndex(int [] arr,int start,int end){
        int min = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }


    public static void sortAscendingOrder(int [] arr){

        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1; // last element position in the array
            int max = findMaxElementIndex(arr,0,last);
            swap(arr,max,last);
        }

    }

    public static int findMaxElementIndex(int [] arr,int start,int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,5,1,6,7,21,8,9};
//        int [] arr = {};
//        int [] arr = {1,2,3,4,5,6,7};
        int [] brr = Arrays.copyOf(arr,arr.length);
        System.out.println("Before sorting == "+ Arrays.toString(arr));
        sortAscendingOrder(arr);
        System.out.println("After sorting == "+ Arrays.toString(arr));

        System.out.println("Before sorting == "+ Arrays.toString(brr));
        sortDescendingOrder(brr);
        System.out.println("After sorting == "+ Arrays.toString(brr));
    }
}
