import java.util.Scanner;

public class Team {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int count = 0;

		while (n-- > 0) {
			byte a = t.nextByte();
			byte b = t.nextByte();
			byte c = t.nextByte();

			if (a + b + c >= 2)
				count++;
		}

		System.out.println(count);

	}

}
