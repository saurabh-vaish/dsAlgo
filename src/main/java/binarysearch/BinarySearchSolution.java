package binarysearch;

/***
 *
 *  @link - https://thealgorists.azurewebsites.net/Algo/BinarySearch
 *
 *  complexity - n + n/2 + n/4 .....k ===> If we can reach 1 from n by dividing by 2 in every step in a total of k steps,
 *  then that would mean if we would represent this as a tree then 2 would be the branching factor. Therefore,
 *  we would have 2 k = n
 * => log2(2k) = log2n
 * => k = log2n
 *
 *  so complexity is = O(logn) base 2
 *
 */

public class BinarySearchSolution {
    public static void main(String[] args) {
        int ar[]={0,1,2,4,5,7,8};           // assume array is sorted if not then sort Arrays.sort(ar)
        int target=5;
        int result = iterativeSolution(ar,target);
        if(result<0) System.out.println("result not found");
        else System.out.println("result found at index = "+result);

        int resultr = recursiveSolution(ar,target,0,ar.length-1);
        if(resultr<0) System.out.println("result not found");
        else System.out.println("result found at index = "+resultr);
    }

    private static int iterativeSolution(int[] ar, int target) {
        int start=0,end=ar.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(ar[mid]<target){
                start=mid+1;
            }else if(ar[mid]>target){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    private static int recursiveSolution(int[] ar, int target,int start,int end) {
        if(start>end)return -1;
        int mid=(start+end)/2;
        if(ar[mid]==target)return mid;
        else if(ar[mid]<target) {
            return recursiveSolution(ar,target,mid+1,end);
        }else{
            return recursiveSolution(ar,target,start,mid-1);
        }
    }
}
