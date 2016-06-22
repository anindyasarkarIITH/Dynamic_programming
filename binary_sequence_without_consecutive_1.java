@ideserve problem no. 23

package bucky;

public class DP {
	public int fib(int n){
		if(n==1){
			return 0;
		}
		else if(n==2){
			return 1;
		}
		else{
			return (fib(n-1)+fib(n-2));
		}
	}
	public int Count(int n){
		return fib(n+3);
	}
	public static void main(String[] args){
		int[] input={8,10,10,2};
		DP dp=new DP();
		int t=dp.Count(6);
		System.out.println(t);
	}
}
