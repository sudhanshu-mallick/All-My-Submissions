import java.util.Scanner;

public class Points_in_Segments {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int q = t.nextInt();
		int n = t.nextInt();
		boolean[] path = new boolean[n];
		int count = n;

		while (q-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();

			for (int i = a - 1; i <= b - 1; i++) {
				if (path[i] == false)
					count--;

				path[i] = true;
			}
		}

		System.out.println(count);

		for (int i = 0; i < n; i++)
			if (!path[i])
				System.out.print(i + 1 + " ");

	}

}
