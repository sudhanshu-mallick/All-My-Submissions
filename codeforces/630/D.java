
import java.util.Scanner;

public class Shower_Line {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		long n = t.nextLong();
		long sum = 1 + 3 * (n * (n + 1));

		System.out.println(sum);
	}

}
