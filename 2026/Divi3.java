import java.util.*;

class Divi3 {
    public static void main(String[] args) {
        
    
    Scanner in = new Scanner(System.in);


    System.out.println("Enter The Number:");
    int num  = in.nextInt();
 
    if(num%3==0&&num%5==0){
        System.out.println("The Given Number  "+num+" IS Divisable By 3 and 5 ");
    }else{
        System.out.println("The Given Number "+num+" Is Not Divisable By 3 and 5");
    }




}
    
}
