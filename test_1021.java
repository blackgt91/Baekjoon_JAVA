// Problem Link : https://www.acmicpc.net/problem/1021
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int[] dq = new int[n];
		int cnt_Min = 0, tmp, cnt;
		for(int i = 1 ; i <= n ; i++) dq[i-1] = i;
		String[] nlist = br.readLine().split(" ");
		br.close(); // Input
		
		for(int i = 0 ; i < a ; i++) {
			cnt = 0;
			while(dq[0] != Integer.parseInt(nlist[i])) { // index가 0이면 뽑아내는 것으로 하여 연산 A를 수행하며 원소 찾기
				tmp = dq[0];
				for(int b = 0 ; b < n-1 ; b++) dq[b] = dq[b+1];
				dq[n-1] = tmp;
				cnt++;
			}
			if(cnt > n - cnt) cnt = n - cnt; // 연산 B 수행 횟수 = 한바퀴 도는데 수행횟수 (큐 크기) - 연산 A 수행횟수
			for(int b = 0 ; b < n-1 ; b++) dq[b] = dq[b+1];
			n--;
			cnt_Min += cnt;
		}
		System.out.println(cnt_Min);
    }
}