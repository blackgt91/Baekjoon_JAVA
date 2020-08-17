import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_lowerBound {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] lines = new int[N+1];
		int size = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(lines[size] < arr[i]) lines[++size] = arr[i];
			else if(lines[size] == arr[i]) continue;
			else lines[lower_Bound(lines, 1, size, arr[i])] = arr[i];
		}
		System.out.println(N-size);

	}

	public static int lower_Bound(int[] L, int start, int end, int val) { 
		int mid = 0; int i = 0; 
		while(start <= end) { 
			mid = (start+end)/2;
			if (L[mid] < val) start = mid + 1;
			else {
				i = mid; 
				end = mid - 1; 
			} 
		} 
		return i; 
	}
}
