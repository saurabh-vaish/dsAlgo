package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 27-08-2022
 */
public class MissingAndDuplicateNumber {

    public static void main(String[] args) {
        int [] ar = {3,1,2,5,3};

        int [] res = missingAndDuplicate(ar);

        System.out.println(Arrays.toString(res));
    }

    // O(N) + O(N) == O(N)
    // O(N)
    static int [] missingAndDuplicate(int [] ar){
        int n=ar.length;
        int [] res = new int[2];

        int [] count = new int[1000]; // assume array elements are from 0 to 1000

        for (int i = 0; i < n; i++) {
            count[ar[i]]++;     // mapping array element as index to count array
        }

        int index=0;
        for (int i = 1; i <= n; i++) { // will traverse from 1 to n as we know array contains element from range 1 to arr.length
            if(count[i]==0 || count[i]>1){      // if at i count is 0 means its the missing number and if its greater than 1 means duplicate
                res[index++]=ar[i];
                if(index==2)break;
            }
        }

        return res;
    }
}
