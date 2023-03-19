import java.util.*;
public class VD4 {
    public static Scanner sc=new Scanner(System.in);
    public static void input(int n, int[] arr){
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
    }
    public static int Summ(int n, int[] arr){
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]%5==0)
            sum+=arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int n;
        System.out.println("Nhap so n: ");
        n=sc.nextInt();
        int[] arr=new int[n];
        input(n,arr);
        System.out.println("Tong cac so chia het cho 5 la : "+Summ(n,arr));
    }
}
