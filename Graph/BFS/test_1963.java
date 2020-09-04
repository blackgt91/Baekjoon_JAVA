// Problem Link : https://www.acmicpc.net/problem/1963

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_1963 {
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		
		boolean[] isNotPrime = new boolean[10000];
		int[] change;
		int i, j, num, nextNum, start, end, digit;
		
		for(i = 2 ; i < 100 ; i++) { // 소수 찾기
			for(j = i ; i*j < 10000 ; j++) {
				isNotPrime[i*j] = true;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			// Input
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			// 너비 우선 탐색 전 초기화
			change = new int[10000];
			Arrays.fill(change, 9000);
			q = new LinkedList<Integer>();
			q.add(start);
			change[start] = 0;
			
			// BFS
			while(!q.isEmpty()) {
				num = q.poll();
				if(num == end) break; // 목표 소수를 확인하면 Loop문 종료
				
				// 각 자릿수 숫자 변경을 통한 탐색
				digit = 1000; 
				while(digit != 0) {
					nextNum = num - num/digit%10*digit;
					// 네 자리수만 허용
					if(nextNum < 1000) {
						i = 1;
						nextNum += 1000;
					}
					else i = 0;
					for( ; i < 10 ; i++) {
						// 소수, 최소값 조건 성립 시 update 및 데이터 추가 
						if(!isNotPrime[nextNum] && change[nextNum] > change[num] + 1) {
							change[nextNum] = change[num] + 1;
							q.add(nextNum);
						}
						nextNum += digit;
					}
					digit /= 10;
				}
			}
			sb.append(change[end]).append('\n');
		}
		System.out.println(sb.toString());
	}                                                                                                                                                  
	
}
