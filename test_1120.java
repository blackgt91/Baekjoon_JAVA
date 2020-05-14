// Problem Link : https://www.acmicpc.net/problem/1120
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1120 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		int length_Diff = B.length-A.length; 
		
		int diff_Char_Min = 50; // ���ڿ� �ִ� ��������
		int char_Diff; //�ٸ� ���ڿ� �� ���
		for(int add = 0 ; add <= length_Diff ; add++) { // ���ڿ� �տ� �� ���� ���� for�� (�߰��� �� ���ڴ� ���ڿ� B�� ���ڿ� ����)
			char_Diff = 0;
			for(int i = 0 ; i < A.length ; i++) {
				if(A[i] != B[i+add]) char_Diff++;
			}
			diff_Char_Min = Math.min(diff_Char_Min, char_Diff);
		}
		System.out.println(diff_Char_Min);
	}
}