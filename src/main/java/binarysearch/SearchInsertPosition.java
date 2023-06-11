package binarysearch;

/**
 * @Link https://www.codingninjas.com/codestudio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
 *
 * find index where an element could get inserted in sorted array
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] arr = {10,20,20,30,40,50};
        int x = 25;

        int ind = search_index_using_lower_bound(arr,x);

        System.out.println("search index of x == "+ind);

    }

    // complexity == log(n)
    private static int search_index_using_lower_bound(int[] arr, int x) {
        int low = 0, high = arr.length-1;
        int ans=arr.length; // if LB not found for an element then it will be length of array

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=x){
                ans = mid;
                high=mid-1;
            }
            else{
                low = mid+1; // as we need to look greater numbers
            }
        }

        return ans;
    }

}
