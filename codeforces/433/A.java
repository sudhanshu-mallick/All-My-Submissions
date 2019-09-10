import java.util.Scanner;

public class Kitahara_Harukis_Gift {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int two = 0, one = 0;

		for (int i = 0; i < n; i++) {
			int a = t.nextInt();

			if (a == 200)
				two++;
			else
				one++;
		}

		if (two % 2 == 0 && one % 2 == 0)
			System.out.println("YES");
		else if (one % 2 == 1)
			System.out.println("NO");
		else {
			if (one == 0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
