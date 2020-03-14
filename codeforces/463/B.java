
import java.util.Scanner;

public class Caisa_And_Pylon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt(), cost = 0, height = 0;
		int[] a = new int[n + 1];

		for (int i = 0; i < n; i++)
			a[i + 1] = t.nextInt();

		for (int i = 0; i < n; i++) {
			height += a[i] - a[i + 1];

			if (height < 0) {
				cost += -height;
				height = 0;
			}
		}

		System.out.println(cost);

	}

}
