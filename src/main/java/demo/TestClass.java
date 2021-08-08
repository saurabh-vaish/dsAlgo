package demo;/* IMPORTANT: Multiple classes and nested static classes are supported */


//  * uncomment this if you want to read input.
// imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        //  Sample code to perform I/O:
        //  * Use either of these methods for input

        //BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());                 // Reading input from STDIN
        for(int i=0;i<n;i++){
            String sr=s.nextLine();
            String ar[]=sr.split(" ");
            int c = count(Integer.valueOf(ar[0]),Integer.valueOf(ar[1]));
            System.out.println(c);
        }

    }

    public static int count(int a,int s){
        boolean r=true;
        int sum=0;
        int count=0;
        if(s>a)count=0;
        else if(s==a)count=1;
        else if(s==1){
            count++;
            s=s+1;
        }
        int n=0;
        while(r){
            sum+=s;
            if(sum==a){
                r=false;
                
            }
            if(sum>a){
                r=false;
                n++;
                
            }
            if(n==1){
                r=false;
                break;
            }else{
                r=true;
            }
            count++;
        }
        return count;
    }
}
