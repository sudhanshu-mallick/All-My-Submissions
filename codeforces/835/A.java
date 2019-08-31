import java.util.Scanner;

public class Key_Races {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int s = t.nextInt();
		int v1 = t.nextInt();
		int v2 = t.nextInt();
		int t1 = t.nextInt();
		int t2 = t.nextInt();

		if ((s * v1 + 2 * t1) > (s * v2 + 2 * t2))
			System.out.println("Second");

		else if ((s * v1 + 2 * t1) < (s * v2 + 2 * t2))
			System.out.println("First");

		else
			System.out.println("Friendship");

	}

}