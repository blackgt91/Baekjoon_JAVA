import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_2178 {
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Coordinate> nodeQueue = new LinkedList<Coordinate>();
		String row;
		Coordinate pos;
		int x, y;
		
		// Input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		int[][] move = new int[N][M]; // 좌표까지의 최단 걸음(가장 먼저 변경된 값)
		
		for(int i = 0 ; i < N ; i++) {
			row = br.readLine();
			for(int j = 0 ; j < M ; j++) map[i][j] = row.charAt(j)-'0' == 1;
		} 
		
		// 시작점 선언
		move[0][0] = 1;
		nodeQueue.add(new Coordinate(0,0));
		
		// 최소 이동횟수 찾기 -> 너비우선 탐색
		while(!nodeQueue.isEmpty()) { 
			pos = nodeQueue.poll();
			x = pos.x;
			y = pos.y;
			// 상하좌우별 조건 정의 및 이동
			if(x+1 != N && map[x+1][y] && move[x+1][y] == 0) { // 아래로 이동 
				nodeQueue.add(new Coordinate(x+1,y));
				move[x+1][y] = move[x][y]+1;
			}
			if(x != 0 && map[x-1][y] && move[x-1][y] == 0) { // 위로 이동
				nodeQueue.add(new Coordinate(x-1,y));
				move[x-1][y] = move[x][y]+1;
			}
			if(y+1 != M && map[x][y+1] && move[x][y+1] == 0) { // 우로 이동
				nodeQueue.add(new Coordinate(x,y+1));
				move[x][y+1] = move[x][y]+1;
			}
			if(y != 0 && map[x][y-1] && move[x][y-1] == 0) { // 좌로 이동
				nodeQueue.add(new Coordinate(x,y-1));
				move[x][y-1] = move[x][y]+1;
			}
		}
		System.out.println(move[N-1][M-1]);
	}
}

class Coordinate{ // 좌표값 자료형 객체 선언
	int x;
	int y;
	
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
}
