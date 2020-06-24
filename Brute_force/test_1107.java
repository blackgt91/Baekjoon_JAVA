// Problem Link : https://www.acmicpc.net/problem/1107

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine()); 
        int unuse = Integer.parseInt(br.readLine());
        int numClicks = 0, click = 0, plus_minus = 0;
        boolean[] broken = new boolean[10];
        if(unuse != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < unuse ; i++) broken[Integer.parseInt(st.nextToken())] = true;
        } // Input
        
        click = Math.abs(channel-100); // +, -만 클릭했을 때의 클릭 횟수로 초기화
        while(plus_minus <= click) { // 초기화했을 때보다 더 적은 클릭으로 맞출 수 있는 지 탐색하는 과정(plus_minus : +/- 클릭수)
           
        	numClicks = check_Num_Click(broken, channel+plus_minus); //큰 번호에서 내려오기
            if(numClicks > 0) click = Math.min(click, plus_minus + numClicks);
            
            numClicks = channel >= plus_minus ? check_Num_Click(broken, channel-plus_minus) : 0; // 작은 번호에서 올라가기, 음수인 채널은 없으므로 예외처리
            if(numClicks > 0) click = Math.min(click, plus_minus + numClicks); 
            
            plus_minus++;
        }
        System.out.print(click);
    }
    
    public static int check_Num_Click(boolean[] broken, int ch) { // 번호 클릭만을 통해 채널을 맞출 수 있다면 클릭 수 return
        int cnt = 0; int temp = ch; 
        if(ch == 0) return !broken[temp%10] ? 1 : 0;
        else {
            while(temp != 0) {
                if(!broken[temp%10]) cnt++;
                else return 0;
                temp /= 10;
            }
        }
        return cnt;
    }
}
