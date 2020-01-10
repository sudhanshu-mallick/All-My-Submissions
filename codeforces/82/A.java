import java.util.Scanner;

public class Double_Cola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		long n = t.nextLong();
		long i = 1;
		String[] a = { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };

		while (i * 5 < n) {
			n -= i * 5;
			i *= 2;
		}

		System.out.println(a[(int) ((n - 1) / i)]);

	}

}
