import java.util.HashSet;
import java.util.Scanner;

public class Hyperset {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int k = t.nextInt();
		HashSet<String> map = new HashSet<>();
		String[] a = new String[n];
		long count = 0;

		for (int i = 0; i < n; i++) {
			a[i] = "";
			a[i] = t.next();
			map.add(a[i]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				StringBuilder sb = new StringBuilder("");

				for (int p = 0; p < k; p++) {
					if (a[i].charAt(p) == a[j].charAt(p))
						sb.append(a[i].charAt(p));
					else {
						String s = Character.toString(a[i].charAt(p)) + Character.toString(a[j].charAt(p));

						if (s.equals("ST") || s.equals("TS"))
							sb.append("E");
						else if (s.equals("ET") || s.equals("TE"))
							sb.append("S");
						else
							sb.append("T");
					}
				}

				if (map.contains(sb.toString()))
					count++;
			}
		}

		System.out.println(count / 3);
	}

}
