import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions +=(long)merge(a,b,left,ave+1,right);
        return numberOfInversions;
    }
    static int merge(int arr[],int temp[],int left,int mid,int right){
        int i,j,k;
        int invcount=0;
        i=left;
        j=mid;
        k=left;
        while((i<=mid-1)&&(j<=right)){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                invcount=invcount+(mid-i);
            }
        }
        while(i<=mid-1){
            temp[k++]=arr[j++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(i=left;i<=right;i++){
            arr[i]=temp[i];
        }
        return invcount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

