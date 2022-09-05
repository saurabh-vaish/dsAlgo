package array;

/**
 * @Author saurabh vaish
 * @Date 28-08-2022
 */
public class MaximumConsicutiveOne {

    public static void main(String[] args) {
        int [] ar = {1,0,1,1,0,1};

        System.out.println(maximum1s(ar));
    }

    // O(N)
    static int maximum1s(int [] ar){
        int count=0;
        int max=0;
        int n= ar.length;

        for (int k = 0; k < n; k++) {
            if(ar[k]==1){
                count++;
                max=Math.max(count,max);
            }else {
                count=0;
            }
        }
        return max;
    }
}
