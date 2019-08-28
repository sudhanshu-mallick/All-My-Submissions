import java.util.Scanner;

public class Anton_and_Polyhedron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner t = new Scanner(System.in);

		int n = t.nextInt();
		String s = "";
		int face = 0;

		while (n-- > 0) {
			s = t.next();
			if (s.equals("Tetrahedron"))
				face += 4;
			else if (s.equals("Cube"))
				face += 6;
			else if (s.equals("Octahedron"))
				face += 8;
			else if (s.equals("Dodecahedron"))
				face += 12;
			else
				face += 20;
		}

		System.out.println(face);
	}

}