import java.util.Scanner;

public class The_Door {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int[] a = new int[n];
		int left = 0, right = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] == 0)
				left = i + 1;
			else
				right = i + 1;
		}

		if (left < right)
			System.out.println(left);
		else
			System.out.println(right);
	}

}
