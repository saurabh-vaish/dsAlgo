package binarysearch;

/**
 * @author Saurabh Vaish
 * @Date 29-05-2021
 */
public class MinimumInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        int ar[] = {4,6,6,6,8,0,0,1,2};  // rotated array by some pivot
        minimumInRotatedSortedArrayWithDuplicates(ar);
    }

    private static void minimumInRotatedSortedArrayWithDuplicates(int[] ar) {
        int low=0,high=ar.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(ar[mid]>ar[high]){  // element in right part
                low=mid+1;
            }else if(ar[mid]<ar[high]){ // check in left part
                high=mid-1;
            }else {
                // In this case, we are not sure which side of the mid that the desired minimum element would reside.
                // To further reduce the search scope, a safe measure would be to reduce the upper bound by one (i.e. high = high - 1),
                //  rather than moving aggressively to the mid point.
                //  The above strategy would prevent the algorithm from stagnating (i.e. endless loop).
                high=high-1;
            }
        }
        System.out.println("minimum in array = "+ar[low]);
    }
}
