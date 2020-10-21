import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, double[] values, double[] weights,int len) {
        double value = 0.0000;
        double c=(double)capacity;
        for(int s=0;s<len;s++){
            if(c==0.00){
                return value;
            }
            int index=max_index(values,weights);
            double min=Math.min(c,weights[index]);
            value=value+(min*(values[index]/weights[index]));
            c=c-min;
            if(weights[index]==min){
                weights[index]=1;
                values[index]=0;
            }
            else{
                weights[index]=weights[index]-min;
            }
            
        }
            
        return value;
    }
    static int max_index(double values[],double weights[]){
        int index=0;
        double max=0.0000;
        for(int i=0;i<values.length;i++){
            double frac = (double)values[i]/(double)weights[i];
            if(frac>max){
                index=i;
                max=frac;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }
        System.out.format("%.4f",getOptimalValue(capacity, values, weights,n));
    }
} 
