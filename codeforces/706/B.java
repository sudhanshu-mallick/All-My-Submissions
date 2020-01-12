import java.util.Arrays;
import java.util.Scanner;

public class Interesting_Drink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		int test = t.nextInt();

		while (test-- > 0) {
			int p = t.nextInt();

			System.out.println(pos(a, 0, n, p));
		}

	}

	public static int pos(int[] a, int l, int h, int p) {
		while (l < h) {
			int m = (l + h) / 2;

			if (a[m] <= p)
				l = m + 1;
			else
				h = m;
		}

		return l;
	}
}
