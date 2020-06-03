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
		int[][] relationship = new int[N+1][N+1]; // A�� B�� �̾��� �� �ִ� �ּ� �ܰ� (A���� B���� ���µ� ������ �ּ� ����)
		
		for(int both = 1 ; both <= N ; both++) Arrays.fill(relationship[both], 100); // �ܰ�(������ ����) �ʱ�ȭ
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			relationship[b][a] = 1; // �յ� ���� ���� (������� ������ �ٲ� ������ ���������� ����)
			relationship[a][b] = 1;
		} // Input
		
		// Floyd-Warshall
		for(int both = 1 ; both <= N ; both++) { //1 ~ N�� ���ؼ� �̾����� ���
			for(a = 1 ; a <= N ; a++) {
				for(b = 1 ; b <= N ; b++) {
					if(relationship[a][b] > relationship[a][both] + relationship[both][b]) { // �� ���� �ܰ�� �̾��� �� Ȯ���ߴٸ� ����
						relationship[a][b] = relationship[a][both] + relationship[both][b];
					}
				}
			}
		}
		
		//�ּ� �ܰ� �� �ε��� Ȯ��
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