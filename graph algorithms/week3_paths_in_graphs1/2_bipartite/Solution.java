import java.util.*;		
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;
public class Solution{
    private static boolean checkKick(String str,int index){
        if(str.charAt(index+1)=='I'&&str.charAt(index+2)=='C'&&str.charAt(index+3)=='K')return true;
        return false;
        
    }
    
    private static boolean checkStart(String str,int index){
        if(str.charAt(index+1)=='T'&&str.charAt(index+2)=='A'&&str.charAt(index+3)=='R'&&str.charAt(index+4)=='T')return true;
        return false;
        
    }
	static public void main(String args[])throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    for(int tc=0;tc<t;tc++){
	        String str=br.readLine();
	        int len=str.length();
	        StringBuffer strbuffer = new StringBuffer(str);
	        int ind=strbuffer.indexOf("KICK");
			int chkstart=strbuffer.indexOf("START");
			
	        if(ind>(len-6)||ind==-1||chkstart==-1){
	            System.out.println( "Case #"+(tc+1)+": 0");
	            continue;
	        }
	        int kickarr[]=new int[len];
	        boolean startarr[]=new boolean[len];
	        int mind=1;
	        kickarr[0]=1;
	        int sum=0;
	        for(int i=ind+4;i<len-4;i++){
	            if(str.charAt(i)=='K'){
	                if(checkKick(str,i)){
	                    //found kick
	                    kickarr[mind]=kickarr[mind-1]+1;
                        mind++;
                        i=i+3;
						
	                }else continue;
	            }
	            if(str.charAt(i)=='S'){
                    
	                if(checkStart(str,i)){
	                    //found start
	                    startarr[mind]=true;
						sum=sum+kickarr[mind-1];
						i=i+4;
	                }else continue;
	            }
            }
            int ttt=tc+1;
	        System.out.println( "Case #"+(ttt)+": "+sum);
	    }
	}
    
}