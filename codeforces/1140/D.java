import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Minimum_Triangulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);
		int n = t.nextInt();
		long sum = 0;

		for (int i = 2; i < n; i++)
			sum += i * (i + 1);

		writ.println(sum);
		
		writ.close();
	}
}