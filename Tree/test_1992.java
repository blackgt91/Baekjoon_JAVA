// Problem Link : https://www.acmicpc.net/problem/1992
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1992 {
	static boolean[][] matrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		matrix = new boolean[N][N];
		String inputRow;
		for(int i = 0 ; i < N ; i++) {
			inputRow = br.readLine();
			for(int j = 0 ; j < N ; j++) matrix[i][j] = inputRow.charAt(j) == '1';
		} // Input
		System.out.println(zoomIn(0, 0, N));
	}

	private static String zoomIn(int i, int j, int n) {
		if(n == 1) return matrix[i][j] ? "1" : "0";
		else {
			StringBuilder sb = new StringBuilder();
			String[] square = new String[4];
			
			// 분할
			square[0] = zoomIn(i, j, n/2);
			square[1] = zoomIn(i, j+n/2, n/2);
			square[2] = zoomIn(i+n/2, j, n/2);
			square[3] = zoomIn(i+n/2, j+n/2, n/2);
			
			// Output
			if(square[0].length() == 1 && square[0].equals(square[1]) && square[1].equals(square[2]) && square[2].equals(square[3])) return square[0]; 
			else return sb.append('(').append(square[0]).append(square[1]).append(square[2]).append(square[3]).append(')').toString();
		}
	}
}
