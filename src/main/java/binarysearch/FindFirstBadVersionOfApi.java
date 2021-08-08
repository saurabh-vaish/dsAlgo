package binarysearch;

/***
 *      === This is the another implementation of binary search , in which we depends on external condition
 *      Complexity == O(logN), assuming isBadVersion() is O(1).
 */

/**
 * @author Saurabh Vaish
 * @Date 29-05-2021
 *
 *  Problem = In an api one of its previous version is bad version , so after that all other versions are also bad
 *              find the minimum number of version which is bad based on a condition that defines bad version
 *              keep in note that there must be less number of api calls
 *
 */
public class FindFirstBadVersionOfApi {
    public static void main(String[] args) {

        int left=1;  // first version is 1
        int right = 10 ;  // assume the max version is 10

        while(left<right){
            System.out.println("===========");
            int mid=(left+right)/2;
            System.out.println("mid = "+mid);
            if(isBadVersion(mid)){
                //    Every time mid satisfies the condition we assign mid to the right.we continue our search on the left side of the search space
                //    to see if we can get a lower value which would still satisfy the condition.
                //    We stop when left is equal to right. At any point of time right is the value (mid) that satisfies condition.
                right=mid;
                System.out.println("right = "+right);
            }else{
                // Anytime mid does not satisfy the condition we keep the right unchanged and assign left as mid + 1.
                // This is because we would be constructing the search space and the condition in such a way that if a mid does not satisfy the condition any value lesser
                // than mid won't either.So, at the end we get the minimum value (mid) for which the condition is satisfied.
                left=mid+1;
                System.out.println("left = "+left);
            }
        }

        System.out.println("the first bad version = "+left);
    }

    private static boolean isBadVersion(int mid) {
        if(mid>8){  // assume all versions above 3 are bad , that is first bad version is 4
            return true;
        }else return false;
    }
}
