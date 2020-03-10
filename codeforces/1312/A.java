import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class Two_Regular_polygons {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		int n = t.nextInt();
 
		while (n-- > 0) {
			int p = t.nextInt();
			int q = t.nextInt();
 
			if (p % q == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
 
}