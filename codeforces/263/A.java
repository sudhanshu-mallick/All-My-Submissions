import java.util.Scanner;

public class Beautiful_Matrix {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int[][] a = new int[5][5];
		int x = 0, y = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j] = t.nextInt();
				if (a[i][j] == 1) {
					x = i;
					y = j;
				}
			}
		}

		System.out.println(Math.abs(x - 2) + Math.abs(y - 2));

	}

}