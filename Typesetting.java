package bucky;
import java.util.*;
public class DP {
	public void WW(String input,int m){
		int count=0;
		 ArrayList<String> al = new ArrayList();
		for (String retval: input.split(" ")){
	         al.add(retval);
	      }
		int[][] S=new int[al.size()][al.size()];
		for(int i=0;i<al.size();i++){
			for(int j=i;j<al.size();j++){
				if(i==j){
					S[i][j]=m- al.get(i).length();
				}
				else{
					S[i][j]=S[i][j-1] -1 -al.get(j).length();
					if(S[i][j]<0){
						S[i][j]=100;//Integer.MAX_VALUE;
					}
				}
			}
		}
		int[] best =new int[al.size()];
		for(int i=0;i<al.size();i++){
			if(i==0){
				best[i]=S[i][i] * S[i][i];
			}
			else{
				int min=Integer.MAX_VALUE;
				int temp=S[0][i]* S[0][i];
				if(min>temp){
					min=temp;
				}
				int j=0;
				while(j<i){
					temp=best[j]+ S[j+1][i] * S[j+1][i];
					if(min>temp){
						min=temp;
					}
					j+=1;
				}
				best[i]=min;	
			}
		}
		System.out.println("Total squared cost  ..."+best[al.size()-1]);
		}
	public static void main(String[] args){
		DP dp=new DP();
		String input="Geeks for Geeks presents word wrap problem";
		int Margin=15;
		dp.WW(input, Margin);
		
	}
	
}
