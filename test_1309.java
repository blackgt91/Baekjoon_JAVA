import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test_1309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 9901;
		
		int[] count_Case = new int[100001];
		count_Case[0] = 1;
		count_Case[1] = 3;
		for(int i = 2 ; i <= 100000 ; i++) count_Case[i] += (2*count_Case[i-1]+count_Case[i-2])%mod; // int범위를 벗어나지 않는 선에서 나머지 연산 
		// 1과 2의 합 Count
		// 1.맨 첫줄 왼쪽에 사자가 들어갔을 경우 다음부터 맨 아래 줄까지 사자를 투입할 수 있는 경우의 수 +
		// 맨 첫줄 오른쪽에 사자가 들어갔을 경우 다음부터 맨 아래 줄까지 사자를 투입할 수 있는 경우의 수
		// (count_Case[i-1]+count_Case[i-1]-count_Case[i-2] : 다음 줄 오른쪽에 배치, 다음 줄 왼쪽에 배치한 경우의 수의 합 = 다음 줄 경우의 수의 합에서 다음 줄에 사자가 들어가지 않았을 때의 경우의 수를 뺀 것)
		// 2.맨 첫줄 없을 때  다음부터 맨 아래 줄까지 사자를 투입할 수 있는 경우의 수(count_Case[i-1])
		// Memoization
		
		int N = Integer.parseInt(br.readLine()); // Input
		System.out.print(count_Case[N]); // Output
    }
}