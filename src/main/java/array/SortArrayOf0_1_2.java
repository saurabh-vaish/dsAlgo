package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class SortArrayOf0_1_2 {

    public static void main(String[] args) {

        int [] ar = {2,0,2,1,1,0};

        usingCounters(ar);
        System.out.println(Arrays.toString(ar));

        int [] ar2 = Arrays.copyOf(ar,ar.length);
        usingTwoPointer(ar2);

        System.out.println(Arrays.toString(ar));


    }

    // O(N)
    static void usingCounters(int [] nums){
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        // counting 0 , 1 and 2
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else twos++;
        }

        int index = 0;

        // filling all zeros
        while(zeros > 0){
            nums[index] = 0;
            zeros--;
            index++;
        }

        // all ones
        while(ones > 0){
            nums[index] = 1;
            ones--;
            index++;
        }

        // all twos
        while(twos > 0){
            nums[index] = 2;
            twos--;
            index++;
        }
    }

    static void usingTwoPointer(int [] ar){
        int lo=0;int hi=ar.length-1; int mid=0;

        while (mid<=hi){
            if(ar[mid]==0){
                int temp=ar[lo];
                ar[lo]=ar[mid];
                ar[mid]=temp;
                mid++;
                lo++;
            }else if(ar[mid]==1){
                mid++;
            }else{
                int temp=ar[hi];
                ar[hi]=ar[mid];
                ar[mid]=temp;
                hi--;
            }
        }
    }

}
