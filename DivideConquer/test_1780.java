import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1780 {
	static int[][] matrix;
	static int[] type = new int[3]; // -1, 0, 1 종이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		int i, j;
    
		for(i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(j = 0 ; j < N ; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
		} // Input
		
		if(!isOne(0, 0, N)) seperateSquare(0, 0, N/3, N, N); 
		// 한 종이가 아니면(범위 내 값들이 일치하지 않으면) 분할
		
		sb.append(type[0]).append('\n').append(type[1]).append('\n').append(type[2]);
		System.out.println(sb.toString());
	}

	private static void seperateSquare(int startRow, int startCol, int n, int endRow, int endCol) { 
		// (시작점 좌표(세로, 가로), 탐색범위 길이, 끝점 좌표(세로, 가로))
		if(n == 1) type[matrix[startRow][startCol]+1]++;
		else {
			if(!isOne(startRow, startCol, n)) seperateSquare(startRow, startCol, n/3, startRow+n, startCol+n); 
		}
		if(startCol+n < endCol) { 
			// 다음 정사각형으로 이동
			seperateSquare(startRow, startCol+n, n, endRow, endCol);
			return;
		}
		if(startRow+n < endRow) { 
			// 다음 줄, 첫번째 정사각형으로 이동
			seperateSquare(startRow+n, endCol-3*n, n, endRow, endCol);
			return;
		}
	}
	
	private static boolean isOne(int startRow, int startCol, int n) { 
		// 범위에 모든 값이 일치한 지 확인하는 함수
		int num = matrix[startRow][startCol];
		for(int i = startRow ; i < startRow+n ; i++) {
			for(int j = startCol ; j < startCol+n ; j++) {
				if(num != matrix[i][j]) return false;
			}
		}
		type[num+1]++;
		return true;
	}
}

