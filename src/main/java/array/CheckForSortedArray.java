package array;

/**
 * @Author saurabh vaish
 * @Date 23-08-2022
 */
public class CheckForSortedArray {

    public static void main(String[] args) {
        int [] ar={1,2,3,4,5,3};

        System.out.println(isSorted(ar));
    }

//    O(N) , O(1)
    // in brute force we have to compare elements using two loops
    // but here only one loop is being used
    private static boolean isSorted(int[] ar) {
        for (int i = 1; i< ar.length; i++){
            if(ar[i]< ar[i-1]) return false;
        }
        return true;
    }
}
