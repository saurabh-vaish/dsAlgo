package general;

/**
 * @Author saurabh vaish
 * @Date 30-08-2022
 */
public class ReverseOf32BitSignedInteger {

    // Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    public static void main(String[] args) {
        int n = 901000;

        System.out.println(reverse(n));

    }


    // O(N) , O(1)
    // we cant take long as it we are not allowed to store 64 bit int
    static int reverse(int n){
        int rev=0,prevRev=0;
        while (n!=0){
            rev = rev*10+n%10;
            int assumedPrevRev = (rev - n%10)/10;  // calculating assumed prev rev as if value cross Integer.Max or Min then it will nto match with prev one

            if(assumedPrevRev!=prevRev)return 0; // if prev is not matched then its got changed then return 0;
            prevRev = rev;
            n/=10;
        }
        return rev;
    }

}
