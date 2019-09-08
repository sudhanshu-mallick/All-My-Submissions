import java.util.Scanner;

public class Vitaly_and_Night {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int m = t.nextInt();
		int[][] a = new int[n][2 * m];
		int awake = 0, even = 0;

		for (int i = 0; i < n; i++) {
			even = 0;

			for (int j = 0; j < 2 * m; j++) {
				a[i][j] = t.nextInt();
				even++;

				if (even % 2 == 0) {
					if (a[i][j] == 1 || a[i][j - 1] == 1)
						awake++;
				}
			}

		}

		System.out.println(awake);
	}

}
