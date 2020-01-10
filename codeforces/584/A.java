import java.util.Scanner;

public class Olesya_And_Radion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		String s = "";
		s = t.next();

		if (s.length() > n)
			System.out.println(-1);
		else {
			System.out.print(s);

			for (int i = 0; i < n - s.length(); i++)
				System.out.print(0);
		}

	}

}