import java.util.*;
public class Slidingwindow {
    public static void main(String[] args)throws Exception{
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int m=s.nextInt();
        int[] result=maxele(n,a,m);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    static int[] maxele(int n,int[]a,int m){
        if(n<=1)return a;
        Deque<Integer> dq=new LinkedList<>();
        int ans[]=new int[n-m+1];
        int i=0;
        for(;i<m;i++){
            while(!dq.isEmpty() &&a[dq.peekLast()]<=a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(;i<n;i++){
            ans[i-m]=a[dq.peekFirst()];
            while(!dq.isEmpty()&&dq.peekFirst()<=i-m){
                dq.removeFirst();
            }
            while(!dq.isEmpty()&&a[dq.peekLast()]<=a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i-m]=a[dq.peekFirst()];
        return ans;


    }
}
