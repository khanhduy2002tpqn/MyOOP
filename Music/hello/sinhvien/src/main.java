import java.util.*;
public class main {
    
    public static void main(String[] args) throws Exception {
        ArrayList<SinhVien> sv=new ArrayList<SinhVien>();
        SinhVien a;
        int check;
        Scanner sc=new Scanner(System.in);
        do{
            a=new SinhVien();
            a.input();     
            sv.add(a);
            System.out.println("Do you want to continue: (Yes=1/No=0)");
            check=sc.nextInt();
            while(check!=1&check!=0){
                System.out.println("Enter again: ");
                check=sc.nextInt();
            }
        }
        while(check!=0);
        for (int i=0;i<sv.size();i++){
            sv.get(i).output();
        }
    }
}
