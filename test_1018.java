// Problem Link : https://www.acmicpc.net/problem/1018
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1018 {
	static char[][] chessboard;
	public static int check(int a, int b) { // 색이 지속적으로 바뀌는지 확인하여 고쳐야할 정사각형 Count
		boolean bw = false; // 다음 타일 넘어갈때마다 변하는 변수(Toggle)
		int fix = 0;
		for(int x = 0 ; x < 8 ; x++) {
			bw = !bw; // 다음 row로 이동할 시 색은 변하지 않음
			for(int y = 0 ; y < 8 ; y++) {
				if(chessboard[a+x][b+y] == 'B' ^ bw) fix++; // 값이 같이 변하고 있는지 확인
				bw = !bw;
			}
		}
		return Math.min(fix, 64-fix); // Max : 32
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fix = 0; int min = 32;
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		chessboard = new char[i][j];
		for(int x = 0 ; x < i ; x++) chessboard[x] = br.readLine().toCharArray(); //Input
		
		// 8*8 단위의 체스판 탐색 및 검사 함수 실행
		for(int a = i-8 ; a >= 0 ; a--) { 
			for(int b = j-8 ; b >= 0 ; b--) {
				fix = check(a,b);
				min = Math.min(min, fix);
			}
		}
		System.out.print(min);
    }
}