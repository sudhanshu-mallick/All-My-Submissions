import java.util.Scanner;

public class Yet_Another_Meme_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			long n = t.nextLong();
			String s = "";
			s = t.next();
			long ans = 0;
			int flag = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '9') {
					flag = 1;
					break;
				}
			}

			if (flag == 1)
				ans = n * (long) (s.length() - 1);
			else
				ans = n * (long) (s.length());

			System.out.println(ans);
		}
	}

}
