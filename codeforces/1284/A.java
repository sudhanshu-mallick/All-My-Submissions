import java.util.Scanner;

public class New_Year_And_Naming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int m = t.nextInt();
		int n = t.nextInt();
		String[] s1 = new String[m];
		String[] s2 = new String[n];

		for (int i = 0; i < m; i++) {
			String s = "";
			s = t.next();
			s1[i] = s;
		}

		for (int i = 0; i < n; i++) {
			String s = "";
			s = t.next();
			s2[i] = s;
		}

		int test = t.nextInt();

		while (test-- > 0) {
			int a = t.nextInt();
			int i1 = a % m == 0 ? m - 1 : a % m - 1;
			int i2 = a % n == 0 ? n - 1 : a % n - 1;

			System.out.println(s1[i1] + s2[i2]);
		}
	}

}
