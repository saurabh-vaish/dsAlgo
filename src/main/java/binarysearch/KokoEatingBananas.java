package binarysearch;

/**
 * @Problem ==  There are N piles of bananas, the i-th pile has piles[i] bananas. The guards have gone and will come back in H hours.
 *              Koko can decide her bananas-per-hour eating speed of K. Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
 *              If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 *              Return the minimum integer K such that she can eat all the bananas within H hours.
 *
 * @Solution == Koko needs to eat at least Math.ceil(total number of bananas / H) bananas per hour in order to eat all bananas in H hours.
 *              If H = 1 the Koko would have to eat all the bananas in one hour.
 *              Therefore Search Space = [(total number of bananas - 1 / H) + 1, total number of bananas]
 *
 * @Complexity == Binary Search takes O(logM) where M = total number of bananas - (total number of bananas / H).
 *                isFeasible() is O(N) where N = number of piles
 *
 *                Since we are calling isFeasible() method for each of O(logM) iterations the overall time complexity is O(NlogM).
 *
 *
 * @author Saurabh Vaish
 * @Date 30-05-2021
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles={30,11,23,4,20};
        int hours = 6; //5
        long num = getNumberOfBananasPerHour(piles,hours);
        System.out.println("minimum no = "+num);
    }

    private static long getNumberOfBananasPerHour(int[] piles, int hours) {
        long sum=0;
        for(int banana:piles){
            sum+=banana;
        }
        long left = ((sum-1)/hours)+1; // least value that she needs to eat banana per hour
        long right = sum;
        
        while(left<right){
            long mid=(left+right)/2;
            if(isFeasible(piles,hours,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private static boolean isFeasible(int[] piles, int hours, long mid) {
        int h=0;
        for(int b:piles){
            h+=((b-1)/mid)+1;
            if(h>hours){  // if calculated hours are bigger than given hours return false
                return false;
            }
        }
        return h<=hours;
    }
}
