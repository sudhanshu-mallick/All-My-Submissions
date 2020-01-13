import java.util.Scanner;

public class Football_43A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		String s1 = "", s2 = "", s = "";
		s1 = t.next();
		int one = 1, two = 0;

		for (int i = 1; i < n; i++) {
			s = t.next();

			if (s1.equals(s))
				one++;
			else {
				s2 = s2.length() == 0 ?  s : s2;
				two++;
			}
		}

		if (one > two)
			System.out.println(s1);
		else
			System.out.println(s2);
	}

}
