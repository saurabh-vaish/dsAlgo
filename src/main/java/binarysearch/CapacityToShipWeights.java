package binarysearch;

/**
 * @Link = https://www.codingninjas.com/studio/problems/capacity-to-ship-packages-within-d-days_1229379
 *
 * You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within d days.
 * . The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
 * Find out the least-weight capacity so that you can ship all the packages within 'd' days.
 *
 * @Author saurabh vaish
 * @Date 06-07-2023
 */
public class CapacityToShipWeights {

    // O(max * n) , O(1)
    // need to find minimum no of days in which all the weight will be shipped till d days
    // here we can assume , we can take at least max of array as lower bound , sum of array as upper range
    // because max elem also need to be on ship and sum of elem is the max weight that we can ship in one day
    // so we have range then we can do binary search in range and found the least weight of ship
    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.

        int max = Integer.MIN_VALUE;

        int sum=0;
        for(int ar:weights){
            max = Math.max(max,ar);
            sum+=ar;
        }


        int low = max , high = sum;

        // binary search on range
        while(low<=high){
            int mid = low + (high-low)/2;

            if(shipCap(weights, mid)<=d){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return low;

    }

    // O(n)
    private static int shipCap(int[] weights, int mid) {
        int sum=0;
        int day=1;
        for(int a:weights){

            if((sum + a)>mid){  // if the sum of load and next day load is more than capacity means that day cap is completed so increase day
                day = day+1;
                sum=a;  // reset cap to load for next day
            }else{
                sum +=a;
            }

        }

        return day;
    }

    public static void main(String[] args) {
        int ar [] = {5,4,5,2,3,4,5,6};

        System.out.println(leastWeightCapacity(ar,5));
    }

}
