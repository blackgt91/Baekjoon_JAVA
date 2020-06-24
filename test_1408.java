// Problem Link : https://www.acmicpc.net/problem/1408

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1408 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(),":");
    
    // 시간 데이터 형식을 초(Integer, 0~24*3600-1) 단위 형태로 변환하여 초기화 
    // 끝난 시간 - 시작 시간
		int seconds = -(3600*Integer.parseInt(st.nextToken()) + 60*Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())); 
		st = new StringTokenizer(br.readLine(),":");
		seconds += 3600*Integer.parseInt(st.nextToken()) + 60*Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		if(seconds < 0) seconds += 3600*24; // 자정을 지난 경우(0초부터 다시 시작한 경우) 예외처리
    
    // 시간 단위별 출력
		int hour = seconds / 3600; 
		seconds %= 3600;
		int minute = seconds / 60;
		seconds %= 60;
    
		// 시간 데이터 형태로 맞추기 위한 조건문 사용
		sb.append(hour < 10 ? "0"+hour : hour).append(':').append(minute < 10 ? "0"+minute : minute).append(':').append(seconds < 10 ? "0"+seconds : seconds);
		System.out.println(sb.toString());
	}
}
