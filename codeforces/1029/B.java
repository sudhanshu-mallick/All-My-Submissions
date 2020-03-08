import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Creating_The_Contest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int n = t.nextInt();
		int[] a = new int[n];
		int max = 1, cmax = 1;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n - 1; i++) {
			if (2 * a[i] >= a[i + 1])
				cmax++;
			else
				cmax = 1;

			max = Math.max(cmax, max);
		}

		o.println(max);
		
		o.close();
	}

}
