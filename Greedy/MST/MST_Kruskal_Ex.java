// Problem Link
// https://www.acmicpc.net/problem/1922

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST_Kruskal_Ex {

	static int[] parent;
	static class Connection { // 간선 객체 (시작점, 끝점, 가중치)
		int from, to, cost;
		Connection (int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

        parent = new int[N+1]; // 모든 노드가 연결 -> 통일된 root값, 필요한 최소 간선 수 N-1개
        int from, to, cost, totalCost = 0, needConnection = N-1;
        
        // 가중치 최소로 탐색하기 위한 큐, Comparator 선언
        PriorityQueue<Connection> pq = new PriorityQueue<Connection>((Connection c1, Connection c2) -> c1.cost - c2.cost); 
        Connection currentConn;
        
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	cost = Integer.parseInt(st.nextToken());

            pq.add(new Connection(from, to, cost));
        } // Input
        
        // 부모 노드가  없는 것으로 초기화
        for(int i = 1 ; i <= N ; i++) parent[i] = i;
        
        while(needConnection != 0) {
        	currentConn = pq.poll();
        	
        	// 시작점과 끝점과의 root값 비교
        	from = findParent(currentConn.from); 
        	to = findParent(currentConn.to);
        	
    		if(from != to) { 
    			// 시작점의 root값에서 끝점으로 연결
    			parent[from] = currentConn.to;
        		totalCost += currentConn.cost;
        		needConnection--;
    		}
        }
        
        System.out.println(totalCost);
	}

	// 초기화했던 값이면 (부모 노드가 없으면) root값 
	static int findParent(int com) { 
		if(parent[com] != com) com = findParent(parent[com]);
		return com;
	}
	
}
