// Problem Link : https://www.acmicpc.net/problem/1074
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1074 {
	static int r,c,res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()); // Input
		
		func((int)Math.pow(2, N),r,c,0); 
		System.out.print(res);
	}
	
	public static void func(int size, int r, int c,int cnt) { // 범위를 4가지로 구분하여 재귀 호출
		if(size == 1) res = cnt;
		else {
			int square_Length = size/2; // 나눈 배열 범위의 길이 및 구분 기준
			if(r < square_Length) {
				if(c < square_Length) func(square_Length, r, c, cnt);
				else func(square_Length, r, c-square_Length, cnt+square_Length*square_Length); // 다른 범위로 넘어가면 한 범위 내의 모든 칸수 단위로 Count
			}
			else {
				if(c < square_Length) func(square_Length, r-square_Length, c, cnt+2*square_Length*square_Length);
				else func(square_Length, r-square_Length, c-square_Length, cnt+3*square_Length*square_Length);
			}
		}
	}
}