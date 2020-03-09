import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Currency_System_In_Geraldion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int n = t.nextInt();
		int[] a = new int[n];
		int min = t.nextInt();
		a[0] = min;

		for (int i = 1; i < n; i++) {
			a[i] = t.nextInt();

			min = Math.min(min, a[i]);
		}

		if (min == 1)
			o.println(-1);
		else
			o.println(1);

		o.close();
	}

}
