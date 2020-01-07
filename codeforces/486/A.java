import java.util.Scanner;

public class Calculating_Function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		long n = t.nextLong();

		if (n % 2 == 0) {
			System.out.println(n / 2);
		} else {
			System.out.println(-(n + 1) / 2);
		}
	}

}