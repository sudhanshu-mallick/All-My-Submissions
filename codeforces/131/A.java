import java.util.Scanner;

public class Caps_Lock {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		int flag = 0;

		for (int i = 1; i < s.length(); i++) {
			if (!Character.isUpperCase(s.charAt(i))) {
				flag = 1;
				break;
			}
		}

		if (flag == 1)
			System.out.println(s);
		else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				c = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
				System.out.print(c);
			}
		}
	}

}
