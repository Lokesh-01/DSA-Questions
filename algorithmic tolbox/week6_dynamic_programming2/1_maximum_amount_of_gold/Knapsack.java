import java.util.*;

public class Knapsack {
    static int optimalWeight(int n,int W, int[] wt,int[][] dp) {
        if(n==0||W==0){
          return 0;
        }
        if(dp[n][W]!= -1){
          return dp[n][W];
        }
        if(wt[n-1]<=W){
          return dp[n][W]= Math.max(wt[n-1]+optimalWeight(n-1,W-wt[n-1],wt,dp),optimalWeight(n-1,W,wt,dp));
        }
        else if(wt[n-1]>W){
          return dp[n][W]=optimalWeight(n-1,W,wt,dp);
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
        }
        int dp[][]=new int[n+1][W+1];
        for(int[] row:dp){
          Arrays.fill(row,-1);
        }
        System.out.println(optimalWeight(n,W, wt,dp));
    }
}

