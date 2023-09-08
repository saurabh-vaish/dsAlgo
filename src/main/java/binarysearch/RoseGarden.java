package binarysearch;

/**
 * @Link = https://www.codingninjas.com/studio/problems/rose-garden_2248080
 *
 * find the minimum no of days required to make n bonquests with k roses from days array , rose must be selected simultaneously and if not possible return -1;
 *
 * @Author saurabh vaish
 * @Date 06-07-2023
 */
public class RoseGarden {


    // using binary search on ans
    // O(n long n) , O(1)
    public static int roseGarden(int[] arr, int n, int k) {
        // Write your code here.

        if(n*k>arr.length)return -1;  // if required roses are more than the days array then not possible

        int low = Integer.MAX_VALUE; int high = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            low = Math.min(low,arr[i]);
            high = Math.max(high,arr[i]);
        }

        // here we are doing BS in possible ans range not on array
        while(low<=high){
            int mid = low + (high-low)/2;

            if(possible(arr,n,k,mid)){
                high=mid-1; // as we need minimum so will look into min part
            }else{
                low=mid+1;
            }

        }

        return low;

    }

    // O(n)
    // method to check in given no of days banquet is possible or not
    private static boolean possible(int[] arr, int n, int k, int mid) {

        int count =0, noOfB=0;

        for (int j : arr) {
            if (j <= mid) {  // if days are less than the mid day , means roses are already bloomed
                count++;  // increase adjacent counter
            } else {
                noOfB += (count / k);   // if any day us greater than mid day then divide counter to no of roses required and add to no of banquets
                count = 0; // make counter 0 again ,as adjacent counter interrupted
            }
        }

        noOfB +=(count/k);

        return noOfB >=n;
    }

    public static void main(String[] args) {
        int arr [] = {1 ,2 ,1 ,2 ,7 ,2 ,2 ,3 ,1};
        int n=2 , k=3;

        System.out.println(roseGarden(arr,n,k));
    }
}
