import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1002 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] p; // (x1,y1,r1), (x2,y2,r2)
		int rsum_2, rdiff_2, d_2;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			p = new int[6];
			for(int j = 0 ; j < 6 ; j++) p[j] = Integer.parseInt(st.nextToken());

			rsum_2 = (int)Math.pow(p[2] + p[5], 2); // (���Ÿ��� ��)^2
			rdiff_2 = (int)Math.pow(p[2] - p[5], 2); // (���Ÿ��� ��)^2
			d_2 = (int)(Math.pow(p[0] - p[3], 2) + Math.pow(p[1] - p[4], 2)); // (�� �ͷ��� �Ÿ�)^2
			
			// �ͷ� ���ؿ��� �������� r�� �� �׸���
			if(p[0] == p[3] && p[1] == p[4] && p[2] == p[5]) sb.append("-1").append('\n'); // �� ���� ������ģ ��� = ���� ���Ѵ�
			else if(d_2 == rdiff_2 || d_2 == rsum_2) sb.append("1").append('\n'); // �� ���� ���� �����ְų� �� ���� �ٸ� �� �ȿ��� ���� ��� = ���� 1��
			else if(d_2 > rdiff_2 && d_2 < rsum_2) sb.append("2").append('\n'); // �� ����  �Ϻθ� ��ģ ��� = ���� 2��
			else sb.append("0").append('\n'); // �� ���� ������ �ʴ� ��� = ���� ����
		}
		System.out.print(sb.toString());
	}
}