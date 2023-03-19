import java.util.*;
 
public class VowelArray {
    public static void main(String[] args) {
        ArrayList<Character> vowels=new ArrayList();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('O');vowels.add('I');vowels.add('U');
        System.out.println("Please enter the character: ");
        Scanner sc=new Scanner(System.in);
        char Character=sc.nextLine().charAt(0);
        boolean check=true;
        for (int i=0;i<vowels.size();i++){
            if (vowels.get(i)==Character) {
                System.out.println("You have entered the correct character");
                check=false;
            }
            }
            if (check)
            System.out.println("You have not entered the correct character");           
    }   
}
