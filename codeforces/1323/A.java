import java.util.Scanner;

public class Even_Subset_Sum_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			int even = 0, idx = 0;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();

				if (a[i] % 2 == 0) {
					even++;
					idx = i + 1;
				}

			}

			if (even > 0) {
				System.out.println(1);
				System.out.println(idx);
			} else if (n > 1) {
				System.out.println(2);
				System.out.println(1 + " " + 2);

			} else {
				System.out.println(-1);
			}
		}
	}

}
