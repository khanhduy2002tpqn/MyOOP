import java.util.*;

public class SinhVien {
    int id;
    String name;
    int tuoi;
    Scanner sc=new Scanner(System.in);
    void input(){
        System.out.println("ID: ");
        id=Integer.parseInt(sc.nextLine());
        System.out.println("Name: ");
        name=sc.nextLine();
        System.out.println("Age: ");
        tuoi=Integer.parseInt(sc.nextLine());
    }
    void output(){
        System.out.println("ID: " + id + " Name: " + name + " Age: " + tuoi+"\n");
    }
}
