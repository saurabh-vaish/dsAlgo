package array;

/**
 * @Link = https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/ , https://aaronice.gitbook.io/lintcode/binary-search/search-in-rotated-sorted-array , https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @Problem = There is an integer array nums sorted in ascending order (with distinct values). Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *             We need to search a given element in a rotated sorted array. in o(log N ) time
 *
 * @Solution  == We can have two solution as bruteforce linear search and using binary search
 *
 * @Complexity = Time - O(log N) , space - O(1)
 *
 * @Author saurabh vaish
 * @Date 17-06-2022
 */
public class SearchInRotatedArray {

    public static void main(String[] args) {

        int [] ar = new int[]{2,5,7,0,1,3};
        int target = 2;

        System.out.println(getTargetIndexUsingBinary(ar,target));
    }


    // using binary search , as linear search would take O(n)
    // since the array is sorted we will take binary search, but it is rotated so we will modify our binary search
    // take mid and check for sorted part of array
    // check if left is less than mid then left is sorted , similar check or right i.e. right is greater than mid
    // if any part is sorted then check if target lies in that part
    // if its in left then target lie b/w left and mid and if in right part then it should lie b/t mid and right
    // if target does not lies in part then skip that part
    // if found return index or -1
    //
    // time - O(n) , space-  O(1)
    private static int getTargetIndexUsingBinary(int []ar , int target){
        if(ar.length==1)return ar[0]==target?0:-1;

        int left = 0;
        int right = ar.length-1;

        while (left<=right){
            int mid = (left+right)/2;

            if(ar[mid]==target)return mid;
            // check if left part is sorted
            if(ar[left]<=ar[mid]){
                // check if target lies with in left part range
                if(ar[left] <= target && target<=ar[mid]){
                    right=mid-1;
                }else{
                    left = mid+1; // skipping that array as no possibility of target in this range
                }
            }else if(ar[right]>=ar[mid]){

                // check if target lies with in right part range
                if(ar[mid] <= target && target<=ar[right]){
                    left = mid+1;
                }else{
                    right=mid-1; // skipping that array as no possibility of target in this range
                }
            }
        }
        return -1;

    }
}
