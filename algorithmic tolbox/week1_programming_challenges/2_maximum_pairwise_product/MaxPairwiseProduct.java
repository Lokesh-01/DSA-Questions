import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;
        long big1=0,big2=0,index=0;
        for (int first = 0; first < n; ++first) {
            if(big1<numbers[first]){
                big1= (int) numbers[first];
                index=first;
            }
        }
        for(int second=0;second<n;++second){
            if(second !=index && big2<numbers[second] ){
                big2=(int)numbers[second];
            }
        }
        max_product=big1*big2;

        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
    }

}
