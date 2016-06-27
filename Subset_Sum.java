package bucky;
import java.util.*;
public class DP {
	public boolean SSP(int[] input,int sum){
		boolean[][] arr=new boolean[input.length][sum+1];
		for(int i=0;i<input.length;i++){
			arr[i][0]=true;
		}
		for(int j=1;j<sum+1;j++){
			if(input[0]==j){
				arr[0][j]=true;
			}
			else{
				arr[0][j]=false;
			}
		}
		for(int i=1;i<input.length;i++){
			for(int j=1;j<sum+1;j++){
				if(j>=input[i]){
				if(arr[i-1][j]== true || arr[i-1][j-input[i]]){
					arr[i][j]=true;
				}
				}
				else {
					arr[i][j]=arr[i-1][j];
				}
			}
		}
		return arr[input.length-1][sum];
	}
	public static void main(String[] args){
		DP dp=new DP();
		int[] input={1,3,9,2,7};
		int sum=11;
		boolean result=dp.SSP(input,sum);
		System.out.println(result);
	}
}
