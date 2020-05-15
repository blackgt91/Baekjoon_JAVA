// Problem Link : https://www.acmicpc.net/problem/1138
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1138 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] left_High = new int[N+1];
		int[] row = new int[N];
		int i, seat, High; 
		for(i = 1 ; i <= N ; i++) left_High[i] = Integer.parseInt(st.nextToken()); // Input
		
		row[left_High[1]] = 1; // 키 작은 사람부터 배치
		for(i = 2 ; i <= N ; i++) {
			seat = 0;
			High = 0;
			while(High != left_High[i]) { // High : 왼쪽 자리에 키 큰 사람 인원 탐색 == 아직 배치안된 자리(=초기화값) 찾기
				if(row[seat++] == 0) High++; 
			}
			if(row[seat] == 0) row[seat] = i; 
			else { // 키 작은 사람이 자리잡힌 경우에는 오른쪽 자리로
				while(row[++seat] != 0) {}
				row[seat] = i;
			}
		}
		for(i = 0 ; i < N ; i++) sb.append(row[i]).append(" ");
		System.out.println(sb.toString());
	}
}