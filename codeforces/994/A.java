import java.util.Scanner;

public class Fingerprints {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int m = t.nextInt();
		int n = t.nextInt();
		int[] ss = new int[m];
		int[] print = new int[n];

		for (int i = 0; i < m; i++)
			ss[i] = t.nextInt();

		for (int i = 0; i < n; i++)
			print[i] = t.nextInt();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				if (ss[i] == print[j])
					System.out.print(ss[i] + " ");
		}

	}

}
