import java.util.*;

public class VD1 { 
    
    public static void main(String[] args) throws Exception {
        //Viết chương trình nhập vào một số và kiểm tra xem số đó có chia hết cho 5 hay không?
       System.out.println("nhap 1 so bat ki ");
       Scanner sc = new Scanner(System.in);
       int x;
       x = sc.nextInt();
       System.out.println("So da nha la "+x);
       if (x%5==0){
           System.out.println("So "+ x +" chia het cho 5");
       }
       else
       System.out.println("So "+ x +" khong chia het cho 5");
    }
}
