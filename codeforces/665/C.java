import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Simple_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);
		String s = t.next();
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			char ch = 'a';

			if (sb.charAt(i - 1) == s.charAt(i)) {

				for (char p = 'a'; p <= 'z'; p++) {
//					char p = (char) (ch + j);
					boolean ok = i + 1 < s.length() ? s.charAt(i + 1) != p : true;
					if (s.charAt(i - 1) != p && ok) {
						sb.append(p);
						break;
					}

//					System.out.println("ok");
				}
			} else {
				sb.append(s.charAt(i));
			}
		}

		System.out.println(sb);
	}

}