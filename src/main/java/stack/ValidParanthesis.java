package stack;

/**
 * @Author saurabh vaish
 * @Date 03-01-2023
 */
public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        char[] ar = s.toCharArray();
        java.util.Stack<Character> st = new java.util.Stack<Character>();
        if(ar[0]==')' || ar[0]=='}' || ar[0]==']')return false;
        else st.push(ar[0]);
        for(int i=1;i< ar.length;i++){
            char a=ar[i];
            if(st.empty() && (a==')' || a=='}' || a==']'))return false;
            else if(a==')'){
                if(st.peek()!='(')return false;
                else st.pop();
            }
            else if(a=='}'){
                if(st.peek()!='{')return false;
                else st.pop();
            }
            else if(a==']'){
                if(st.peek()!='[')return false;
                else st.pop();
            }
            else st.push(a);
        }

        return st.empty();
    }
}
