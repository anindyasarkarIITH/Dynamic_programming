@ideserve problem no.6

package bucky;
import java.util.*;
public class DP {
	public void SP(String test){
		String store=test;
		String rev="";
		for(int i=test.length()-1;i>=0;i--){
			String temp=test.substring(i,i+1);
			rev+=temp;
		}
		test+=rev;
		int num=PrefixArr(test);
		System.out.println(num);
		String qw="";
		for(int i=0;i<rev.length()-num;i++){
			qw+=rev.substring(i, i+1);
			
		}
		System.out.println(rev.length()-num);
		System.out.println(qw+store);
	}
	public  int PrefixArr(String input){
		int i=0;int j=1;
		int[] arr=new int[input.length()];
		arr[0]=0;
		while(j<input.length()){
			if(input.charAt(i)==input.charAt(j)){
				arr[j]=i+1;
				i+=1;
				j+=1;
			}
			else{
				if(i>0){
				i=arr[i-1];
				}
				else{
					i=0;
					j+=1;
				}
			}
		}
		return (arr[input.length()-1]);
	}

	public static void main(String[] args){
		DP dp=new DP();
		String input="abcdabca";
		String test="sayok";
		dp.PrefixArr(input);
		dp.SP(test);
		
		
		
	}
}
