import java.util.*;
public class EvenOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter The Number:");
        int num = in.nextInt();

        if(num%2==0){
            System.out.println("The Given Number is: "+num+" Even");

        } else{
            System.out.println("The Number "+num+" is Odd");
        }
    }
    
}
