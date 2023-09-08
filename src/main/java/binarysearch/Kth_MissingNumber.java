package binarysearch;

/**
 * https://www.codingninjas.com/studio/problems/kth-missing-element_893215
 *
 *  given an array of increasing numbers and k , find the kth missing number in array
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */
public class Kth_MissingNumber {


    // O(n), O(1)
    // consider numbers from 1 to n , then the missing numbers would be the numbers that are not present in array
    // so we need to check until we found the element that is greater than k
    static int missingBrute(int[] ar,int k){
        for(int i=0;i<ar.length;i++){
            if(ar[i]<=k)k++;
            else break;
        }
        return k;
    }


    // using binary search
    public static int missingK(int[] ar, int n, int k) {
        // Write your code here.

        int low=0, high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            int missing = ar[mid] - (mid+1);

            if(missing<k){
                low=mid+1;
            }else{
                high = mid-1;
            }

        }

        return low+k;

    }

    public static void main(String[] args) {
//         int [] ar={2,4,5,7};
         int [] ar={4,7,9,10};
         int k=1;

        System.out.println(missingBrute(ar,k));
        System.out.println(missingK(ar,ar.length,k));
    }
}
