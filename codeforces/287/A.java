import java.util.ArrayList;
import java.util.Scanner;

public class IQ_Test {

	double d;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int[][] a = new int[4][4];

		for (int i = 0; i < 4; ++i) {
			String s = t.next();

			for (int j = 0; j < 4; ++j) {
				char ch = s.charAt(j);

				if (ch == '#')
					a[i][j] = 1;
				else
					a[i][j] = 0;
			}
		}

		for (int i = 1; i < 4; ++i) {
			for (int j = 1; j < 4; ++j) {
				int sum = a[i][j] + a[i - 1][j] + a[i][j - 1] + a[i - 1][j - 1];

				if (sum != 2) {
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");

	}

}