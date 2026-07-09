import java.util.*;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the two Number: ");
        int a = in.nextInt();
        int b = in.nextInt();

        if(a<b){
            System.out.println(" The Given Number "+b+" Bigger");
        }else{
            System.out.println("The Given Number "+b+" is small");
        }
    }
}
