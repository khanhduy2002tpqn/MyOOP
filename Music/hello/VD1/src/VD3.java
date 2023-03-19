import java.util.*;
public class VD3 {
    public static void main(String[] args) {
        //Viết chương trình cho một mảng số nguyên gồm n phần tử. Tính tổng các số chia hết cho 5 có trong mảng số nguyên đó.
        Scanner sc=new Scanner(System.in);
        int n,sum=0,y;
        System.out.println("Nhap so n: ");
        n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(arr[i]%5==0)
            sum+=arr[i];
        }
        System.out.println("Tong cac so chia het cho 5 la : "+sum);
    }
}
