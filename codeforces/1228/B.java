import java.math.BigInteger;
import java.util.Scanner;

public class Filling_the_grids {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int m = t.nextInt();
		int n = t.nextInt();
		boolean[][] maze = new boolean[m][n];
		int[] row = new int[m];
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			int k = t.nextInt();
			row[i] = k;

			for (int j = 0; j < k; j++)
				maze[i][j] = true;
		}

		for (int i = 0; i < n; i++) {
			int k = t.nextInt();
			col[i] = k;

			for (int j = 0; j < k; j++)
				maze[j][i] = true;
		}
		
		for (int i = 0; i < m; i++) {
			if(row[i]<n&&maze[i][row[i]])
			{
				System.out.println(0);
				return;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if(col[i]<m&&maze[col[i]][i])
			{
				System.out.println(0);
				return;
			}
		}

		int pow = 0;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (!maze[i][j]) {
					if (j - row[i] > 0 && i - col[j] > 0)
						pow++;
				}
			}
		}

		BigInteger b1 = new BigInteger("2");
		BigInteger res = b1.pow(pow);
		BigInteger b2 = new BigInteger("1000000007");
		res = res.remainder(b2);

		System.out.println(res);

	}

}