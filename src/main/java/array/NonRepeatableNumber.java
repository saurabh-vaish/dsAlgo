package array;

/**
 * @Author saurabh vaish
 * @Date 28-08-2022
 */
public class NonRepeatableNumber {

    // find the non repeatable number
    // O(N)
    public static void main(String[] args) {
        int [] ar = {4,2,1,2,1};

        int x=ar[0];
        for (int i = 1; i < ar.length; i++) {
            x = x ^ ar[i];
        }
        System.out.println(x);
    }
}
