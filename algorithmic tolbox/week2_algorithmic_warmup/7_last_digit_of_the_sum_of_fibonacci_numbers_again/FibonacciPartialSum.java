import java.util.*;

public class FibonacciPartialSum {
    static long fib(long n) 
    { 
      
        // The first two Fibonacci numbers 
        long f0 = 0; 
        long f1 = 1; 
  
        // Base case 
        if (n == 0) 
            return 0; 
        if (n == 1) 
            return 1; 
        else
        { 
          
            // Pisano period for % 10 is 60 
            long rem = (n % 60); 
  
            // Checking the remainder 
            if(rem == 0) 
            return 0; 
  
            // The loop will range from 2 to  
            // two terms after the remainder 
            for(long i = 2; i < rem + 3; i++) 
            { 
                long f = (f0 + f1) % 60; 
                f0 = f1; 
                f1 = f; 
            } 
          
            long s = f1 - 1; 
            return s; 
        } 
    } 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        long z=Math.abs(fib(to)-fib(from-1));
        System.out.println(z%10);
    }
}

