// Problem Link : https://www.acmicpc.net/problem/2583

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class test_2583 {
	 public static void main(String[] args)throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Point> stk = new Stack<Point>();
        ArrayList<Integer> area = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        boolean[][] paper = new boolean[M][N];
        int pi,pj,i,j,startI,startJ,endI,endJ,cnt = 0;
        Point startP;
        boolean[][] visited = new boolean[M][N];
        
        while(K-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	startI = Integer.parseInt(st.nextToken());
        	startJ = Integer.parseInt(st.nextToken());
        	endI = Integer.parseInt(st.nextToken());
        	endJ = Integer.parseInt(st.nextToken());
        	
        	for(i = startI ; i < endI ; i++) {
        		for(j = startJ ; j < endJ ; j++) paper[j][i] = true;
        	}
        } // Input
        
        // 넓이 계산 -> 스택을 활용한 깊이우선탐색
        for(i = 0 ; i < M ; i++) {
    		for(j = 0 ; j < N ; j++) {
    			if(!visited[i][j] && !paper[i][j]) {
	    			cnt = 0;
	    			stk.add(new Point(i, j));
	    	        while(!stk.isEmpty()) {
	    	        	startP = stk.pop();
	    	        	pi = startP.i;
	    	        	pj = startP.j;
	    	            if(!visited[pi][pj]) {
	    	        		visited[pi][pj] = true;
		    	        	if(pi+1 < M && !visited[pi+1][pj] && !paper[pi+1][pj]) stk.add(new Point(pi+1, pj));
		    	        	
		    	        	if(pj+1 < N && !visited[pi][pj+1] && !paper[pi][pj+1]) stk.add(new Point(pi, pj+1));
		    	        	
		    	        	if(pi > 0 && !visited[pi-1][pj] && !paper[pi-1][pj]) stk.add(new Point(pi-1, pj));
		    	        	
		    	        	if(pj > 0 && !visited[pi][pj-1] && !paper[pi][pj-1]) stk.add(new Point(pi, pj-1));
		    	        	
		    	        	cnt++;
	    	            }
	    	        }
        	        area.add(cnt);
	    		}
    		}
    	}
        
        // Output : 공간 개수, 크기(오름차순)
        sb.append(area.size()).append('\n');
        Collections.sort(area);
        for(int s : area) sb.append(s).append(" ");
        
        System.out.println(sb.toString());
	 }

	 public static class Point { // 좌표 객체 선언
		 int i, j;
		 Point(int i,int j) {
			 this.i = i;
			 this.j = j;
		}
	 }
}
