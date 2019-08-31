import java.util.Scanner;

public class Drinks {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		float sum = 0;
		float a;

		for (int i = 0; i < n; i++) {
			sum += t.nextInt();
		}

		a = sum / n;

		System.out.println(a);

	}

}