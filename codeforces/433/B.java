import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Kuriyama_Mirai_Stones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);
		int n = t.nextInt();
		Integer[] a = new Integer[n];
		long[] b = new long[n];
		long[] c = new long[n];

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (i == 0)
				b[i] = a[i];
			else
				b[i] = b[i - 1] + a[i];

		}

		int queries = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n; i++) {
			if (i == 0)
				c[i] = a[i];
			else
				c[i] = c[i - 1] + a[i];
		}

		while (queries-- > 0) {
			int p = t.nextInt();
			int q = t.nextInt();
			int r = t.nextInt();

			if (p == 1) {
				if (q == 1) {
					writ.println(b[r - 1]);
				} else {
					writ.println(b[r - 1] - b[q - 2]);
				}
			} else {
				if (q == 1) {
					writ.println(c[r - 1]);
				} else {
					writ.println(c[r - 1] - c[q - 2]);
				}
			}

		}

		writ.close();

	}

}
