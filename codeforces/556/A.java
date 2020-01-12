import java.util.Scanner;

public class Cases_Of_Zeros_And_Ones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		String s = "";
		s = t.next();
		int a, even = 0, odd = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '0')
				even++;
			else
				odd++;
		}

		System.out.println(n - 2 * Math.min(even, odd));
	}

}
