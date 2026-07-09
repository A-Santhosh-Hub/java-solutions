import java.util.*;

public class Student {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hey Student Enter Your Name: ");
        String name = in.nextLine();
        
        System.out.println("Ok Mr."+name+" Now Enter You Mark:");
        Double mark = in.nextDouble();
       in.nextLine();
        System.out.println("Ok Mr."+name+" Now Enter Your Department:-");
        String course = in.nextLine();

        System.out.println("Ok Mr."+name+" Now Conform Your Deatile Is Correct or Not :");
        System.out.println("My Name Is: "+name);
        System.out.println("My Mark Is "+(mark/10)+"/10");
        System.out.println("My Department Is: "+course);



    }
}
