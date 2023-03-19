import java.util.*;

public class Main {
    private static ArrayList<canho> arr1 = new ArrayList<canho>();
    private static ArrayList<chungcu> arr2 = new ArrayList<chungcu>();
    public static Scanner sc = new Scanner(System.in);

    public static void nhap() {
        int m;
        do {
            System.out.println("1. Nhập thông tin căn hộ.");
            System.out.println("2. Nhập thông tin chung cư.");
            System.out.println("3. Thoát.");
            m = sc.nextInt();
           switch (m) {
                case 1: {
                    canho clone = new canho();
                    clone.Input();
                    arr1.add(clone);
                    break;
                }
                case 2: {
                    chungcu clone = new chungcu();
                    clone.Input();
                    arr2.add(clone);
                    break;
                }
            }
        } while (m != 3);
    }

    public static void xuat() {
        for (int i = 0; i < arr1.size(); i++) {
            arr1.get(i).Output();
        }
        for (int i = 0; i < arr2.size(); i++) {
            arr2.get(i).Output();
        }
    }

    public static int Empty_place(int i) {
        int dem = 0;
        if(i==1)
        for (int j = 0; j < arr1.size(); j++) {
            if (arr1.get(j).get_status())
                dem++;
        }
        else
        for (int j = 0; j < arr2.size(); j++) {
            if (arr2.get(j).get_status())
                dem++;
        }
        return dem;
    }

    public static long Sum() {
        long sum = 0;
        for (int j = 0; j < arr1.size(); j++) {
            if (arr1.get(j).get_status())
                sum += arr1.get(j).get_Tien_Thang();
            if (arr1.get(j).get_status())
                sum += arr2.get(j).get_Tien_Thang();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        int key;
        do {
            // menu
            System.out.println("----------------MANAGER----------------\n");
            System.out.println("Hello, mời bạn chọn mục muốn thao tác: ");
            System.out.println("1. Nhập danh sách căn hộ.");
            System.out.println("2. In danh sách căn hộ.");
            System.out.println("3. Số căn hộ còn trống.");
            System.out.println("4. Tổng tiền thuê trong vòng 1 tháng.");
            System.out.println("5. Thoát.");
            key = sc.nextInt();
            while (key < 1 || key > 5) {// check nó có trong khoảng cho phép từ 1->5 hay không.
                System.out.println("Nhập trong khoảng từ 1->5: ");
                key = sc.nextInt();
            }
            switch (key) {
                case 1: {
                    nhap();
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 2: {
                    xuat();
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 3: {
                    System.out.println("Số căn hộ còn trống là: " + Empty_place(1));
                    System.out.println("Số chung cư còn trống là. " + Empty_place(2));
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 4: {
                    System.out.println("Tổng tiền thuê nhà trong 1 tháng là: " + Sum());
                    System.out.println("---------------------------------------\n");
                    break;
                }
            }
        } while (key != 5);
    }
}
