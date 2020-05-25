// Problem Link : https://www.acmicpc.net/problem/1124
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1124 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] has_Prime = new int[100001]; // ���μ����� �������� �Ҽ� ����, 1���̸� �Ҽ�
		int i;
		
		for(i = 2 ; i < has_Prime.length ; i++) {
			if(has_Prime[i] == 0) has_Prime[i]++; // �Ҽ��� ���
			for(int j = 2 ; j*i < has_Prime.length ; j++) has_Prime[j*i] = has_Prime[i]+has_Prime[j]; // ������ ���� �Ҽ� ���� Count
		}
		// Memoization
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(i = A ; i <= B ; i++) {
			if(has_Prime[has_Prime[i]]==1) cnt++; // �Ҽ� ������ ���μ����� ���� �� �Ҽ��� 1���� ���
		}
		System.out.print(cnt);
	}
	
}