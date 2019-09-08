import java.util.Scanner;

public class Golden_Plate {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		int w = t.nextInt();
		int h = t.nextInt();
		int k = t.nextInt();
		int plate = 0;

		while (k-- > 0) {
			plate += w * 2 + (h - 2) * 2;
			w -= 4;
			h -= 4;
		}

		System.out.println(plate);

	}

}