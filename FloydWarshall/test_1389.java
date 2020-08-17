// Problem Link : https://www.acmicpc.net/problem/1389
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_1389 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int a, b, total, kb_Min = 0, res = 0;
		int[][] relationship = new int[N+1][N+1]; // A와 B가 이어질 수 있는 최소 단계 (A에서 B까지 가는데 만나는 최소 정점)
		
		for(int both = 1 ; both <= N ; both++) Arrays.fill(relationship[both], 100); // 단계(만나는 정점) 초기화
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			relationship[b][a] = 1; // 앞뒤 관계 없음 (출발점과 종점이 바뀌어도 지나는 정점개수는 동일)
			relationship[a][b] = 1;
		} // Input
		
		// Floyd-Warshall
		for(int both = 1 ; both <= N ; both++) { //1 ~ N을 통해서 이어지는 경우
			for(a = 1 ; a <= N ; a++) {
				for(b = 1 ; b <= N ; b++) {
					if(relationship[a][b] > relationship[a][both] + relationship[both][b]) { // 더 낮은 단계로 이어진 걸 확인했다면 갱신
						relationship[a][b] = relationship[a][both] + relationship[both][b];
					}
				}
			}
		}
		
		//최소 단계 및 인덱스 확인
		for(b = 1 ; b <= N ; b++) {
			kb_Min += relationship[1][b];
			res = 1;
		}
		
		for(a = 2 ; a <= N ; a++) {
			total = 0;
			for(b = 1 ; b <= N ; b++) total += relationship[a][b];
			if(kb_Min > total) {
				kb_Min = total;
				res = a;
			}
		}
		System.out.println(res);
	}
	
}
