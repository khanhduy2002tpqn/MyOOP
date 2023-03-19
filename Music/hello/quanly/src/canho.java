public class canho extends house {
   
    public canho(){}
    public void input(){
        super.Input();
        System.out.println("Số tầng của căn hộ: ");
        Numoffloorth=sc.nextInt();
        kt='A';//phân biệt chung cư với căn hộ thường
    }
    public void output(){
        System.out.println("------------CĂN HỘ------------");
        super.Output();
        System.out.println("Số tầng: "+Numoffloorth);
    }
}
