import java.util.Scanner;

public class Telephone_Number {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		while (n-- > 0) {
			int a = t.nextInt();
			String s = "";
			s = t.next();
			boolean flag = false;
			int eight = 0;

			for (int i = 0; i < a; i++) {
				if (s.charAt(i) == '8') {
					flag = true;
					eight = i;
					break;
				}
			}

			if (flag && a - eight - 1 >= 10)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}