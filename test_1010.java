import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1010 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] count_Case = new int[30][30];
		int i,start,end; // ������� ���� �������� ������ ���� ������ ����
		for(i = 0 ; i < 30 ; i++) count_Case[0][i] = 1; // ��������� ���� ���� �������� ������ start�� 1�� ��츦 Count�ϱ� ���� 1�� �ʱ�ȭ
		for(start = 1 ; start < 30 ; start++) {
			for(end = start ; end < 30 ; end++) {
				for(i = 0 ; i <= end-start ; i++) {
					count_Case[start][end] += count_Case[start-1][end-1-i]; // �� ���� ù ��������� �����ϰ� ���������� ������ �����ϸ鼭 �� ������ �ٸ��� ������ �� �ٸ��� ���� �������� ����� �� Count
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