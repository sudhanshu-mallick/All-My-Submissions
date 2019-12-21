import java.util.Scanner;

public class Equation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();

		if (n % 2 == 0) {
			System.out.println( (4 + n)+" "+4);
		} else {
			System.out.println((9 + n)+" "+9);
		}
	}

}
