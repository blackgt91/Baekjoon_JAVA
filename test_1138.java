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
		
		row[left_High[1]] = 1; // Ű ���� ������� ��ġ
		for(i = 2 ; i <= N ; i++) {
			seat = 0;
			High = 0;
			while(High != left_High[i]) { // High : ���� �ڸ��� Ű ū ��� �ο� Ž�� == ���� ��ġ�ȵ� �ڸ�(=�ʱ�ȭ��) ã��
				if(row[seat++] == 0) High++; 
			}
			if(row[seat] == 0) row[seat] = i; 
			else { // Ű ���� ����� �ڸ����� ��쿡�� ������ �ڸ���
				while(row[++seat] != 0) {}
				row[seat] = i;
			}
		}
		for(i = 0 ; i < N ; i++) sb.append(row[i]).append(" ");
		System.out.println(sb.toString());
	}
}