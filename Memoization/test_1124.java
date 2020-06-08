// Problem Link : https://www.acmicpc.net/problem/1124
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1124 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] has_Prime = new int[100001]; // 소인수분해 했을때의 소수 개수, 1개이면 소수
		int i;
		
		for(i = 2 ; i < has_Prime.length ; i++) {
			if(has_Prime[i] == 0) has_Prime[i]++; // 소수인 경우
			for(int j = 2 ; j*i < has_Prime.length ; j++) has_Prime[j*i] = has_Prime[i]+has_Prime[j]; // 곱셈을 통해 소수 개수 Count
		}
		// Memoization
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(i = A ; i <= B ; i++) {
			if(has_Prime[has_Prime[i]]==1) cnt++; // 소수 개수를 소인수분해 했을 때 소수가 1개인 경우
		}
		System.out.print(cnt);
	}
	
}
