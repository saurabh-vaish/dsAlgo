package sort;


import java.util.Arrays;

/**
 *  Implementation of Insertion sort algorithm.
 *
 *  Insertion sort is a simple sorting algorithm that works by inserting the element and sort another element.
 *
 *  In every pass we take an element from the array and insert it and then sort rest of array.
 *
 * @Complexity == Best Case == O(n)
 *                Worst Case == O(n^2) [ reverse order ]
 *
 */
public class InsertionSort {

    public static void sortDescendingOrder(int [] arr){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j] > arr[j-1]){
                    swap(arr,j,j-1);
                }else
                    break;
            }
        }

    }


    public static void sortAscendingOrder(int [] arr){

        for (int i = 0; i < arr.length-1; i++) { // as j is starting from i+1
            for (int j = i+1; j >0; j--) {
                if(arr[j] < arr[j-1]){ // compare current element with previous element , if less than swap
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }

    }

    public static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {3,5,4,6,2,1};
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
