import java.util.Scanner;

public class Minutes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();

		while (n-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();
				System.out.println((23 - a) * 60 + (60 - b));
		}

	}

}