import java.util.*;
class Scor {
    public static void main(String[] args) {
    Scanner in= new Scanner(System.in);

    System.out.println("Enter The Mark:");
    int mark = in.nextInt();

    if(mark<34){
        System.out.println("Your Mark Is "+mark+" So Your Fail");

    }else if(mark<35||mark==35){
        System.out.println(" Your Mark Is "+mark+ " So, Pass");
    }else if(mark<60&&mark>36){
        System.out.println("I Phone");
    }else if(mark<90&&mark>61){
        System.out.println("MacBook Pro");
    }
    
    
    
    
    else{
        System.out.println("Test");
    }

    }
}
