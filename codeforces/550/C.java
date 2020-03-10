import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Divisiblility_By_Eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		OutputStream out = System.out;
		Scanner t = new Scanner(in);
		PrintWriter writ = new PrintWriter(out);
		StringBuilder s = new StringBuilder(t.next());
		int n = s.length();
		char p, q, r;
		int odd = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '0' || s.charAt(i) == '8') {
				System.out.println("YES");
				System.out.println(s.charAt(i));
				return;
			}

			if (s.charAt(i) % 2 == 1)
				odd++;
		}

		if (odd == n) {
			System.out.println("NO");
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String res = Character.toString(s.charAt(i)) + Character.toString(s.charAt(j));

				if (Integer.valueOf(res) % 8 == 0) {
					System.out.println("YES");
					System.out.println(Integer.valueOf(res));
					return;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					String res = Character.toString(s.charAt(i)) + Character.toString(s.charAt(j))
							+ Character.toString(s.charAt(k));

					if (Integer.valueOf(res) % 8 == 0) {
						System.out.println("YES");
						System.out.println(Integer.valueOf(res));
						return;
					}
				}
			}

		}

		System.out.println("NO");
	}

}
