// Problem Link
// https://www.acmicpc.net/problem/1197

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class minimumSpanningTree_Ex {
	
	static class Edge { // 간선 객체(시작점, 끝점, 가중치)
		int start, end, weight;
		Edge (int start, int end, int cost){
			this.start = start;
			this.end = end;
			this.weight = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
        int start, end, weight;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((Edge e1, Edge e2) -> e1.weight - e2.weight); // 가중치 최소로 탐색하기 위한 큐, Comparator 선언
        ArrayList<Edge>[] node = new ArrayList[V+1]; // 각 점들이 지니고 있는 간선
        for(int i = 1 ; i <= V ; i++) node[i] = new ArrayList<Edge>();
        
        ArrayList<Edge> edgeList;
        Edge chosenEdge;
        
        boolean[] visited = new boolean[V+1];
        int visit = 1;
		int totalWeight = 0;
        
        while(E-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	start = Integer.parseInt(st.nextToken());
        	end = Integer.parseInt(st.nextToken());
        	weight = Integer.parseInt(st.nextToken());
        	
        	// 양방향 탐색 가능
        	edgeList = node[start];
        	edgeList.add(new Edge(start, end, weight));
        	node[start] = edgeList;
        	
        	edgeList = node[end];
        	edgeList.add(new Edge(end, start, weight));
        	node[end] = edgeList;
        } // Input
        
        // 임의의 점 기준
        pq.addAll(node[1]);
        visited[1] = true;

        // 모든 점이 탐색될 때까지 최소 가중치의 간선 우선탐색
        while(visit != V) {
        	chosenEdge = pq.poll();
        	if(!visited[chosenEdge.end]) {
	        	visited[chosenEdge.end] = true;
        		visit++;
        		
        		totalWeight += chosenEdge.weight;
        		// 탐색한 점이 갖고있는 간선 탐색
	        	pq.addAll(node[chosenEdge.end]); 
        	}
        }
        
        System.out.println(totalWeight);
	}
	
}
