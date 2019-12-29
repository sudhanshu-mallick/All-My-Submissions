import java.util.Scanner;

public class Cheap_Travels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int m = t.nextInt();
		int a = t.nextInt();
		int b = t.nextInt();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= n; i++) {
			int a1 = i;
			int b1 = (n - i) % m == 0 ? (n - i) / m : (n - i) / m + 1;
			int cost = a1 * a + b1 * b;

			if (min > cost)
				min = cost;
		}

		System.out.println(min);
	}

}
