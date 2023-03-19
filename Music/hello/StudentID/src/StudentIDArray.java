import java.util.*;
class student{
    private Integer id;
	private String name;
	private Double point;
    Scanner sc = new Scanner(System.in);
    public student(){
        super();
    }
    public void input(){
        System.out.println("ID: ");
        id=Integer.parseInt(sc.nextLine());
        while(id<=1000||id>=9999){
            System.out.println("Please enter a 4-digit value: ");
            id=Integer.parseInt(sc.nextLine());
        }
        System.out.println("Name: ");
        name=sc.nextLine();
        System.out.println("Score: ");
        point=Double.parseDouble(sc.nextLine());
    }
    public void output(){
        System.out.println("ID: " + id + " Name: " + name + " Score: " + point+"\n");
    }
    public Integer getid(){return id;}
};
public class StudentIDArray {
    void menu(ArrayList<student>arr,Scanner sc){
        int check,n;
        student x;
    do{
        System.out.println("menu:");
        System.out.println("1. Add student.");
        System.out.println("2. Show student.");
        System.out.println("3. Search student.");
        System.out.println("4. Exit.");
        check=sc.nextInt();
        while(check!=1&check!=2&check!=3&check!=4)
        {
            System.out.println("Please try again: ");
            check=sc.nextInt();
        }
        switch(check){
            case 1:{
                System.out.println("Please enter the number of elements of the array: ");
                n=sc.nextInt();
                for(int i = 0;i < n; i++ ){
                x=new student();
                x.input();
                arr.add(x);
                }
                break;
            }
            case 2:{
                for(int i=0;i<arr.size();i++){
                        arr.get(i).output(); 
                }
                break;
            }
            case 3:{
                System.out.println("Please enter id student: ");
                double k;
                boolean l=true;
                k=sc.nextDouble();
                for(int i=0;i<arr.size();i++){
                    if(k==arr.get(i).getid()){
                        arr.get(i).output(); 
                        l=false;
                        break;
                    }
                }
                if (l) 
                System.out.println("Is not found");
                break;
            }
        }
    }
    while(check!=4);
    }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    var arr=new ArrayList<student>();
    var a=new StudentIDArray();
    a.menu(arr, sc);
    System.out.println("Thank you!");
}
}
