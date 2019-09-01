import java.util.Scanner;

public class Bus_to_Udayland {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String[] s = new String[n];
		int avail = 0;

		for (int i = 0; i < n; i++) {
			s[i] = "";
			s[i] = t.next();

			if (avail == 0) {
				if (s[i].charAt(0) == 'O' && s[i].charAt(1) == 'O') {
					avail = 1;
					s[i] = "++|" + s[i].substring(3);
				}
			}
			if (avail == 0) {
				if (s[i].charAt(3) == 'O' && s[i].charAt(4) == 'O') {
					avail = 1;
					s[i] = s[i].substring(0, 2) + "|++";
				}
			}
		}

		if (avail == 1) {
			System.out.println("YES");

			for (int i = 0; i < n; i++)
				System.out.println(s[i]);
		} else
			System.out.println("NO");

	}

}