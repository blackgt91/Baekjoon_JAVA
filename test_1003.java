// Problem Link : https://www.acmicpc.net/problem/1003
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test_1003 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] fibonacci = new int[42]; // 0의 개수
		int N;
		fibonacci[0] = 1; fibonacci[1] = 0; // 1 0 -> 0 1 -> 1 1 -> 1 2 -> 2 3 ... : N(N>0)에서의 0의 개수 : N-1에서의 인덱스의 1의 개수
		for(int i = 2 ; i <= 41 ; i++) fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			sb.append(fibonacci[N] + " " + fibonacci[N+1] + "\n");
		}
		br.close();
		System.out.println(sb.toString());
	}
}