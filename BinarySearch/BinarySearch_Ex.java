// Problem Link : https://www.acmicpc.net/problem/1920
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_Ex {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 
        int i;
        
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++) arrN[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arrN);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(i = 0 ; i < M ; i++) {
        	if(Arrays.binarySearch(arrN, Integer.parseInt(st.nextToken())) >= 0) sb.append("1\n");
        	else sb.append("0\n");
        }
        
        System.out.println(sb.toString());
	}
}
