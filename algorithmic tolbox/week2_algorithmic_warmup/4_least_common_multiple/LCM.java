import java.util.*;

public class LCM {
  private static long lcm(long a, long b) {
    if(a==b){
      return a;
    }
    long lcm,x,i=2;
    if(a>b){
      lcm=a;
    }
    else{
      lcm=b;
    }
    x=lcm;
    while(lcm%a!=0 || lcm%b!=0){
      lcm=x*i;
      i++;
    }
    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(lcm(a, b));
    scanner.close();
  }
}
