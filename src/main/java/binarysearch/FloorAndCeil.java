package binarysearch;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/ceiling-in-a-sorted-array_1825401
 *
 *  floor of x = largest element in array which is smaller than or equal to x . i.e. arr[ind] <=x
 *  ceil of x = smallest element in array which is greater than or equal to x . i.e. arr[ind] >=x , i.e. lower bound
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class FloorAndCeil {

    public static void main(String[] args) {
//        int[] arr = {10,20,30,40,50};
        int[] arr = {10,20,25,25,30,40,50};
        int x = 25;

        int ind = ceil(arr,x,arr.length);

        System.out.println("ceil of x == "+ind);

        int floor = floor(arr,x,arr.length);

        System.out.println("floor of x == "+ind);

    }

    // complexity == log(n)
    private static int ceil(int[] arr, int x, int length) {
        int low = 0, high = length-1;
        int ans=length; // if LB not found for an element then it will be length of array

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=x){
                ans = arr[mid];
                high=mid-1;
            }
            else{
                low = mid+1; // as we need to look greater numbers
            }
        }

        return ans;
    }

    // complexity == log(n)
    private static int floor(int[] arr, int x, int length) {
        int low = 0, high = length-1;
        int ans=length; // if LB not found for an element then it will be length of array

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]<=x){
                ans = arr[mid];
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
    }

}
