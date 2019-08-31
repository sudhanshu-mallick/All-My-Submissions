import java.util.Scanner;

public class Mishka_And_Game {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int a, b, winm = 0, winc = 0;

		while (n-- > 0) {
			a = t.nextInt();
			b = t.nextInt();

			if (a > b)
				winm++;
			else if (b > a)
				winc++;
		}

		if (winm > winc)
			System.out.println("Mishka");
		else if (winc > winm)
			System.out.println("Chris");
		else
			System.out.println("Friendship is magic!^^");

	}

}
