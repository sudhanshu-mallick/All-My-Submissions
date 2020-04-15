import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int a[][] = new int[9][9];

			for (int i = 0; i < 9; i++) {
				String s = br.readLine();

				for (int j = 0; j < 9; j++) {
					a[i][j] = Integer.parseInt(s.charAt(j) + "");

					if (a[i][j] == 1)
						sb.append(2);
					else
						sb.append(a[i][j]);
				}

				sb.append("\n");

			}
		}
		System.out.println(sb);
	}
}