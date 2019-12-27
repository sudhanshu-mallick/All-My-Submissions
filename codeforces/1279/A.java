import java.util.Scanner;

public class New_Year_Garland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			long r = t.nextLong();
			long g = t.nextLong();
			long b = t.nextLong();
			long max = 0;

			if (r >= g && r >= b) {
				if (g + b >= r - 1)
					System.out.println("Yes");
				else
					System.out.println("No");

			} else if (g >= b && g >= r) {
				if (r + b >= g - 1)
					System.out.println("Yes");
				else
					System.out.println("No");
			} else {
				if (r + g >= b - 1)
					System.out.println("Yes");
				else
					System.out.println("No");
			}

		}

	}

}