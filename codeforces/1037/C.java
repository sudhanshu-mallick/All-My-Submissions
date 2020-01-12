import java.util.Scanner;

public class Equalize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		String s1 = "", s2 = "";
		s1 = t.next();
		s2 = t.next();
		int cost = 0;

		for (int i = 0; i < n; i++) {
			if (s1.charAt(i) == s2.charAt(i)) {

			} else {
				if (i + 1 < n && s1.charAt(i + 1) != s2.charAt(i + 1)) {
					if (s1.charAt(i) == s2.charAt(i + 1)) {
						cost += 1;
						i++;
					} else
						cost += 1;
				} else
					cost += 1;
			}
		}

		System.out.println(cost);

	}

}
