import java.util.Scanner;

public class Nearly_Lucky_Number {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		String s = new String();
		s = t.next();

		int lucky = 0;

		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '4' || s.charAt(i) == '7')
				lucky++;

		s = Integer.toString(lucky);
		boolean flag = true;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '4' && s.charAt(i) != '7') {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
