import java.util.Scanner;

public class The_Rank {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[][] a = new int[n][4];
		int cmax = 0, maxi = 1;
		int[] max = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = t.nextInt();
				cmax += a[i][j];
			}

			max[i] = cmax;
			cmax = 0;
		}

		for (int i = 1; i < n; i++) {
			if (max[0] < max[i])
				maxi++;
		}

		System.out.println(maxi);

	}

}