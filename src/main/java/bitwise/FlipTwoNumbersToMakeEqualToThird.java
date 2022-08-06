package bitwise;

/**
 * @Author saurabh vaish
 * @Date 05-08-2022
 */
public class FlipTwoNumbersToMakeEqualToThird {

    // write a program with minimum flips to make the two bits’ OR operation equal a number.
    public static void main(String[] args) {
//        int a=2, b=6 , c=5;  //3
        int a=8, b=3 , c=5;  //3   , 1000 , 0011 , 0101

        System.out.println(countNoOfFlips(a,b,c));
    }

    // we will loop to 32 times as integer contains 32 bits
    // we will take lsb of each number and check if its same or not
    // if not then check if lsb of c is 0 , yes then increase count +2 as we have to make both a,b 's lsb to b to make equal to 0
    // if not then increase count 1 as by making any ones a , b lsb to 1 we can get 1
    private static int countNoOfFlips(int a,int b,int c){
        int count=0;
        for (int i = 0; i < 32; i++) {
            int al = (a>>i) & 1 ;  // i'th times as we need to check i'th bit of each number
            int bl= (b>>i) & 1;
            int cl= (c>>i) & 1;

            if((al | bl) != cl){ // if lsb bits of a & b are not equal to c
                if(cl==0){
                    if(al==1 && bl==1){
                        count=count+2;
                    }else{
                        count=count+1;
                    }
                }else {
                    count++;
                }
            }
        }

        return count;
    }

}
