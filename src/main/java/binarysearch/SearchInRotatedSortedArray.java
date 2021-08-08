package binarysearch;

/**
 * @author Saurabh Vaish
 * @Date 29-05-2021
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
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int ar[] = {0, 1, 2, 4, 5, 6, 8};
        int rotated[] = {4, 6, 8, 0, 1, 2};  // rotated array by some pivot
        int target = 1;
        int res = searchRotatedArrayWithNoDuplicates(rotated, target);
        if(res<0) System.out.println("No result found !");
        else System.out.println("Result found at = "+res);
    }

    private static int searchRotatedArrayWithNoDuplicates(int[] rotated, int target) {
        int start=0,end=rotated.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(rotated[mid]==target) {
                return mid;
            }else if(rotated[mid]>=rotated[start]){  // left is sorted
                if(target>=rotated[start] && target<rotated[mid]) {
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else if(rotated[mid]<=rotated[end]){ // right is sorted
                if(target<=rotated[end] && target>rotated[mid]){
                    // we should search in the sorted side only if
                    // target is greater than mid element value and is less than nums[end]
                    // because if target > nums[end] then target will be in the left (unsorted) side
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }

        return -1;
    }
}
