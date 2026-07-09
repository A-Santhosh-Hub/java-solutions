import java.util.*;

class Divide {
    public static void main(String[] args) {
     Scanner in = new Scanner (System.in);   
    
    System.out.println("Hey");
     System.out.println("Enter the 1 number");
    int a = in.nextInt();
    System.out.println("Enter the 2 number");
    int b = in.nextInt();
    
    System.out.println("Enter the 3 number");
    int c = in.nextInt();
    int d = a*b*c;
    int e = a+b+c;
    
    
    
    System.out.println(d);
    System.out.println(e);
    System.out.println("The value Is: "+(d/e));


    }
    
}
