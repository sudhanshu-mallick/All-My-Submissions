import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Less_Or_Equal_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		PrintWriter o = new PrintWriter(System.out);

		int n = t.nextInt();
		Integer a[] = new Integer[n];
		int m = t.nextInt();
		int b[] = new int[m];

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < m; i++)
			b[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < m; i++) {
			int p = pos(a, 0, n, b[i]);

			o.printf("%d ", p);
		}

		o.close();

	}

	public static int pos(Integer[] a, int l, int h, int p) {
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
