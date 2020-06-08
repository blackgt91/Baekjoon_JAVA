// Problem Link : https://www.acmicpc.net/problem/1010
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1010 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] count_Case = new int[30][30];
		int i,start,end; // 출발지점 수가 도착지점 수보다 적은 것으로 가정
		for(i = 0 ; i < 30 ; i++) count_Case[0][i] = 1; // 출발지점이 없는 경우는 존재하지 않지만 start가 1인 경우를 Count하기 위해 1로 초기화
		for(start = 1 ; start < 30 ; start++) {
			for(end = start ; end < 30 ; end++) {
				for(i = 0 ; i <= end-start ; i++) {
					count_Case[start][end] += count_Case[start-1][end-1-i]; // 맨 위의 첫 출발지점을 고정하고 도착가능한 지점을 지정하면서 두 지점간 다리를 놓았을 때 다리가 없는 지점간의 경우의 수 Count
				}
			}
		} // Memoization
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int west, right;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			west = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken()); // Input
			sb.append(count_Case[Math.min(west, right)][Math.max(west, right)]).append('\n'); // Output
		}
		System.out.print(sb.toString());
    }

}
