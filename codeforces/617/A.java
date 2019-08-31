import java.util.Scanner;

public class Elephant {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int dist = t.nextInt();
		int steps = 0;

		steps += dist / 5;
		dist = dist % 5;

		steps += dist / 4;
		dist = dist % 4;

		steps += dist / 3;
		dist = dist % 3;

		steps += dist / 2;
		dist = dist % 2;

		steps += dist / 1;
		dist = dist % 1;

		System.out.println(steps);
	}

}