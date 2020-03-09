import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dreamoon_And_Wifi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter o = new PrintWriter(out);
		String s1 = "", s2 = "";
		s1 = t.next();
		s2 = t.next();
		int pos1 = 0, pos2 = 0, question = 0;
		double ans = 0d;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == '+')
				pos1++;
			else
				pos1--;

			if (s2.charAt(i) == '+')
				pos2++;
			else if (s2.charAt(i) == '-')
				pos2--;
			else
				question++;
		}

		if (pos1 == pos2 && question == 0) {
			o.println(1.000000000);
			o.close();
			return;
		}

		if (Math.abs(pos1 - pos2) > question) {
			o.println(ans);
			o.close();
			return;
		}

		if (Math.abs(pos1 - pos2) == question) {
			ans = Math.pow(2, -Math.abs(pos1 - pos2));
			o.println(ans);
			o.close();
			return;
		}

		int d = Math.abs(pos1 - pos2);

		if ((question - d) % 2 == 0) {
			long top = comb(question, (question - d) / 2 + d);
			double bot = Math.pow(2, -question);
			ans = bot * top;

			o.println(ans);
		} else {
			o.println(ans);
		}

		o.close();
	}

	private static long comb(int n, int k) {
		long ncr[] = new long[k + 1];
		ncr[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--)
				ncr[j] = ncr[j] + ncr[j - 1];
		}
		return ncr[k];
	}
}
