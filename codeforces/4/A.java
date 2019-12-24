import java.util.Scanner;

public class Watermelon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();

		if (n % 2 == 0 && n >= 4)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
