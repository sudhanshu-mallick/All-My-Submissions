import java.util.Scanner;

public class Vanya_And_Fence {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int h = t.nextInt();
		int sh, width = 0;

		while (n-- > 0) {
			sh = t.nextInt();

			if (sh > h)
				width += 2;
			else
				width++;
		}

		System.out.println(width);

	}

}
