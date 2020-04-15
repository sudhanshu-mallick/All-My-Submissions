import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int test = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		StringBuilder st = new StringBuilder();

		while (test-- > 0) {
			int[] sudoku = new int[9];

			for (int i = 0; i < 9; i++) {
				String s = new StringTokenizer(br.readLine()).nextToken();

				for (int j = 0; j < 9; j++) {
					sudoku[j] = Integer.parseInt(s.charAt(j) + "");

					if (sudoku[j] == 2)
						sudoku[j] = 1;

					st.append(sudoku[j]);
				}

				st.append("\n");
			}
		}
		
		out.print(st);

		out.flush();
		out.close();
	}
}