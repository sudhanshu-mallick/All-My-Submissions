import java.util.Scanner;

public class Card_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int te = t.nextInt();

		while (te-- > 0) {
			int n = t.nextInt();
			int k1 = t.nextInt();
			int k2 = t.nextInt();
			int input = 0, player = 0;

			for (int i = 0; i < k1; i++) {
				input = t.nextInt();

				if (input == n)
					player = 1;
			}

			for (int i = 0; i < k2; i++) {
				input = t.nextInt();

				if (input == n)
					player = 2;
			}

			if (player == 1)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

}
