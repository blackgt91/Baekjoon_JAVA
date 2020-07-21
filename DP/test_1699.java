import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1699 {
    	static int[] sumLength;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sumLength = new int[N+1];
		dp(N, (int)Math.sqrt(N), 0); // 차(0이 나타날 때까지 재귀호출)를 이용하여 최소의 합연산 횟수 계산 
		System.out.println(sumLength[0]);
	}

	public static void dp(int total, int maxNum, int cnt) {
		if(sumLength[total] == 0 || cnt < sumLength[total]) { // 처음 탐색하거나 기존 기록된 횟수보다 낮으면 update, 탐색 수행
			sumLength[total] = cnt;
			for(int i = maxNum ; i >= 1 ; i--) { // 남은 값에서 뺄 수 있는 조건으로 큰 값부터 탐색
				if(i*i <= total) dp(total-i*i, i, cnt+1);
			}
		}
		else return; 
	}
}
