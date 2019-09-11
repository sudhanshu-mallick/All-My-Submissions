import java.util.Scanner;

public class Tiling_Challenge {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		char[][] c = new char[n][n];
		String s = "";

		for (int i = 0; i < n; i++) {
			s = t.next();
			c[i] = s.toCharArray();
		}

		boolean flag = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= 1 && i <= n - 2 && j >= 1 && j <= n - 2) {
					if (c[i][j] == '.' && c[i][j - 1] == '.' && c[i][j + 1] == '.' && c[i - 1][j] == '.'
							&& c[i + 1][j] == '.') {
						c[i][j] = '#';
						c[i - 1][j] = '#';
						c[i + 1][j] = '#';
						c[i][j + 1] = '#';
						c[i][j - 1] = '#';
					}

				}

			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (c[i][j] == '.')
					flag = false;

		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}