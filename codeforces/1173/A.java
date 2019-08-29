import java.util.Scanner;

public class Nannu_and_Votes {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int x = t.nextInt();
		int y = t.nextInt();
		int z = t.nextInt();

		int up = x - y - z;
		int down = x - y + z;

		if (up > 0 && down > 0) {
			System.out.println("+");
		} else if (up > 0 && down == 0) {
			System.out.println("?");
		} else if (up > 0 && down < 0) {
			System.out.println("?");
		} else if (up == 0 && down > 0) {
			System.out.println("?");
		} else if (up == 0 && down == 0) {
			System.out.println("0");
		} else if (up == 0 && down < 0) {
			System.out.println("?");
		} else if (up < 0 && down > 0) {
			System.out.println("?");
		} else if (up < 0 && down == 0) {
			System.out.println("?");
		} else {
			System.out.println("-");
		}

	}

}