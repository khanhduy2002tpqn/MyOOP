import java.util.Scanner;
import java.util.ArrayList;

public class PizzaChoice {
    public static void main(String[] args) {
       int choice,n;
       String x;
       double y;
       ArrayList<String> Pizza= new ArrayList<String>();
       ArrayList<Double> prices= new ArrayList<Double>();
       Scanner sc = new Scanner(System.in);
       System.out.println("vui lòng nhập số lượng phần tử của mảng: ");
       n=Integer.parseInt(sc.nextLine());
       for(int i = 0;i < n; i++ ){
            System.out.println("Input the size pizza: ");
            x=sc.nextLine();
            Pizza.add(x);
            System.out.print("Input the price pizza: ");
            y=Double.parseDouble(sc.nextLine());
            prices.add(y);

       }
       System.out.println(Pizza);
       System.out.println(prices);
        System.out.print("Choose the id corresponding to the pizza you want: ");
        choice = sc.nextInt();
        while(choice>n||choice<1){
            System.out.print("\nPlease try again: ");
            choice = sc.nextInt();
        }
        System.out.print("The pizza size " +Pizza.get(choice-1) + " and the price is " + prices.get(choice-1) + "$");
           
    }    
}
