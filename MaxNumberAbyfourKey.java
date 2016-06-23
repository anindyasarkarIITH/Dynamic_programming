@ideserve problem no. 19

package bucky;

public class DP {
	public int MaxCount(int n){
		int max=0;
		int i=2;
		if(n<=6){
			return n;
		}
		else{
			while(i<=n-2){
			
			int temp=i * MaxCount(n-(1+i));
			if(temp>max){
				max=temp;
			}
			i+=1;
			}
		}
		return max;
	}
	public static void main(String[] args){
		DP dp=new DP();
		System.out.println(dp.MaxCount(11));

	}
}
