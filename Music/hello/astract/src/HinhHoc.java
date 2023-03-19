import java.util.Scanner;

public class HinhHoc {
    static Scanner sc = new Scanner(System.in);
    protected float dt;
    protected float cv;

    HinhHoc() {

    }

    void setdt(float dt) {
        this.dt = dt;
    }

    void setcv(float cv) {
        this.cv = cv;
    }

    float getCv() {
        return cv;
    }

    float getDt() {
        return dt;
    }

    void input() {

    }

    void output() {
    }
}

class HinhTron extends HinhHoc {
    float r;

    HinhTron() {

    }

    HinhTron(float r) {
        this.r = r;
    }

    @Override
    void input() {
        System.out.println("Nhập bán kính: ");
        r = sc.nextFloat();
        dt = 3.14f * r * r;
        cv = 2 * r * 3.14f;
    }

    @Override
    void output() {
        System.out.println("-------------Hình Vuông------------\n");
        System.out.println("Diện tích là: " + dt);
        System.out.println("Chu vi là: " + cv);
    }
}

class HinhCN extends HinhHoc {
    float r, d;

    HinhCN() {

    }

    @Override
    void input() {
        System.out.println("Nhập chiều rộng: ");
        r = sc.nextFloat();
        System.out.println("Nhập chiều dài: ");
        d = sc.nextFloat();
        dt = r * d;
        cv = (d + r) * 2;
    }

    @Override
    void output() {
        System.out.println("-----------Hình Chữ Nhật----------\n");
        System.out.println("Diện tích là: " + dt);
        System.out.println("Chu vi là: " + cv);
    }
}

class HinhVuong extends HinhHoc {
    float r;

    HinhVuong() {

    }

    @Override
    void input() {
        System.out.println("Nhập độ dài cạnh: ");
        r = sc.nextFloat();
        dt = r * r;
        cv = r * 4;
    }

    void output() {
        System.out.println("-------------Hình Vuông----------\n");
        System.out.println("Diện tích là: " + dt);
        System.out.println("Chu vi là: " + cv);
    }

}
