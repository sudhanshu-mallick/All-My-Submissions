import java.util.*;
import java.io.*;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt() - 1;
		long[] a = new long[n + 1];
		long[] b = new long[n];
		long min = 0, sum = 0;
		Set<Long> set = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextLong();
			sum += b[i];
			min = Math.min(min, sum);
		}

		a[0] = 1 - min;

		set.add(a[0]);

		for (int i = 1; i <= n; ++i) {
			a[i] = a[i - 1] + b[i - 1];

			set.add(a[i]);
		}

		boolean f = true;

		for (int i = 0; i < n + 1; ++i)
			if (a[i] < 1 || a[i] > n + 1)
				f = false;

		if (set.size() != n + 1)
			f = false;

		if (f)
			for (int i = 0; i <= n; ++i)
				o.print(a[i] + " ");
		else
			o.println("-1");

		o.flush();
		o.close();
	}
}
