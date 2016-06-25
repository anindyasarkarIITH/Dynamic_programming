package bucky;

public class DP {
	public int GM(int[][] input){
		int max=Integer.MIN_VALUE;
		int[][] arr=new int[input.length][input[0].length];
		for(int i=0;i<input.length;i++){
			arr[i][0]=input[i][0];
		}
		for(int j=1;j<input[0].length;j++){
			for(int i=0;i<input.length;i++){
				if(i==0){
					arr[i][j]=Max(arr[i][j-1],arr[i+1][j-1],Integer.MIN_VALUE) + input[i][j];
				}
				else if(i==input.length-1){
					arr[i][j]=Max(arr[i-1][j-1],arr[i][j-1],Integer.MIN_VALUE)+input[i][j];
				}
				else{
					arr[i][j]=Max(arr[i-1][j-1],arr[i][j-1],arr[i+1][j-1])+ input[i][j];
				}
			}
		}
		for(int i=0;i<input.length;i++){
			if(arr[i][input[0].length-1]>max){
				max=arr[i][input[0].length-1];
			}
		}
		return max;
	}
	public int Max(int a,int b,int c){
		if(a>=b && a>=c){
			return a;
		}
		else if(b>=c && b>=a){
			return b;
		}
		else{
			return c;
		}
	}
	public static void main(String[] args){
		DP dp=new DP();
		int[][] input=new int[4][4];
		input[0][0]=2;input[0][1]=8;input[0][2]=9;input[0][3]=7;
		input[1][0]=5;input[1][1]=8;input[1][2]=1;input[1][3]=7;
		input[2][0]=5;input[2][1]=7;input[2][2]=3;input[2][3]=5;
		input[3][0]=4;input[3][1]=8;input[3][2]=17;input[3][3]=4;
		int result=dp.GM(input);
		System.out.println(result);

	}
}
