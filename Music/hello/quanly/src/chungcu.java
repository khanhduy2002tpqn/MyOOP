public class chungcu extends house {
    public chungcu() {
    }
    public void input(){
        super.Input();
        System.out.println("Tầng thứ: ");
        floorth=sc.nextInt();
        kt='B';//phân biệt chung cư với căn hộ thường 
    } 
    public void output(){
        System.out.println("-------------CHUNG CƯ------------");
        super.Output();
        System.out.println("Tầng: "+floorth);
    }
    
}
