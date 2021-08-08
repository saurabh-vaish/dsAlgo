package binarysearch;

/**
 *
 * @Problem  == A conveyor belt has packages that must be shipped from one port to another within K days.
 *              The i-th package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 *              We may not load more weight than the maximum weight capacity of the ship.
 *              Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within K days.
 *
 * @Constraints == The cargo must be shipped in given order in given days
 *                 Weights can be duplicates and no guarantee of sorted order of weights
 *
 * @Solution == The capacity cannot be less than the maximum of all the package weights, because in order to carry each of the weight
 *              the capacity of the ship should be at least equal to the weight of the package which is the heaviest among all the packages.
 *              So the minimum boundary of the search space is the weight of the heaviest package.
 *              The maximum boundary would be very close to the sum of all the package weights.
 *              So Search space = [maxWeight, sum(weights)].
 *
 *              Think about this scenario when weights: [9996, 1, 1, 1, 1] and K = 5. The capacity should be 9996 and sum of all weights is 10,000.
 *              So this happens when we have very skewed weights, i.e, presence of outlier(s).
 *              Also if K = 1 capacity = sum of all package weights.
 *
 *              We are trying to see from the range of search space [maxWeight, sum(weights)] what is the minimum weight that can become the capacity
 *              and still be able to ship all the packages within K days.
 *
 *    ==> this problem is similar as bad versioning problem ,i.e. finding the min value based on external condition
 *
 *  @Complexity  == Binary Search takes O(logM) where M = sum(weights) - maxWeight, and for each of O(logM) steps we call isFeasible() method.
 *                  isFeasible() is O(N) since we iterate over the whole weights array. N = total number of packages.
 *                  Overall time complexity: O(NlogM).
 *
 *
 * @author Saurabh Vaish
 * @Date 30-05-2021
 */
public class CapacityToShipPackageWith_K_Days {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10}; // [3,2,2,4,1,4] , [1,2,3,1,1]
        int k = 5; // 3 , 4
        int mimCapacity = findMinimumCapacityOfShip(weights,k);
        System.out.println("Minimum capacity = "+mimCapacity);
        int sum=0;
        System.out.println("weights per day == ");
        for (int w:weights){
            if(sum+w<=mimCapacity){
                sum+=w;
                System.out.print(w+" ");
            }
            if(sum+w>mimCapacity){
                sum=0;
                System.out.println();
            }
        }
    }

    private static int findMinimumCapacityOfShip(int[] weights, int k) {
        int maxWeight = Integer.MIN_VALUE;
        int sum=0;
        for(int w:weights){
            sum=sum+w;
            maxWeight=Math.max(maxWeight, w);
        }
        // search space = [maxWeight , sum ]
        int left =maxWeight;
        int right = sum;

        while (left<right){
            int mid=(left+right)/2;
            if(isFeasibleForWeight(weights,mid,k)){
                right=mid;
            }else{
                left=mid+1;
            }
        }

        return left;
    }

    private static boolean isFeasibleForWeight(int[] weights, int capacity, int k) {
        int days=1;
        int currSum=0;
        for(int w:weights){
            if((currSum+w)>capacity){
                days++;
                currSum=0;
            }
            currSum+=w;
        }
        return days<=k;
    }

}
