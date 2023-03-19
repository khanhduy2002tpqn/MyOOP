import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void input(ArrayList<HinhHoc> arr) {
        int n, m;
        System.out.println("Nhập số lượng hình");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap 1 : Hinh chu nhat");
            System.out.println("Nhap 2 : Hinh tron");
            System.out.println("Nhap 3 : Hinh vuong");
            m = sc.nextInt();
            switch (m) {
                case 1: {
                    HinhHoc a = new HinhCN();
                    a.input();
                    arr.add(a);
                    break;
                }
                case 2: {
                    HinhHoc b = new HinhTron();
                    b.input();
                    arr.add(b);
                    break;
                }
                case 3: {
                    HinhHoc c = new HinhVuong();
                    c.input();
                    arr.add(c);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        var arr = new ArrayList<HinhHoc>();
        int m;

        do {
            System.out.println("Nhap 1 : Nhập hình");
            System.out.println("Nhap 2 : In các hình");
            System.out.println("Nhap 3 : Tìm diện tích lớn nhất");
            System.out.println("Nhap 4 : Tìm chu vi lớn nhất");
            System.out.println("Nhap 5 : Thoát");
            m = sc.nextInt();
            switch (m) {
                case 1: {
                    input(arr);
                    break;
                }
                case 2: {
                   for(int i=0;i<arr.size();i++){
                       arr.get(i).output();
                   }
                    break;
                }
                case 3: {
                    var max=arr.get(0).getDt();
                    for(int i=0;i<arr.size();i++){
                        if (max<arr.get(i).getDt())
                        max=arr.get(i).getDt();
                    }
                    System.out.println("Diện tích lớn nhất là"+max);
                    break;
                }
                case 4: {
                    var max=arr.get(0).getCv();
                    for(int i=0;i<arr.size();i++){
                        if (max<arr.get(i).getCv())
                        max=arr.get(i).getCv();
                    }
                    System.out.println("Chu vi lớn nhất là"+max);
                    break;
                }
            }
        } while (m != 5);
    }
}
