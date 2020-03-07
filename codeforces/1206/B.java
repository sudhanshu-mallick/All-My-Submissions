import java.util.Scanner;

public class Make_Product_Equal_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner r = new Scanner(System.in);
		int n = r.nextInt();
		int a[] = new int[n];
		int m1 = 0, p1 = 0, z = 0;
		long cost = 0;

		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt();

			if (a[i] > 0) {
				p1++;
				cost += a[i] - 1;
			} else if (a[i] < 0) {
				m1++;
				cost += -1 - a[i];
			} else
				z++;
		}

		if (m1 % 2 == 1 && z == 0) {
			cost += 2;
		} else {
			cost += z;
		}

		System.out.println(cost);
	}

}
