import java.util.Scanner;

public class Drazil_And_A_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		long a = t.nextLong();
		long b = t.nextLong();
		long c = t.nextLong();

		if (Math.abs(a) + Math.abs(b) > c)
			System.out.println("No");
		else {
			if ((c - (Math.abs(a) + Math.abs(b))) % 2 == 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
