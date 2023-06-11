package binarysearch;

/**
 * count occurrence of number in sorted array
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class CountOccurrence {


    public static void main(String[] args) {
        int[] ar = {2,5,8,8,8,11,15};
        int x=8;

        int c = count_occurrence(ar,ar.length,x);

        System.out.println(" occurrence of x = " +c);

    }

    private static int count_occurrence(int[] ar,int length,int x){
        int f = first_occurrence(ar, length, x);
        if(f==-1)return 0;

        return (last_occurrence(ar, length, x) -f ) +1;
    }

    private static int first_occurrence(int[] ar, int length, int x) {
        int low=0,high = length-1;
        int first = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==x){
                first=mid;
                high=mid-1;
            } else if (ar[mid]<x) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return first;
    }


    private static int last_occurrence(int[] ar, int length, int x) {
        int low=0,high = length-1;
        int last = -1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(ar[mid]==x){
                last=mid;
                low=mid+1;
            } else if (ar[mid]<x) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        return last;
    }
}
