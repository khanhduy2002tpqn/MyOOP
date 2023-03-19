import java.util.*;

public class house {
    protected String address;
    protected long tiencoc;
    protected boolean status;
    protected long tienthang;
    public static Scanner sc=new Scanner(System.in);
    public house(String address, long tiencoc, boolean status, long tienthang) {
        this.address = address;
        this.tiencoc = tiencoc;
        this.status = status;
        this.tienthang = tienthang;
    }
    public house(){};
    public boolean get_status(){return status;}
    public long get_Tien_Thang(){return tienthang;}
    public void Input(){
        System.out.println("Tình trạng: (true/false)");
        status=sc.nextBoolean();
        System.out.println("Nhập số tiền đặt cọc: ");
        tiencoc=sc.nextLong();
        System.out.println("Nhập số tiền thuê hằng tháng: ");
        tienthang=sc.nextLong();
        System.out.println("Nhập địa chỉ: ");
        sc.nextLine();
        address=sc.nextLine();
    }
    public void Output(){
        String s=new String();
        System.out.println("Địa chỉ: "+address);
        System.out.println("Tiền cọc: "+tiencoc);
        System.out.println("Tiền đóng hằng tháng: "+tienthang);
         s = (status) ? "Yes": "No";
        System.out.println("Tình trạng: "+s);
    }
    
}
