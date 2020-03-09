import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Worms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int n = t.nextInt();
		int[] a = new int[n];
		int b[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (i == 0)
				b[i] = a[i];
			else
				b[i] = a[i] + b[i - 1];
		}

		int m = t.nextInt();

		while (m-- > 0) {
			int moles = t.nextInt();

			if (moles <= b[0]) {
				o.println(1);
			} else
				o.println(bs(moles, b, 0, n - 1) + 1);
		}

		o.close();
	}

	static int bs(int moles, int[] b, int si, int ei) {
		int mid = (si + ei) / 2;

		if (si >= ei)
			return -1;

		if (si + 1 == ei) {
//			if (b[si] <= moles && b[ei] >= moles)
			return ei;
		}

		if (moles <= b[mid])
			return bs(moles, b, si, mid);
		else
			return bs(moles, b, mid, ei);
	}

}
