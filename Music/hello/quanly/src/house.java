import java.util.*;

public abstract class house {
    protected String address;
    protected long tiencoc;
    protected boolean status;
    protected long tienthang;
    protected int Numoffloorth;
    protected int floorth;
    protected char kt;

    public static Scanner sc = new Scanner(System.in);

    public house(String address, long tiencoc, boolean status, long tienthang) {
        this.address = address;
        this.tiencoc = tiencoc;
        this.status = status;
        this.tienthang = tienthang;
    }

    public house() {
    };

    public boolean get_status() {
        return status;
    }

    public long get_Tien_Thang() {
        return tienthang;
    }

    public char get_Kt() {
        return kt;
    }

    public String get_Address() {
        return address;
    }

    public void Input() {
        System.out.println("Nhập số tiền đặt cọc: ");
        tiencoc = sc.nextLong();
        System.out.println("Nhập tiền hằng tháng: ");
        tienthang = sc.nextLong();
        System.out.println("Nhập địa chỉ: ");
        sc.nextLine();
        address = sc.nextLine();
        System.out.println("Tình trạng: (true/false)");
        status = sc.nextBoolean();
    }

    public void Output() {
        String s = new String();
        System.out.println("Địa chỉ: " + address);
        System.out.println("Tiền cọc: " + tiencoc);
        System.out.println("Tiền đóng hằng tháng: " + tienthang);
        s = (status) ? "Yes" : "No";
        System.out.println("Tình trạng: " + s);
    }

    public abstract void input();

    public abstract void output();

}
