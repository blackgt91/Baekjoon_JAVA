// Problem Link
// https://www.acmicpc.net/problem/2805

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_2805 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[] tree = new int[N];
		long total = 0;
		int i, start = 0, mid = 0, end = 0, height = 0;
		
		st = new StringTokenizer(br.readLine());
		for(i = 0 ; i < N ; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		} // Input, 범위 최대값 찾기
		
		while(start < end) { // 탐색 범위가 2 이상인 동안
			System.out.println(start + "," + end);
			mid = (start+end)/2;
			total = 0;
			
			// 중간값 구하기
			for(i = 0 ; i < N ; i++) total += tree[i] > mid ? tree[i] - mid : 0; 
			
			// Left(중간값 아래)
			if(total < M) end = mid; 
			else { // Right(중간값 이상, 갱신)
				height = mid;
				start = mid+1;
			}
		}
		System.out.println(height);
	}
}
