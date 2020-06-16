//Problem Link : https://www.acmicpc.net/problem/2252

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_2252 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int link = Integer.parseInt(st.nextToken());
		int from, to, i, currentNode;
		
		ArrayList<Integer>[] nodeArray = new ArrayList[node+1]; // 비교했을 때 i번 학생보다 뒤에 서야되는 학생 리스트 (자식 노드 리스트)
		int[] targeted = new int[node+1]; // 키를 비교했을 때 i번 학생보다 먼저 서야되는 학생의 수(선행되어야하는 노드 개수)
		Queue<Integer> sorted = new LinkedList<Integer>(); //FIFO
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(i = 1 ; i <= node ; i++) nodeArray[i] = new ArrayList<Integer>();

		for(i = 0 ; i < link ; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			nodeArray[from].add(to);
			targeted[to]++;
		} // Input
		
		for(i = 1 ; i <= node ; i++) {
			if(targeted[i] == 0) sorted.add(i); // 가장 먼저 설 수 있는 학생 찾기(루트 노드 찾기)
		}
		
		while(!sorted.isEmpty()) { // BFS
			currentNode = sorted.poll();
			res.add(currentNode);
			for(int nextNode : nodeArray[currentNode]) {
				targeted[nextNode]--;
				if(targeted[nextNode] == 0) sorted.add(nextNode); // 더이상 선행되어야할 노드가 없어지면 다음 자식 노드 탐색을 수행한다
			}
		}
		
		for(int n : res) sb.append(n).append(" ");
		System.out.println(sb.toString());
	}

}
