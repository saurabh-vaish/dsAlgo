package pattern;

import java.util.ArrayList;

/**
 * @Author saurabh vaish
 * @Date 06-05-2022
 */
public class Pattern {

    public static void main(String[] args) {

//        pattern1();
//        System.out.println("-----------------------");
//        pattern2();
//        System.out.println("-----------------------");
//        pattern3();
//        System.out.println("-----------------------");
//        pattern4();
//        System.out.println("-----------------------");
//        pattern5();
//        System.out.println("-----------------------");
//        pattern6();
//        System.out.println("-----------------------");
//        pattern7();
//        System.out.println("-----------------------");
//        pattern8();
//        System.out.println("-----------------------");
//        pattern9();
//        System.out.println("-----------------------");
//        pattern10();
//        System.out.println("-----------------------");
//        pattern11();
//        System.out.println("-----------------------");
//        pattern12();
//        System.out.println("-----------------------");
//        pattern13();
//        System.out.println("-----------------------");
//        pattern14();
//        System.out.println("-----------------------");
//        pattern15();
//        System.out.println("-----------------------");
//        pattern16();
//        System.out.println("-----------------------");
//        pattern17A();
//        System.out.println("-----------------------");
//        pattern17B();
//        System.out.println("-----------------------");
//        pattern18();
//        System.out.println("-----------------------");
//        pattern19();
//        System.out.println("-----------------------");
//        pattern20();
//        System.out.println("-----------------------");
//        pattern22();
//        System.out.println("-----------------------");
//        pattern23();
//        System.out.println("-----------------------");
//        pattern24();
//        System.out.println("-----------------------");
//        pattern25();
//        System.out.println("-----------------------");
//        pattern26();
//        System.out.println("-----------------------");
//        pattern27();
//        System.out.println("-----------------------");
//        pattern28();
//        System.out.println("-----------------------");
//        pattern29();
//        System.out.println("-----------------------");
//        pattern31();
//        System.out.println("-----------------------");
//        pattern32();
//        System.out.println("-----------------------");
//        pattern33();
        System.out.println("-----------------------");
        pattern32_2();
    }

