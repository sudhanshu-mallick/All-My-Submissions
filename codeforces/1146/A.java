import java.util.Scanner;

public class Loave_A {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		String s = "";
		s = t.next();
		int a = 0, b = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				a++;
			else
				b++;
		}
		
		if (a > b)
			System.out.println(a + b);
		else
			System.out.println(2 * a - 1);

	}

}