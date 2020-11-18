import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static final int red=1;
    private static final int blue=2;
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
        int[] color =new int[adj.length];
        Arrays.fill(color, -1);
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        color[0]=red;
        while(!q.isEmpty()){
            int v=q.poll();
            for(int w:adj[v]){
                if(color[w]==-1){
                    q.add(w);
                    color[w]=(color[v]==red)?blue:red;
                }else if(color[v]==color[w]){
                    return 0;
                }
            }
        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

