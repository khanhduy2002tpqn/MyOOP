import java.util.*;
public class VD2 {
    public static void main(String[] args) {
        //Viết chương trình nhập vào một số nguyên n. Tính tổng các số chia hết cho 5 trong khoảng từ 1 đến n.    
        Scanner sc=new Scanner(System.in);
        int n,sum=0;
        System.out.println("Nhap so n: ");
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            if(i%5==0)
                sum+=i;
        }
        System.out.println("Tong cac so chia het cho 5 la : "+sum);
    }
}
