import java.util.Scanner;

public class Yet_Another_Tetris_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			int flag = 0;

			for (int i = 0; i < n; i++)
				a[i] = t.nextInt();

			for (int i = 0; i < n - 1; i++) {
				if ((a[i] - a[i + 1]) % 2 != 0) {
					flag = 1;
					break;
				}
			}

			if (flag == 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

}