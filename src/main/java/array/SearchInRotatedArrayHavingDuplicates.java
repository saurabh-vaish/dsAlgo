package array;

/**
 * @Link = https://leetcode.com/problems/search-in-rotated-sorted-array-ii/ , https://aaronice.gitbook.io/lintcode/binary-search/search-in-rotated-sorted-array-ii
 *
 * @Problem = Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e.,[0,0,1,2,2,5,6]might become[2,5,6,0,0,1,2]).
 *              You are given a target value to search. If found in the array returntrue, otherwise returnfalse
 *
 * @Solution  == We can have two solution as bruteforce linear search and using binary search with modification
 *
 * @Complexity = Time - O(log N) , space - O(1)
 *
 * @Author saurabh vaish
 * @Date 17-06-2022
 */
public class SearchInRotatedArrayHavingDuplicates {

    public static void main(String[] args) {

        int [] ar = new int[]{2,5,6,0,0,1,3};
        int target = 20;

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
    private static boolean getTargetIndexUsingBinary(int []ar , int target){
        if(ar.length==1)return ar[0]==target;

        int left = 0;
        int right = ar.length-1;

        while (left<=right){
            // since the element could be duplicates so increase left or right until all duplicates are passed
            while (left<right && ar[left]==ar[left+1])left++;
            while (left<right && ar[right]==ar[right-1])right--;

            int mid = (left+right)/2;

            if(ar[mid]==target)return true;
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
        return false;

    }
}
