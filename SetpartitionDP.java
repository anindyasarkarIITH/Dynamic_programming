package bucky;

public class DP {
	public boolean Setpart(int[] input){
		int sum=0;
		int flag=0;
		for(int i=0;i<input.length;i++){
			sum+=input[i];
		}
		if(sum%2!=0){
			return false;
		}
		boolean[][] mat=new boolean[sum/2 + 1][input.length+1];
		for(int j=0;j<=input.length;j++){
			mat[0][j]=true;
		}
		for(int i=1;i<=sum/2;i++){
			mat[i][0]=false;
		}
		
		for(int j=1;j<=input.length;j++){
			for(int i=0;i<=sum/2;i++){
				if(mat[i][j-1]==true){
					mat[i][j]=true;
					if(i+input[j-1]<=sum/2){
						mat[i+input[j-1]][j]=true;
						
					}
				}
			}
		}
		
		return mat[sum/2][input.length];
	}
	public static void main(String[] args){
		int[] input={8,10,10,2};
		DP dp=new DP();
		boolean res=dp.Setpart(input);
		System.out.println(res);
		
	}
}
