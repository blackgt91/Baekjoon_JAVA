import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test_1309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 9901;
		
		int[] count_Case = new int[100001];
		count_Case[0] = 1;
		count_Case[1] = 3;
		for(int i = 2 ; i <= 100000 ; i++) count_Case[i] += (2*count_Case[i-1]+count_Case[i-2])%mod; // int������ ����� �ʴ� ������ ������ ���� 
		// 1�� 2�� �� Count
		// 1.�� ù�� ���ʿ� ���ڰ� ���� ��� �������� �� �Ʒ� �ٱ��� ���ڸ� ������ �� �ִ� ����� �� +
		// �� ù�� �����ʿ� ���ڰ� ���� ��� �������� �� �Ʒ� �ٱ��� ���ڸ� ������ �� �ִ� ����� ��
		// (count_Case[i-1]+count_Case[i-1]-count_Case[i-2] : ���� �� �����ʿ� ��ġ, ���� �� ���ʿ� ��ġ�� ����� ���� �� = ���� �� ����� ���� �տ��� ���� �ٿ� ���ڰ� ���� �ʾ��� ���� ����� ���� �� ��)
		// 2.�� ù�� ���� ��  �������� �� �Ʒ� �ٱ��� ���ڸ� ������ �� �ִ� ����� ��(count_Case[i-1])
		// Memoization
		
		int N = Integer.parseInt(br.readLine()); // Input
		System.out.print(count_Case[N]); // Output
    }
}