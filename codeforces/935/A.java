import java.util.Scanner;

public class Fafa_And_Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int c = 0;

		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i)
					c++;
				else
					c += 2;
			}
		}
		System.out.println(c - 1);
	}

}