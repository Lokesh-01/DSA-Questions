import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int[] x=new int[stops.length+2];
        x[0]=0;
        x[stops.length+1]=dist;
        for(int a=1;a<stops.length+1;a++){
            x[a]=stops[a-1];
        }
        int numrefills=0;
        int currentrefills=0;
        int n=(x.length-2);
        while(currentrefills <= (n)){
            int lastrefill=currentrefills;
            while(currentrefills<=(n) && x[currentrefills+1]-x[lastrefill]<=tank){
                currentrefills=currentrefills+1;
            }
            if(lastrefill==currentrefills){
                return -1;
            }
            else if(currentrefills<=(n)){
                numrefills=numrefills+1;
            }
        }
        return numrefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
