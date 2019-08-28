import java.util.Scanner;

public class Bear_and_Brother {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int limak = t.nextInt();
		int bob = t.nextInt();
		int year = 0;

		while (limak <= bob) {
			limak *= 3;
			year++;
			bob *= 2;
		}

		System.out.println(year);
	}

}
