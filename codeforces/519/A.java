import java.util.Scanner;

public class A_And_B_And_Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);
		char[][] ch = new char[8][8];
		String s = "";
		int[] cost = new int[4];
		cost[0] = 9;
		cost[1] = 5;
		cost[2] = 3;
		cost[3] = 1;
		int black = 0, white = 0;

		for (int i = 0; i < 8; i++) {
			s = t.next();

			for (int j = 0; j < 8; j++) {
				ch[i][j] = s.charAt(j);
				char c = ch[i][j];

				if (c == 'Q')
					white += cost[0];
				else if (c == 'R')
					white += cost[1];
				else if (c == 'B' || c == 'N')
					white += cost[2];
				else if (c == 'P')
					white += cost[3];
				else if (c == 'q')
					black += cost[0];
				else if (c == 'r')
					black += cost[1];
				else if (c == 'b' || c == 'n')
					black += cost[2];
				else if (c == 'p')
					black += cost[3];
			}
		}

		if (black > white)
			System.out.println("Black");
		else if (white > black)
			System.out.println("White");
		else
			System.out.println("Draw");
	}

}
