import java.util.Scanner;

public class Cormen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt(), k = t.nextInt();
		int[] a = new int[n + 2];
		a[0] = a[n + 1] = k;
		int[] b = new int[n];
		int cost = 0;

		for (int i = 1; i <= n; i++)
			a[i] = t.nextInt();

		for (int i = 1; i <= n; i++) {
			int cur = Math.max(a[i], k - a[i - 1]);
			cost += cur - a[i];
			a[i] = cur;
			b[i - 1] = cur;
		}

		System.out.println(cost);

		for (int i = 0; i < n; i++)
			System.out.print(b[i] + " ");
	}

}
