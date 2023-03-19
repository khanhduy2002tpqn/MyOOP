import java.util.*;

 class Person {
    protected String name;
    protected String gt;
    protected String address;
    protected String date;
    public Scanner sc = new Scanner(System.in);
    Person() {

    }

    public void input() {
        System.out.println("Nhap ten: ");
        name = sc.nextLine();
        System.out.println("Nhap gioi tinh: (f/m)");
        gt = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        address = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        date = sc.nextLine();
    }

    public void output() {
        System.out.print("Ten: " + name + "\t");
        System.out.println("Gioi tinh: " + gt);
        System.out.println("Dia chi: " + address);
        System.out.println("Ngay sinh: " + date);
    }
}

public class Student extends Person {
    private int mssv;
    private float point;
    private String email;
    Student(){

    }

    public int getMssv() {
        return mssv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Nhap ma so sinh vien: ");
        mssv =Integer.parseInt(sc.nextLine());
        System.out.println("Nhap diem trung binh: ");
        point = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap email: ");
        email = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Ma so sinh vien: " + mssv);
        System.out.println("DTB: " + point);
        System.out.println("Email: " + email);
    }
    public boolean kiemtrahocbong() {
        if (point >= 8)
            return true;
        else
            return false;
    }
}
