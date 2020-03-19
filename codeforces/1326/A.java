import java.util.Scanner;

public class Bad_Ugly_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			StringBuilder s = new StringBuilder();

			int n = t.nextInt();

			if (n == 1)
				System.out.println(-1);
			else {
				s.append('2');

				for (int i = 0; i < n - 1; i++)
					s.append('3');

				System.out.println(s);
			}

		}
	}

}
