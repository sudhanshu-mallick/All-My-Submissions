import java.util.Scanner;

public class Kefa_And_First_Step {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int[] a = new int[n];
		int max = 1, cmax = 1;
		a[0] = t.nextInt();

		for (int i = 1; i < n; i++) {
			a[i] = t.nextInt();

			if (a[i] >= a[i - 1])
				cmax++;
			else
				cmax = 1;

			max = Math.max(cmax, max);
		}

		max = Math.max(cmax, max);

		System.out.println(max);

	}

}
