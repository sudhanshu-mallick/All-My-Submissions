import java.util.Scanner;

public class Bear_and_Reverse_Radewoosh {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int n = t.nextInt();
		int k = t.nextInt();
		int[] score = new int[n];
		int[] time = new int[n];

		for (int i = 0; i < n; i++)
			score[i] = t.nextInt();

		for (int i = 0; i < n; i++)
			time[i] = t.nextInt();

		int Limak = 0, Radewoosh = 0, t1 = 0, t2 = 0;

		for (int i = 0; i < n; i++) {
			t1 += time[i];
			t2 += time[n - i - 1];

			Limak += Math.max(0, score[i] - k * t1);
			Radewoosh += Math.max(0, score[n - i - 1] - k * t2);
		}

		if (Limak > Radewoosh)
			System.out.println("Limak");
		else if (Radewoosh > Limak)
			System.out.println("Radewoosh");
		else
			System.out.println("Tie");

	}

}
