import java.util.Scanner;
import java.util.ArrayList;

public class Prices {
    public static void main(String[] args) {
        ArrayList<Double> prices=new ArrayList<Double>();
        double value=5.00d,sum=0,average=0,x;
        int i,n;
        Scanner sc=new Scanner(System.in);
        System.out.println("vui lòng nhập số lượng phần tử của mảng:");
        n=sc.nextInt();
        for( i = 0;i < n; i++ ){
            x=sc.nextDouble();
            prices.add(x);
        }
        for ( i = 0; i< prices.size();i++)
         {
            sum +=prices.get(i);    
         }
        System.out.println("The sum is: "+sum+"$");
        System.out.println("All values less than $5.00 are: ");
        for (i = 0;i< prices.size();i++)
        {
            if (prices.get(i)<value)
            System.out.print(prices.get(i)+"\t");
        }
        average = (sum/n);
        System.out.println("\nThe average value is: "+average+"$");
        System.out.println("All values more than average value are: ");
        for ( i = 0; i< prices.size();i++)
        {
            if (prices.get(i)>average)
            System.out.print(prices.get(i)+"\t");
        }  
    }    
}
