import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Bersu_Ball {
	public static void main(String[] args) {
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int m = t.nextInt();
		int[] boys = new int[m];

		for (int i = 0; i < m; i++)
			boys[i] = t.nextInt();

		int n = t.nextInt();
		int[] girls = new int[n];

		for (int i = 0; i < n; i++)
			girls[i] = t.nextInt();

		int count = 0;

		Arrays.sort(boys);
		Arrays.sort(girls);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(boys[i] - girls[j]) <= 1) {
					girls[j] = 102;
					count++;
					break;
				}
			}
		}

		o.println(count);
		o.close();
	}
}
