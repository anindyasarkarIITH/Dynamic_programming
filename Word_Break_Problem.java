@ideserve problem no.3

package bucky;
import java.util.*;
public class DP {
	public void WBP(String input){
	Hashtable<String,Integer> dictionary = new Hashtable();
	dictionary.put("DIPAYAN",1);dictionary.put("IIT",2);
	dictionary.put("IN",3);dictionary.put("M",4);
	boolean[][] mat=new boolean[input.length()][input.length()];
	for(int i=0;i<input.length();i++){
	        char temp=input.charAt(i);
	        String s =String.valueOf(temp);
	        if(dictionary.containsKey(s)){
	        	mat[i][i]=true;
	        }
	}
	for(int l=1;l<input.length();l++){
	for(int i=0;i<input.length()-l;i++){
		String temp=input.substring(i, i+l+1);
		int val=l;
		int bk=1;
		int iter=0;
		while(bk<=l){
        if(dictionary.containsKey(temp) || (dictionary.containsKey(temp.substring(0, bk)) && dictionary.containsKey(temp.substring(bk,val+1))) ){
        	mat[i][i+l]=true;
        }
        bk+=1;
		}
		while(iter<l){
        if(mat[i][i+iter] && mat[i+iter+1][i+l]){
        	mat[i][i+l]=true;
        }
        iter+=1;
		}
	}
	}
	System.out.println(mat[0][input.length()-1]);
	}
	public static void main(String[] args){
		DP dp=new DP();
		String input="DIPAYANINIITM";
		dp.WBP(input);
	}
}
