// Problem Link : https://www.acmicpc.net/problem/1011
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1011 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); // Input
			
			if(y-x <= 3) sb.append(y-x); // 속도 1로만 갈 수 있는 경우
			else {
				int max_Velocity = (int)Math.sqrt(y-x); // 1로 착륙하기 위한 최고 속도 (ex.거리 4광년: 1+2+1, 9광년 : 1+2+3+2+1)
				if(max_Velocity*max_Velocity == y-x) sb.append(2*max_Velocity-1); // 항상 홀수, 이보다 크면 짝수
				else if(max_Velocity*max_Velocity + max_Velocity < y-x) sb.append(2*max_Velocity+1); // 최고속도를 최소 두 번 내야하는 거리 이상이면 다시 홀수
				else sb.append(2*max_Velocity);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		br.close();
	}
}