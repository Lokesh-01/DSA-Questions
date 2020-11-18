import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class BFS {
    private static final int INFINITY=Integer.MAX_VALUE;
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        int[] dist=new int[adj.length];
        Queue<Integer> q=new LinkedList<>();
        for(int v=0;v<adj.length;v++){
            dist[v]=INFINITY;
        }
        dist[s]=0;
        q.add(s);
        while(!q.isEmpty()){
            int v=q.poll();
            for(int w:adj[v]){
                if(dist[w]==INFINITY){
                    q.add(w);
                    dist[w]=dist[v]+1;
                }
            }
        }
        return dist[t]==INFINITY? -1:dist[t];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

