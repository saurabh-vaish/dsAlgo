package array.sort;

import java.util.Random;

/**
 * @Author saurabh vaish
 * @Date 24-01-2023
 *
 * Implementation of quick select algorithm using example of kth largest element
 *
 * Quick sort complexity is O(nlogn) but in quick select its -
 * best - O(n+k)
 * avg - O(n)
 * worst - O(n^2)
 *
 * Its similar to quick sort just we will partition only that part in which we have possibility of our element
 *
 */
public class QuickSelect_KthLargest {

    public static void main(String[] args) {
        int ar[] = {9,3,2,4,8,5,7};
        int k  = 3;
        k = ar.length-k;  // we are doing this because as array is being sorted we can match from last
        int result = quickSelect(ar,0,ar.length-1,k);

        System.out.println(result);
    }

    public static int quickSelect(int ar[] , int left, int right , int k){
        if(left==right)return ar[k]; // on the same element so return kth position

        int pivotIndex = partition(ar, left, right);

        if(k==pivotIndex)return ar[pivotIndex];
        else if(k<pivotIndex) return quickSelect(ar,left,pivotIndex-1,k);
        else return quickSelect(ar,pivotIndex+1,right,k);

    }

    private static int partition(int[] ar, int left, int right) {
        // getting pivot , will choose random one
        int pivotInd = new Random().nextInt((right - left)+1)+ left;  // taking random pivot as it will help in worst case senarios , instead of taking corners
        int pivot = ar[pivotInd];

        // move pivot to right
        swap(ar,pivotInd, right);

        int trackIndex = left;  // index to track
        // check all elements , compare with pivot and move them to left
        for (int i = left; i<= right; i++){
            if(ar[i]<pivot){
                swap(ar,trackIndex,i);
                trackIndex++;
            }
        }

        // after loop index reaches to its correct position where pivot should be
        // so moving pivot to its location
        swap(ar,trackIndex, right);

        return trackIndex;
    }

    // moving pivot to right
    private static void swap(int ar[],int pivotInd, int right){ // making pivot to right as to get largest , if smallest swap with left
        int temp = ar[pivotInd];
        ar[pivotInd] = ar[right];
        ar[right] = temp;
    }

}
