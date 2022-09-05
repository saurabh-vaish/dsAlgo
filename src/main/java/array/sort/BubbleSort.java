package array.sort;


import java.util.Arrays;

/**
 *  Implementation of bubble sort algorithm.
 *
 *  Bubble sort is a simple sorting algorithm that works by repeatedly swapping adjacent elements if they are in wrong order.
 *
 *  In every pass we sort the max element will come at the last respective index
 *
 * @Complexity == Best Case == O(n)
 *                Worst Case == O(n^2) [ reverse order ]
 *
 */
public class BubbleSort {

    public static void sort(int [] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }

        boolean isSwapped = false;
        for(int i=0;i<arr.length;i++){
            for (int j = 0; j < arr.length-1; j++) { // as last element is already sorted
                if(arr[j]>arr[j+1]){  // for accending order
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSwapped=true;
                }
            }
            if(!isSwapped){ // if no swap happened then array is already sorted
                break;
            }
        }

    }

    public static void main(String[] args) {
        int [] arr = {2,3,5,1,6,7,21,8,9};

//        int [] arr = {1,2,3,4,5,6,7,8,9}; // already sorted O(n)
//        int [] arr = {9,8,7,6,5,4,3,2,1}; // reverse order O(n^2)

        System.out.println("Before sorting == "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("After sorting == "+ Arrays.toString(arr));
    }
}
