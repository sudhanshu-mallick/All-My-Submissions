import java.util.Scanner;

public class Dubstep {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		String s = "";
		s = t.next();
		StringBuilder sb = new StringBuilder("");
		int flag = -1;

		for (int i = 0; i < s.length(); i++) {
			if (i + 2 < s.length() && s.substring(i, i + 3).equals("WUB")) {
				i += 2;

				if (flag == 0) {
					sb.append(" ");
					flag = 1;
				}
			} else {
				sb.append(s.charAt(i));
				flag = 0;
			}
		}

		System.out.println(sb);
	}

}
