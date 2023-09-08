package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codingninjas.com/studio/problems/longest-successive-elements_6811740
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class LongestSuccessiveElement {

    public static void main(String[] args) {
        int [] ar = {5,8,3,2,1,4};

//        System.out.println(longestSuccessiveUsingSorting(ar));
        System.out.println(longestSuccessiveUsingSet(ar));
    }

    // complexity = O(NlogN) + O(N)
    public static int longestSuccessiveUsingSorting(int []a) {
        // Write your code here.

        Arrays.sort(a);
        int max = 1;
        int cnt = 1;
        int elem = a[0];
        for (int i = 0; i < a.length-1; i++) {
            if(a[i+1]-elem==1){
                cnt+=1;
            }else{
                cnt=1;
            }

            elem=a[i+1];
            max = Math.max(max,cnt);
        }

        return max;
    }

    // complexity = O(N) + (N * 2) = O(3N) , space = O(N)
    public static int longestSuccessiveUsingSet(int []ar) {

        Set<Integer> set = new HashSet<>();

        int max = 1;
        for (int a:ar)set.add(a);

        for (int i = 0; i < ar.length; i++) {
            if(!set.contains(ar[i]-1)){

                int cnt = 1;
                int x = ar[i];
                while (set.contains(x+1)){
                    cnt++;
                    x = x+1;
                }

                max = Math.max(max,cnt);
            }
        }

        return max;
    }

}
