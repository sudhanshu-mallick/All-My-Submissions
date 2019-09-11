import java.util.Scanner;

public class George_and_Accommodation {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int rooms = 0;

		while (n-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();

			if (b - a >= 2)
				rooms++;
		}

		System.out.println(rooms);

	}

}
