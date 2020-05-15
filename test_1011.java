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
			
			if(y-x <= 3) sb.append(y-x); // �ӵ� 1�θ� �� �� �ִ� ���
			else {
				int max_Velocity = (int)Math.sqrt(y-x); // 1�� �����ϱ� ���� �ְ� �ӵ� (ex.�Ÿ� 4����: 1+2+1, 9���� : 1+2+3+2+1)
				if(max_Velocity*max_Velocity == y-x) sb.append(2*max_Velocity-1); // �׻� Ȧ��, �̺��� ũ�� ¦��
				else if(max_Velocity*max_Velocity + max_Velocity < y-x) sb.append(2*max_Velocity+1); // �ְ�ӵ��� �ּ� �� �� �����ϴ� �Ÿ� �̻��̸� �ٽ� Ȧ��
				else sb.append(2*max_Velocity);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
		br.close();
	}
}