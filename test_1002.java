import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1002 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] p; // (x1,y1,r1), (x2,y2,r2)
		int rsum_2, rdiff_2, d_2;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			p = new int[6];
			for(int j = 0 ; j < 6 ; j++) p[j] = Integer.parseInt(st.nextToken());

			rsum_2 = (int)Math.pow(p[2] + p[5], 2); // (계산거리의 합)^2
			rdiff_2 = (int)Math.pow(p[2] - p[5], 2); // (계산거리의 차)^2
			d_2 = (int)(Math.pow(p[0] - p[3], 2) + Math.pow(p[1] - p[4], 2)); // (두 터렛간 거리)^2
			
			// 터렛 기준에서 반지름이 r인 원 그리기
			if(p[0] == p[3] && p[1] == p[4] && p[2] == p[5]) sb.append("-1").append('\n'); // 두 원이 완전겹친 경우 = 접점 무한대
			else if(d_2 == rdiff_2 || d_2 == rsum_2) sb.append("1").append('\n'); // 두 원이 서로 접해있거나 한 원이 다른 원 안에서 접한 경우 = 접점 1개
			else if(d_2 > rdiff_2 && d_2 < rsum_2) sb.append("2").append('\n'); // 두 원의  일부만 겹친 경우 = 접점 2개
			else sb.append("0").append('\n'); // 두 원이 만나지 않는 경우 = 접점 없음
		}
		System.out.print(sb.toString());
	}
}