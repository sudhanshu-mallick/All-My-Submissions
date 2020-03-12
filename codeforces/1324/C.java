import java.util.Scanner;

public class Frog_Jumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			StringBuilder s = new StringBuilder(t.next());
			int csum = 1, sum = 1;
			int n = s.length();

			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == 'R') {
					sum = Math.max(sum, csum);
					csum = 1;
				} else {
					csum++;
				}
			}

			sum = Math.max(sum, csum);

			System.out.println(sum);
		}
	}

}
