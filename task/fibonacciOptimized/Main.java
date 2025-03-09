import java.util.Arrays;
import java.util.Random;

class Demo{
    
    public static int fibonacciWithCash(int n,int[]cash){
        if (n==0) return 0;
        if (cash[n] == 0){
            if (n <=1) return 1;
            int fn_1 = fibonacciWithCash(n-1,cash);
            int fn_2 = fibonacciWithCash(n-2,cash);
            cash[n-1] = fn_1;
            cash[n-2] = fn_2;
            return fn_1+ fn_2;
        } else{
            return cash[n];
        }
    }

    public static int fibonacciWithoutCash(int n){
        if(n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciWithoutCash(n-1)+fibonacciWithoutCash(n-2);
    }

    public static void main(String[] args) {

        // calculate fibonacci
        int target = 100;
        int [] cash = new int[target];
        for (int i = 0; i <target ; i++) {
//            System.out.println("fbi("+i+") = "+fibonacciWithCash(i,cash));
            System.out.println("fbi("+i+") = "+fibonacciWithoutCash(i));
        }

    }
}
