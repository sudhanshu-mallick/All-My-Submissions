import java.util.Scanner;

public class Nastya_is_Reading_a_Book {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		int count = 0;
		int page[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			page[i][0] = t.nextInt();
			page[i][1] = t.nextInt();
		}

		int idx = t.nextInt();

		for (int i = 0; i < n; i++) {
			if (idx >= page[i][0] && idx <= page[i][1]) {
				count = n - i;
				break;
			}
		}

		System.out.println(count);

	}

}
