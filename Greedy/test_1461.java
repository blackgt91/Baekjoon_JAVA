// Problem Link : https://www.acmicpc.net/problem/1461
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_1461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int seat_Num, left_Cnt = 0, right_Cnt = 0, l, r, dist = 0;
		int[] left = new int[N];
		int[] right = new int[N];
		st = new StringTokenizer(br.readLine());
		while(N-- > 0) { // 음수와 양수로 분류하여 Input(음수값으로 저장)
			seat_Num = Integer.parseInt(st.nextToken()); 
			if(seat_Num < 0) left[left_Cnt++] = seat_Num; 
			else right[right_Cnt++] = -seat_Num; 
		}
		
		left_Cnt--;
		right_Cnt--;
		Arrays.sort(left);
		Arrays.sort(right); // 가장 먼 순서로 각각 오름차순 정렬
		l = 0;
		r = 0;
		// 최소값이 나오려면 절대값이 가장 큰 값이 마지막 위치(두 번 걷지 않음)
		if(l > left_Cnt) { // 음수값이 없으면 양수 최대값
			dist -= right[r];
			r += M;
		}
		else if(r > right_Cnt) { // 양수값이 없으면 음수 최소값 
			dist -= left[l];
			l += M;
		}
		else if(right[r] > left[l]) { // 음수와 양수 간의 절대값 비교  
			dist -= left[l];
			l+=M;
		}
		else {
			dist -= right[r];
			r+=M;
		}
		
		while(r <= right_Cnt) { // 먼 곳부터 0으로 올 때까지 책 놓고 돌아오는 왕복거리 계산
			dist -= 2*right[r];
			r += M;
		}
		while(l <= left_Cnt) {
			dist -= 2*left[l];
			l += M;
		}
		System.out.println(dist);
	}
}
