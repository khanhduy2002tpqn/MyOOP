import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var arr = new ArrayList<Student>();
        int n;
        System.out.println("Nhap so luong sinh vien: ");
        n = sc.nextInt();
        Student a;
        for (int i = 0; i < n; i++) {
            a = new Student();
            a.input();
            arr.add(a);
        }
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).output();
        }
        System.out.println("Sinh vien nhan hoc bong la: ");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).kiemtrahocbong() == true)
                arr.get(i).output();
        }
    }
}
