package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chessboard_1018 {
	public static boolean[][] arr;
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];

		// 배열 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}
		int n_row = n - 7;
		int m_col = m - 7;

		for (int i = 0; i < n_row; i++) {
			for (int j = 0; j < m_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);

	}

	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean TF = arr[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				if (arr[i][j] != TF) {
					count++;
				}
				TF = (!TF); // 다음 칸은 색이 바뀌므로
			}
			TF = (!TF);
		}
		// 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		// 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		// 색칠 할 개수(64 - count) 중 최솟값을 count 에 저장

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);

	}

}

/*
 * 어려웠던 부분: 다
 * 문제 해결:
 * 
 */