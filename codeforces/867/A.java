import java.util.Scanner;

public class Between_the_Office {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		s = t.next();
		int se = 0, sf = 0;

		for (int i = 0; i < n - 1; i++) {
			if (s.substring(i, i + 2).equals("SF"))
				se++;
			else if (s.substring(i, i + 2).equals("FS"))
				sf++;
		}

		if (se > sf)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
