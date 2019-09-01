import java.util.Scanner;

public class Bachgold_Problem {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int div2 = 0;

		if (n == 2 || n == 3) {
			System.out.println(1);
			System.out.println(n);
		} else if (n % 2 == 0) {
			div2 = n / 2;
			System.out.println(div2);

			while (div2-- > 0)
				System.out.print(2 + " ");
		} else {
			div2 = (n - 3) / 2;
			System.out.print(div2 + 1 + "\n" + 3 + " ");

			while (div2-- > 0)
				System.out.print(2 + " ");
		}

	}

}