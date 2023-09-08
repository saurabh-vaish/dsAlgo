package binarysearch;

/**
 *
 * @Link = https://www.codingninjas.com/studio/problems/rotation_7449070
 *
 * @Problem == Find the minimum element in a sorted array in ascending order and being rotated by some pivot .
 *              Assume that there is no duplicates in array .
 *
 * @Solution == This problem is similar to the problem in modified binary search . only diff is that we need to find minimum element
 *              instead of searching it .
 *              This problem can be reduced to "find the minimum index for which nums[index] is less than or equal to the item at the last index".
 *              It is very important to put (less than or equal) and not just (less than) in the condition, because the array can be rotated in a way that the minimum item ends up in the last index,
 *              in which case the minimum is equal to the value of the last item.
 *
 * @Complexity == O(logN), same as that of Binary Search.
 *
 *
 * @author Saurabh Vaish
 * @Date 30-05-2021
 */
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] ar={4,5,6,7,8,9,1,2,3};
        int min = findMinimum(ar);
        System.out.println("min = "+min);
    }

    // log(n)
    private static int findMinimum(int[] ar) {
        int left=0;
        int right= ar.length-1;
        int ans = Integer.MAX_VALUE;

        if(ar.length==1){
            return ar[0];
        }
        while (left<=right){
            int mid=left + (right-left)/2;

            if(ar[left]<=ar[right]){ // already sorted
                ans = Math.min(ans,ar[left]);
                break;
            }

            if(ar[left]<=ar[mid]){
                ans = Math.min(ans,ar[left]);
                left=mid+1; // search in other part , eliminate left
            }else {
                ans= Math.min(ans,ar[mid]); // mid because high will be always greater
                right = mid-1;
            }
        }
        return ans;
    }


}
