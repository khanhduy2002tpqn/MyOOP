public class chungcu extends house {
    private int floorth;

    public chungcu() {
    }

    public int getFloorth() {
        return floorth;
    }

    public void setFloorth(int floorth) {
        this.floorth = floorth;
    }
    @Override
    public void Input(){
        super.Input();
        System.out.print("Tầng thứ: ");
        floorth=sc.nextInt();
    } 
    @Override
    public void Output(){
        System.out.print("-------------CHUNG CƯ------------");
        super.Output();
        System.out.print("Tầng: "+floorth);
    }
    
}
