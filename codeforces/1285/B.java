import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Just_Eat_It {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long[] a = new long[n];
			long sumb = 0, suma = 0;
			boolean flag = true;

			for (int i = 0; i < n; i++) {
				a[i] = t.nextLong();
			}

			for (int i = 0; i < n; i++) {
				sumb += a[i];
				suma += a[n - i - 1];

				if (sumb <= 0 || suma <= 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				o.println("YES");
			else
				o.println("NO");
		}

		o.close();
	}
}
