import java.util.*;
import java.lang.*;
import java.io.*;

public class String_S {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
			String s1 = "", s2 = "QAQ";
			s1 = t.next();
			int m=s1.length();
			int n=3;
			int[][] a=new int[m+1][n+1];
			
			for(int i=0;i<=m;i++){
			    a[i][0]=1;
			}
			
			for(int i=1;i<=m;i++){
			    for(int j=1;j<=n;j++){
			        if(s1.charAt(i-1)==s2.charAt(j-1))
			        a[i][j]=a[i-1][j-1]+a[i-1][j];
			        else
			        a[i][j]=a[i-1][j];
			    }
			}
			
			System.out.println(a[m][n]);
	}
}