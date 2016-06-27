@ideserve problem 10

package bucky;
import java.util.*;
public class DP {
	public int MCP(int[][] input){
		int[][] arr=new int[input.length][input[0].length];
		arr[0][0]=input[0][0];
		for(int i=1;i<input.length;i++){
			arr[i][0]=arr[i-1][0]+input[i][0];
		}
		for(int j=1;j<input[0].length;j++){
			arr[0][j]=arr[0][j-1]+input[0][j];
		}
		for(int i=1;i<input.length;i++){
			for(int j=1;j<input[0].length;j++){
				arr[i][j]=Min(arr[i][j-1],arr[i-1][j-1],arr[i-1][j]) + input[i][j];
			}
		}
		return arr[input.length-1][input[0].length-1];
			}
	public int Min(int a,int b,int c){
		if (a<=b && a<=c){
			return a;
		}
		else if(b<=c && b<=a){
			return b;
		}
		else{
			return c;
		}
		
	}

	public static void main(String[] args){
		DP dp=new DP();
		int[][] input=new int[4][3];
		input[0][0]=3;input[0][1]=2;input[0][2]=8;
		input[1][0]=1;input[1][1]=0;input[1][2]=7;
		input[2][0]=0;input[2][1]=5;input[2][2]=2;
		input[3][0]=6;input[3][1]=4;input[3][2]=3;
		int result=dp.MCP(input);
		System.out.println(result);
		
		
	}
}
