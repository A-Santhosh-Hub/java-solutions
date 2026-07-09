import java.util.*;
class Mark {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter your Mark: ");
        int mark = in.nextInt();

        if(mark<35){
            System.out.println("Fail");
        }
        
        else{
            System.out.println("Pass");
        }

    }
}
