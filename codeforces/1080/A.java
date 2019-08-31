import java.util.Scanner;

public class Petya_Orgami {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int friends = t.nextInt();
		int pages = t.nextInt();
		int notebooks = 0;

		if ((2 * friends) % pages == 0)
			notebooks += (2 * friends) / pages;
		else
			notebooks += (2 * friends) / pages + 1;

		if ((8 * friends) % pages == 0)
			notebooks += (8 * friends) / pages;
		else
			notebooks += (8 * friends) / pages + 1;

		if ((5 * friends) % pages == 0)
			notebooks += (5 * friends) / pages;
		else
			notebooks += (5 * friends) / pages + 1;

		System.out.println(notebooks);
	}

}