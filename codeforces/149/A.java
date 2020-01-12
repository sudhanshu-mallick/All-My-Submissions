import java.util.Arrays;
import java.util.Scanner;

public class Business_Trip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int k = t.nextInt();
		int[] a = new int[12];

		for (int i = 0; i < 12; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		int sum = 0;

		for (int i = 11; i >= 0; i--) {
			if (sum >= k) {
				System.out.println(11 - i);
				return;
			}

			sum += a[i];
		}

		if (sum >= k) {
			System.out.println(12);
			return;
		}

		System.out.println(-1);
	}

}
