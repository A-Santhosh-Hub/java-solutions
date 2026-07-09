import java.util.*;
class Forloop1 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        System.out.println("Enter the Number");
        int num = in.nextInt();
        

        System.out.println("Enter the Lemit");
        int l =in.nextInt();

        for(int i=1;i<=l;i++){
            System.out.println(i+" X "+num+" "+" = "+(i*num));
        }
    }
}
