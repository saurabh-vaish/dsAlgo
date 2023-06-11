package array.sort;


import java.util.Arrays;

/**
 *  Implementation of selection sort algorithm.
 *
 *  Selection sort is a simple sorting algorithm that works by replacing the element at currect position
 *
 *  It select the minimum element and place it at currect position
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
        int [] crr = Arrays.copyOf(arr,arr.length);
        System.out.println("Before sorting == "+ Arrays.toString(arr));
        sortAscendingOrder(arr);
        System.out.println("After sorting == "+ Arrays.toString(arr));

        System.out.println("Before sorting == "+ Arrays.toString(brr));
        sortDescendingOrder(brr);
        System.out.println("After sorting == "+ Arrays.toString(brr));

        System.out.println("Before sorting == "+ Arrays.toString(crr));
        simple(crr);
        System.out.println("After sorting == "+ Arrays.toString(crr));
    }

    static void simple(int ar[]){
        // int min=0;
        for(int i=0;i<ar.length-1;i++){ // traversing each element
            int min = i;
            for(int j=i+1;j<ar.length;j++){ // find min element from ith to n
                if(ar[j]<ar[min]){
                    min=j;
                }
            }
            // swap min with ith element in each pass
            int temp=ar[min];
            ar[min]=ar[i];
            ar[i]=temp;
        }
    }
}
