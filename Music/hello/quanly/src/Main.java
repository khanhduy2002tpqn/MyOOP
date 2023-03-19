import java.util.*;

public class Main {
    private static ArrayList<house> arr = new ArrayList<house>();
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
                    house clone = new canho();
                    clone.input();
                    arr.add(clone);
                    break;
                }
                case 2: {
                    house clone = new chungcu();
                    clone.input();
                    arr.add(clone);
                    break;
                }
            }
        } while (m != 3);
    }

    public static void xuat() {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).output();
        }

    }

    public static int Empty_place(char i) {
        int dem = 0;
        for (int j = 0; j < arr.size(); j++) {
            if (arr.get(j).get_Kt() == i & arr.get(j).get_status())
                dem++;
        }
        return dem;
    }

    public static long Sum() {
        long sum = 0;
        for (int j = 0; j < arr.size(); j++) {
            if (!arr.get(j).get_status())
                sum += arr.get(j).get_Tien_Thang();
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
            System.out.println("5. Tìm nha bằng địa chỉ.");
            System.out.println("6. Sắp xếp theo địa chỉ.");
            System.out.println("7. Thoát.");
            key = sc.nextInt();
            while (key < 1 || key > 7) {// check nó có trong khoảng cho phép từ 1->7 hay không.
                System.out.println("Nhập trong khoảng từ 1->7: ");
                key = Integer.parseInt(sc.nextLine());
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
                    System.out.println("Số căn hộ còn trống là: " + Empty_place('A'));
                    System.out.println("Số chung cư còn trống là. " + Empty_place('B'));
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 4: {
                    System.out.println("Tổng tiền thuê nhà trong 1 tháng là: " + Sum());
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 5: {
                    String a1;
                    System.out.println("Nhập địa chỉ cần tìm: ");
                    sc.nextLine();
                    a1 = sc.nextLine();
                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).get_Address().equals(a1)) {
                            arr.get(i).output();
                            break;
                        }
                    }
                    System.out.println("---------------------------------------\n");
                    break;
                }
                case 6: {
                    Comparator<house> cmp = new Comparator<house>() {
                        @Override
                        public int compare(house a, house b) {
                            return a.get_Address().compareTo(b.get_Address());
                        }
                    };
                    Collections.sort(arr, cmp);
                    xuat();
                    System.out.println("---------------------------------------\n");
                    break;
                }
            }
        } while (key != 7);
    }
}
