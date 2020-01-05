import java.util.Scanner;

public class Angry_Students {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			String s = "";
			s = t.next();
			int max = 0, cur_max = 0;

			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == 'A') {
					i++;

					while (i < n && s.charAt(i) == 'P') {
						cur_max++;
						i++;
					}

					max = Math.max(max, cur_max);
					i--;
					cur_max = 0;
				}
			}

			System.out.println(max);
		}
	}

}
