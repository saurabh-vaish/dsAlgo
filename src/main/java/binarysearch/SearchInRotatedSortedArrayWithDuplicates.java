package binarysearch;

/**
 * @author Saurabh Vaish
 * @Date 11-06-2023
 *
 *
 *  name ==  its also called modified binary search array
 *
 *  Useful Tip: If a sorted array is shifted, if you take the middle, always one side will be sorted. Take the recursion according to that rule.
 *
 * 1- take the middle and compare with target, if matches return.
 * 2- if middle is bigger than left side, it means left is sorted
 * 2a- if [left] < target < [middle] then do recursion with left, middle - 1 (right)
 * 2b- left side is sorted, but target not in here, search on right side middle + 1 (left), right
 * 3- if middle is less than right side, it means right is sorted
 * 3a- if [middle] < target < [right] then do recursion with middle + 1 (left), right
 * 3b- right side is sorted, but target not in here, search on left side left, middle -1 (right)
 *
 *
 *
 */
public class SearchInRotatedSortedArrayWithDuplicates {

    public static void main(String[] args) {
        int rotated[] = {3, 1,2,3,3,3,3};  // rotated array by some pivot
        int target = 1;

        int res = searchRotatedArrayWithDuplicates(rotated, target);
        if(res<0) System.out.println("No result found !");
        else System.out.println("Result found at = "+res);
    }

    // complexity = O(n)
    private static int searchRotatedArrayWithDuplicates(int[] arr, int x) {
        int start=0,end=arr.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==x) {
                return mid;
            }
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){  // checking if elements are same for boundary then trim search space
                start++;
                end--;
                continue;
            }
            if(arr[start]<=arr[mid]){  // left is sorted
                if(arr[start] <=x && x<arr[mid]) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else { // right is sorted
                if(arr[mid]<=x && x<arr[end]){
                    // we should search in the sorted side only if
                    // x is greater than mid element value and is less than nums[end]
                    // because if x > nums[end] then x will be in the left (unsorted) side
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }

        return -1;
    }
}
