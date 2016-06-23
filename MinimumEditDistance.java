package bucky;

public class DP {
	public int MED(String one,String two){
		int nrow=one.length();
		int ncol=two.length();
		int[][] mat=new int[ncol+1][nrow+1];
		for(int i=0;i<=nrow;i++){
			mat[0][i]=i;
		}
		for(int j=0;j<=ncol;j++){
			mat[j][0]=j;
		}
		for(int i=1;i<=ncol;i++){
			for(int j=1;j<=nrow;j++){
				if(one.charAt(j-1)==two.charAt(i-1)){
					mat[i][j]=mat[i-1][j-1];
				}
				else{
					int temp=min(mat[i-1][j-1],mat[i-1][j],mat[i][j-1]);
					mat[i][j]=temp+1;
				}
			}
		}
		return mat[ncol][nrow];
	}
	public int min(int a,int b,int c){
		if(a<b && a<c){
			return a;
		}
		else if(b<a && b<c){
			return b;
		}
		else{
			return c;
		}
	}
	public static void main(String[] args){
		String one="sohail";
		String two="salman";
		DP dp=new DP();
		int result=dp.MED(one, two);
		System.out.println(result);
	}
}
