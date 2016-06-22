@ideserve problem no. 24

package bucky;

public class DP {
	public int Count(String input){
		int sz=input.length();
		int[] arr=new int[sz];
		arr[0]=1;
		int a=input.charAt(1);
		int b=input.charAt(0);
		int num=(10*(b-48)) + (a-48);
		if(num<=26){
			arr[1]=2;
		}
		else{
			arr[1]=1;
		}
		for(int i=2;i<sz;i++){
			int c=input.charAt(i);
			int d=input.charAt(i-1);
			int val=(10*(d-48)) + (c-48);
			if(val<=26){
				arr[i]=arr[i-1]+arr[i-2];
			}
			else{
				arr[i]=arr[i-1];
			}
		}
		return arr[sz-1];
	}
	public static void main(String[] args){
		String input="1221232321";
		DP dp=new DP();
		int result=dp.Count(input);
		System.out.println(result);
	}
}
