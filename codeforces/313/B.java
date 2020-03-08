import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ilya_And_Queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String s = "";
		s = t.next();
		int m = t.nextInt();
		int[] a = new int[s.length()];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i))
				a[i] = 1 + a[i - 1];
			else
				a[i] = a[i - 1];
		}

		while (m-- > 0) {
			int i = t.nextInt();
			int j = t.nextInt();

			sb.append(a[j - 1] - a[i - 1] + "\n");
		}

		System.out.println(sb);
	}

}
