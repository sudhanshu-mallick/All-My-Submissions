import java.util.Scanner;

public class String_Task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		StringBuilder ans = new StringBuilder("");

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o'
					|| ch == 'U' || ch == 'u' || ch == 'Y' || ch == 'y') {
				//
			} else if (Character.isUpperCase(ch)) {
				ans.append(".");
				ans.append(Character.toLowerCase(ch));
			} else {
				ans.append(".");
				ans.append(ch);
			}
		}

		System.out.println(ans);
	}

}
