import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] maxSumUntil = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int end, num, maxSum = Integer.MIN_VALUE;
		
		// O(N^2) -> O(N)
		// Index까지의 구간합 최대값 계산
		for(end = 1 ; end <= n ; end++) { 
			num = Integer.parseInt(st.nextToken());
			if(maxSumUntil[end-1] + num > num) maxSumUntil[end] = maxSumUntil[end-1] + num;
			else maxSumUntil[end] = num;
		}
		
		for(end = 1 ; end <= n ; end++) {
			if(maxSum < maxSumUntil[end]) maxSum = maxSumUntil[end];
		}
		System.out.println(maxSum);
	}
}
 
