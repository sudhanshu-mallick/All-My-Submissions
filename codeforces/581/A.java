import java.util.Scanner;

public class Vasya_The_Hipster {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int red = t.nextInt();
		int blue = t.nextInt();
		int trend = 0, bore = 0;

		trend = Math.min(red, blue);
		bore = (Math.max(red, blue) - trend) / 2;

		System.out.println(trend + " " + bore);

	}

}
