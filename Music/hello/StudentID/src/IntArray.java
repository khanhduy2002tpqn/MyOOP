import java.util.ArrayList;
import java.util.Scanner;

public class IntArray {
    public static void input(ArrayList<Integer>c){
        Integer x,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("vui lòng nhập số lượng phần tử của mảng:");
        n=sc.nextInt();
        for(int i = 0;i < n; i++ ){
            x=sc.nextInt();
            c.add(x);
        }
    }
 
    public static void main(String[] args) {
        ArrayList<Integer> c=new ArrayList<Integer>();
        input(c);
        System.out.println("Original array: ");
        System.out.println(c);
        System.out.println("Reversed array: ");
        for (int j=c.size()-1;j>=0;j--){
            System.out.print(c.get(j)+ ", ");
        }
 
    }
}