    //1   *****
    //    *****
    //    *****
    //    *****
    //    *****
    public static void pattern1(){
        int row =5;
        int col=5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //    *
    //    **
    //    ***
    //    ****
    //    *****

    public static void pattern2(){
        int row =5;
        int col=5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //    *****
    //    ****
    //    ***
    //    **
    //    *
    public static void pattern3(){
        int row =5;
        int col=5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //    1
    //    1 2
    //    1 2 3
    //    1 2 3 4
    //    1 2 3 4 5
    public static void pattern4(){
        int row =5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }


    //    *
    //    **
    //    ***
    //    ****
    //    *****
    //    ****
    //    ***
    //    **
    //    *
    public static void pattern5(){
        int n=5;
        int row =n*2;
        for (int i = 1; i < row; i++) {
            int col=i>n?row-i:i; // as row increasing more than n , subtract from row
            for (int j = 1; j <=col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //         *
    //        **
    //       ***
    //      ****
    //     *****
    public static void pattern6(){
        int n=5;
        int row =n;
        for (int i = 1; i <= row; i++) {
            int space=n-i;
            for (int j = 1; j <=space ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //     *****
    //      ****
    //       ***
    //        **
    //         *
    public static void pattern7(){
        int n=5;
        int row =n;
        for (int i = 0; i < row; i++) {
            int space=i;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < row-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //        *
    //       ***
    //      *****
    //     *******
    //    *********
    public static void pattern8(){
        int n=5;
        int row =n;
//        for (int i = 1; i <= row; i++) {
//            int space=row-i;
//            for (int j = 0; j <space ; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            for (int j = 1; j <= i-1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < row; i++) {
            int col = i*2+1;
            int space=row-i;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //    *********
    //     *******
    //      *****
    //       ***
    //        *

    public static void pattern9(){
        int n=5;
        int row =n;
        for (int i = 1; i <= row; i++) {
            int col = 2*(row-i)+1;
            int space=i-1;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //         *
    //        * *
    //       * * *
    //      * * * *
    //     * * * * *
    public static void pattern10(){
        int n=5;
        int row =n;
        for (int i = 1; i <= row; i++) {
            int col = i;
            int space=row-i;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //     * * * * *
    //      * * * *
    //       * * *
    //        * *
    //         *

    public static void pattern11(){
        int n=5;
        int row =n;
        for (int i = 0; i < row; i++) {
            int col = row-i;
            int space=i;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //     * * * * *
    //      * * * *
    //       * * *
    //        * *
    //         *
    //         *
    //        * *
    //       * * *
    //      * * * *
    //     * * * * *
    public static void pattern12(){
        int n=5;
        int row =2*n;
        for (int i = 1; i <= row; i++) {
            int col =i>n?i-n: n-i+1;
            int space=Math.abs(col-n);
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //         *
    //        * *
    //       *   *
    //      *     *
    //     *********

    public static void pattern13(){
        int n=5;
        int row=n;
        for (int i = 1; i <=row ; i++) {
            int space=row-i;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }
            int col=(2*i)-1;
            for (int j = 0; j < col; j++) {
             if(i==0 || i==row){
                 System.out.print("*");
             }else {
                 if (j == 0 || j == col - 1) {
                     System.out.print("*");
                 } else {
                     System.out.print(" ");
                 }
             }
            }
            System.out.println();
        }
    }

    //     *********
    //      *     *
    //       *   *
    //        * *
    //         *
    public static void pattern14(){
        int n=5;
        int row=5;
        for (int i = row; i >=1; i--) {
            int space = n-i;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            int col=(2*i)-1;
            for (int j = 0; j < col; j++) {
                if(i==1 || i==row){
                    System.out.print("*");
                }else {
                    if (j == 0 || j == col - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    //         *
    //        * *
    //       *   *
    //      *     *
    //     *       *
    //      *     *
    //       *   *
    //        * *
    //         *

    public static void pattern15(){
        int n=5;
        int row=2*n;
        for (int i = 1; i <= row; i++) {
            int col=i<n?(2*i)-1:2*(row-i)-1;
            int space = Math.abs(n-i);
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < col; j++) {
                if (j == 0 || j == col - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //              1
    //            1   1
    //          1   2   1
    //        1   3   3   1
    //      1   4   6   4   1

    public static void pattern16(){ // not completed
        int n=5;
        int row=n;
        int count=1;
        /*
             // using 11 square and logic

        for (int i = 1; i <= row; i++) {

            int space=2*(row-i);
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            int col=(count+"").length();

            int c =count;
            for (int j = 1; j <=col; j++) {
                System.out.print(c%10+"   ");
                c = c/10;
            }
            count=count*11;

            System.out.println();
        }*/


        for (int i = 0; i < row; i++) {

            int space=2*(row-i-1);
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            // using logic middle no is sum of upper two index
            for (int j = 0; j <=i; j++) {
                if(i==1 || j==0){
                    count=1;
                }else{
                    count = count*(i-j+1)/j;
                }
                System.out.print(count+"   ");
            }

            System.out.println();
        }
    }
    
    //         1
    //        212
    //       32123
    //      4321234
    public static void pattern17A(){
        int n=4;
        int row=n;
        for (int i = 1; i <=row; i++) {
            int space=row-i;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            // till middle
            for (int j = i; j >=1 ; j--) {
                System.out.print(j);
            }

            // middle to end
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //         1
    //        212
    //       32123
    //      4321234
    //       32123
    //        212
    //         1
    public static void pattern17B(){
        int n=4;
        int row=2*n;
        for (int i = 1; i <=row; i++) {
            int space=i<n?n-i:i-n;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            int col=i<n?i:row-i;
            // till middle
            for (int j = col; j >=1 ; j--) {
                System.out.print(j);
            }

            // middle to end
            for (int j = 2; j <= col; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


    //      **********
    //      ****  ****
    //      ***    ***
    //      **      **
    //      *        *
    //      *        *
    //      **      **
    //      ***    ***
    //      ****  ****
    //      **********


    public static void pattern18(){
        int n=5;
        int row=2*n;
        for (int i = 0; i <=row; i++) {
            int space=i<n?n-i:i-n;
            for (int j = 0; j < space; j++) {
                System.out.print("*");
            }
            if(i==5)continue;
            int col=i<n?2*i:2*(row-i);
            for (int j = 0; j <col ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < space; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //       *        *
    //       **      **
    //       ***    ***
    //       ****  ****
    //       **********
    //       ****  ****
    //       ***    ***
    //       **      **
    //       *        *
    public static void pattern19(){
        int n=5;
        int row=2*n;
        for (int i = 0; i < row; i++) {
            int col=i<n?i:row-i;
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }

            int space=row-2*col;
            for (int j = 0; j <space ; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //       ****
    //       *  *
    //       *  *
    //       *  *
    //       ****

    public static void pattern20(){
        int n=5;
        int row=n;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <n; j++) {
                if(i==1 || i==n || j==1 || j==n-1){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //       1
    //       2  3
    //       4  5  6
    //       7  8  9  10
    //       11 12 13 14 15
    public static void pattern21(){
        int n=5;
        int row=5;
        int c=1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=i ; j++,c++) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }


    //       1
    //       0 1
    //       1 0 1
    //       0 1 0 1
    //       1 0 1 0 1
    public static void pattern22(){
        int n=5;
        int row=5;
        int c=1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <i ; j++,c++) {
                System.out.print((i+j)%2+" ");
            }
            System.out.println();
        }
    }


    //           *      *
    //         *   *  *   *
    //       *      *      *

    public static void pattern23(){

    }


    //*         *
    //**       **
    //* *     * *
    //*  *   *  *
    //*   * *   *
    //*    *    *
    //*   * *   *
    //*  *   *  *
    //* *     * *
    //**       **
    //*         *
    public static void pattern24(){
        int n=5;
        int row=2*n;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <row ; j++) {
                if(j==0 || j==row-1 || j==i || j==row-i-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    //          *****
    //         *   *
    //        *   *
    //       *   *
    //      *****

    public static void pattern25(){
        int n=5;
        int row=n;
        for (int i = 1; i <= row; i++) {
            int space=n-i;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < row; j++) {
                if(j==0 || i==1 || i==row || j==row-1)
                System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }


    //      1 1 1 1 1 1
    //      2 2 2 2 2
    //      3 3 3 3
    //      4 4 4
    //      5 5
    //      6
    public static void pattern26(){
        int n=6;
        int row=n;
        for (int i = 0; i < row; i++) {
            for (int j = row-i; j >=1 ; j--) {
                System.out.print(i+1+" ");
            }
            System.out.println();
        }
    }


    //         *
    //        * *
    //       * * *
    //      * * * *
    //     * * * * *
    //      * * * *
    //       * * *
    //        * *
    //         *
    public static void pattern27(){
        int n=5;
        int row=2*n;
        for (int i = 1; i <= row; i++) {
            int space=i<n?n-i:i-n;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            int col=i<n?i:row-i;
            for (int j = 0; j<col ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    //            1
    //          2 1 2
    //        3 2 1 2 3
    //      4 3 2 1 2 3 4
    //    5 4 3 2 1 2 3 4 5
    public static void pattern28(){
        int n=5;
        int row=n;
        for (int i = 1; i <= row; i++) {
            int space=n-i;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            int col = 2*i-1;
            for (int j = col; j>=1 ; j--) {
                System.out.print(Math.abs(j-i)+1);
            }
            System.out.println();
        }
    }


    //       a
    //       B c
    //       D e F
    //       g H i J
    //       k L m N o
    public static void pattern29(){
        int n=5;
        char ch= 'a';
        int c=1;
        for (int i = 1; i <= n; i++) {
            for (char j = 1; j <=i ; j++) {
                int d = (c)%2==0?0:1;
                if(d==1){
                    System.out.print(ch +" ");
                }else {
                    System.out.print((char)(ch -32));
                    System.out.print(" ");
                }
                ch++;
                c++;
            }
            System.out.println();
        }
    }

    //       E
    //       D E
    //       C D E
    //       B C D E
    //       A B C D E
    public static void pattern30(){
        int n=5;
        char ch= 'a';
        int c=1;
        for (int i = 'E'; i >= 'A'; i--) {
            for (char j = 'E'; j >=i ; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //       E D C B A
    //       D C B A
    //       C B A
    //       B A
    //       A
    public static void pattern31(){
        int n=5;
        char ch= 'a';
        int c=1;
        for (int i = 65; i <70; i++) {
            for (char j = 'E'; j >=i ; j--) {
                System.out.print((char)Math.abs(j-i+65)+" ");
            }
            System.out.println();
        }
    }


    //         4 4 4 4 4 4 4
    //         4 3 3 3 3 3 4
    //         4 3 2 2 2 3 4
    //         4 3 2 1 2 3 4
    //         4 3 2 2 2 3 4
    //         4 3 3 3 3 3 4
    //         4 4 4 4 4 4 4
    public static void pattern32(){
        int n=4;
        int row=2*n;
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < row; j++) {
                int c =n- Math.min(Math.min(i,j),Math.min(row-i,row-j)) + 1;
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    //4 3 2 1 2 3 4
    //3 3 2 1 2 3 3
    //2 2 2 1 2 2 2
    //1 1 1 1 1 1 1
    //2 2 2 1 2 2 2
    //3 3 2 1 2 3 3
    //4 3 2 1 2 3 4
    public static void pattern32_2(){
        int n=4;
        int row=2*n;
        for (int i = 1; i <row; i++) {
            for (int j = 1; j < row; j++) {
                int k=i,l=j;
                if(j>n)l=row-j;
                if(i>n)k=row-i;
                int c =n- Math.max(k,l) + 1;
                System.out.print(c+" ");
            }
            System.out.println();
        }
        /**
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                int c =n- Math.max(i,j) + 1;
                list.add(c);
            }
            ArrayList<Integer> flist = new ArrayList<>(list);
            for (int j = list.size()-2; j >=0 ; j--) {
                flist.add(list.get(j));
            }
            temp.add(flist);
        }
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>(temp);
//        all.add(temp);
        for (int j = temp.size()-2; j >=0 ; j--) {
            all.add(temp.get(j));
        }
        all.forEach(t->{
            t.forEach(l-> System.out.print(l+" "));
            System.out.println();
        });
         **/
    }


    //       1      1
    //       12    21
    //       123  321
    //       12344321
    public static void pattern33(){
        int n=4;
        int row=n;
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            int space=2*(n-i);
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


    //      1 2 3 4  17 18 19 20
    //        5 6 7  14 15 16
    //          8 9  12 13
    //            10 11
    public static void pattern34(){ // not working
        int n=4;
        int row=n;
        int c=1;
        for (int i = 0; i <row; i++) {
            int space=2*i;
            int d=17-n-i;
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n-i; j++) {
                System.out.print(c++ +" ");
            }
            for (int j = 0; j < n-i; j++) {
                System.out.print(" "+d++);
            }
            System.out.println();
        }
    }






}
