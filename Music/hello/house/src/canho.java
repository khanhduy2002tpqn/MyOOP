public class canho extends house {
    private int Numoffloorth;

    public int getNumofFloorth() {
        return Numoffloorth;
    }

    public void setNumofFloorth(int Numoffloorth) {
        this.Numoffloorth = Numoffloorth;
    }
    public canho(){}
    @Override
    public void Input(){
        super.Input();
        System.out.print("Số tầng của căn hộ: ");
        Numoffloorth=sc.nextInt();
    }
    @Override
    public void Output(){
        System.out.print("------------CĂN HỘ------------");
        super.Output();
        System.out.print("Số tầng: "+Numoffloorth);
    }

}
