// Problem Link : https://www.acmicpc.net/problem/1302
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class test_1302 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String book_Name;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		ArrayList<String> same_Cnt = new ArrayList<String>();
		int cnt = 0, max_Cnt = 0; 
		
		while(N-- > 0) {
			book_Name = br.readLine();
			if(hmap.containsKey(book_Name)) hmap.put(book_Name, hmap.get(book_Name)+1);
			else hmap.put(book_Name, 1);
		} // Input, String�� key������ �� Hashmap�� ���� Count
		
		for(String name : hmap.keySet()) { // �ִ밪�� ���� key���� List�� ����, �ִ밪 ����� List �ʱ�ȭ
			cnt = hmap.get(name);
			if(max_Cnt < cnt) { 
				max_Cnt = cnt;
				same_Cnt = new ArrayList<String>();
				same_Cnt.add(name);
			}
			else if(max_Cnt == cnt) same_Cnt.add(name);
			else continue;
		}

		Collections.sort(same_Cnt); // ������ ����
		System.out.print(same_Cnt.get(0));
    }
}