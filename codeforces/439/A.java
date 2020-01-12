import java.util.Scanner;

public class Devu_And_Churu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int d = t.nextInt();
		int cur = 0, cost = 0, flag = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n; i++) {
			if (i < n - 1) {
				cost += 10;
				cur += 2;
			}

			cost += a[i];
		}

		if (cost > d)
			System.out.println(-1);
		else
			System.out.println((d - cost) / 5 + cur);

	}

}
