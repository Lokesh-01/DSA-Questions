import java.util.*;
public class FibonacciHuge {
    private static long get_pisano_period(long m){
        long a=0,b=1,c=a+b,index=0;
        for(long i=0;i<m*m;i++){
            c=(a+b)%m;
            a=b;
            b=c;
            if(a==0 && b==1){
                index=i+1;
                break;
            }
        }
        return index;
    }
    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;
        long pisanoperiod=get_pisano_period(m);
        long remainder= n % pisanoperiod;
        long previous = 0;
        long current  = 1;
        long res=remainder;
        for (long i = 1; i < remainder; i++) {
            res=(previous+current)%m;
            previous=current;
            current=res;
        }
        return res % m;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

