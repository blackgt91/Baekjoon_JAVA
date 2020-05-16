// Problem Link : https://www.acmicpc.net/problem/1018
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1018 {
	static char[][] chessboard;
	public static int check(int a, int b) { // ���� ���������� �ٲ���� Ȯ���Ͽ� ���ľ��� ���簢�� Count
		boolean bw = false; // ���� Ÿ�� �Ѿ������ ���ϴ� ����(Toggle)
		int fix = 0;
		for(int x = 0 ; x < 8 ; x++) {
			bw = !bw; // ���� row�� �̵��� �� ���� ������ ����
			for(int y = 0 ; y < 8 ; y++) {
				if(chessboard[a+x][b+y] == 'B' ^ bw) fix++; // ���� ���� ���ϰ� �ִ��� Ȯ��
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
		
		// 8*8 ������ ü���� Ž�� �� �˻� �Լ� ����
		for(int a = i-8 ; a >= 0 ; a--) { 
			for(int b = j-8 ; b >= 0 ; b--) {
				fix = check(a,b);
				min = Math.min(min, fix);
			}
		}
		System.out.print(min);
    }
}