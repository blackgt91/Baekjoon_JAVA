// Problem Link : https://www.acmicpc.net/problem/1120
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1120 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		int length_Diff = B.length-A.length; 
		
		int diff_Char_Min = 50; // 문자열 최대 길이차이
		int char_Diff; //다른 문자열 수 계산
		for(int add = 0 ; add <= length_Diff ; add++) { // 문자열 앞에 들어간 수에 따른 for문 (추가로 들어간 문자는 문자열 B의 문자와 동일)
			char_Diff = 0;
			for(int i = 0 ; i < A.length ; i++) {
				if(A[i] != B[i+add]) char_Diff++;
			}
			diff_Char_Min = Math.min(diff_Char_Min, char_Diff);
		}
		System.out.println(diff_Char_Min);
	}
}
