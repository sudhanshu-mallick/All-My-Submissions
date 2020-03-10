import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
public class Bogsort {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int test = t.nextInt();
 
		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
 
			for (int i = 0; i < n; i++) {
				a[i] = t.nextInt();
			}
 
			Arrays.sort(a);
 
			for (int i = 0; i < n; i++)
				o.print(a[n - i - 1] + " ");
 
			o.println();
		}
 
		o.close();
	}
 
}