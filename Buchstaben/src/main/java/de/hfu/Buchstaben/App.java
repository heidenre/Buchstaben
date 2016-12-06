package de.hfu.Buchstaben;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        System.out.println(s.toUpperCase());
        sc.close();
    }
}
