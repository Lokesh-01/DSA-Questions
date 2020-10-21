import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A,int[][]dp,int n,int w) {
        //write your code here
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 &&j>0){
                    dp[i][j]=0;
                }
                else if(j==0){
                    dp[i][j]=1;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j-A[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            sum=sum+A[i];
        }
        if(sum%3!=0){
            System.out.println(0);
        }
        else{
            int[][] dp=new int[n+1][(sum/3)+1];
            for(int[] row:dp){
                Arrays.fill(row,-1);
            }
            int count=partition3(A,dp,n,(sum/3));
            if(count>=3){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}

