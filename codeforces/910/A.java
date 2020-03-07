import java.util.Scanner;

public class The_Way_To_Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int k = t.nextInt();
		String s = "";
		int jumps = 0, i = 0;
		s = t.next();

		while (i < n) {
			if (jumps == -1) {
				System.out.println(-1);
				return;
			}

			int flag = i;

			for (int p = k; p >= 1; p--) {
				if (i + p < n) {
					if (s.charAt(i + p) == '1') {
						jumps++;
						i = i + p;

						if (i == n - 1) {
							System.out.println(jumps);
							return;
						}

						break;
					} else {
						if (i + p == flag + 1) {
							jumps = -1;
							break;
						}
					}
				} else {

				}
			}
		}
	}

}
