import java.util.Scanner;

public class Tokitsukaze_and_Enhancement {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();

		if (n % 4 == 0)
			System.out.println("1 A");
		else if (n % 4 == 1)
			System.out.println("0 A");
		else if (n % 4 == 2)
			System.out.println("1 B");
		else
			System.out.println("2 A");
	}

}