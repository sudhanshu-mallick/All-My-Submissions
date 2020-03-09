import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cutting {

	public static void main(String[] args) {
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int n = t.nextInt();
		int[] a = new int[n];
		int b = t.nextInt();
		ArrayList<Integer> cut = new ArrayList<>();
		int odd = 0, even = 0, csum = 0, count = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (i != 0 && i != n - 1) {
				if (even == odd) {
					cut.add(Math.abs(a[i] - a[i - 1]));
					odd = 0;
					even = 0;
				}
			}

			if (a[i] % 2 == 0)
				even++;
			else
				odd++;
		}

		Collections.sort(cut);

		for (int i = 0; i < cut.size(); i++) {
			csum += cut.get(i);

			if (csum <= b)
				count++;
			else
				break;
		}

		o.println(count);
		o.close();
	}
}
