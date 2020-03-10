import java.util.Scanner;

public class Flipping_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int one = 0, sum = 0, csum = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] % 2 == 1) {
				one++;
				csum--;
			} else
				csum++;

			sum = Math.max(sum, csum);
			csum = Math.max(0, csum);
		}

		if (n == one)
			sum = n - 1;
		else
			sum = one + sum;

		System.out.println(sum);
	}

}
