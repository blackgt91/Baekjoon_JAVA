// Problem Link : https://www.acmicpc.net/problem/9251

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		int[][] lcs = new int[input1.length+1][input2.length+1];
		
		for(int i = 0 ; i < input1.length ; i++) {
			for(int j = 0 ; j < input2.length ; j++) {
				if(input1[i] == input2[j]) lcs[i+1][j+1] = lcs[i][j] + 1;
				else lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
			}
		}
		System.out.println(lcs[input1.length][input2.length]);
		
	}

}
 
