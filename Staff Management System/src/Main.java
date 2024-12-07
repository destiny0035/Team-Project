import Staff.Staff;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    private List<Staff> staff = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void ListAllStaff(){
        if (staff.isEmpty()){
            System.out.println("No employee information available");
        }else{
            System.out.println("The employee information is as follows:");
            for (Staff AllStaff : staff) {//修改了一下输出，使首字母为大写且加入冒号
                System.out.println("Name: "+AllStaff.getName()+
                                   "Age: "+AllStaff.getAge()+
                                    "Id: "+AllStaff.getId()+
                                    "Gender: "+AllStaff.getGender()+
                                    "Position: "+AllStaff.getPosition()+
                                    "Income: "+AllStaff.getIncome());
            }
        }
    }

    public void addStaffInformation(Staff extraStaff){
         staff.add(extraStaff);
        System.out.println("employee information added successfully");
    }

    public void deleteStaffInformation(String name){
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getName() == name){
                staff.remove(i);
            }else {
                System.out.println("no employee deleted");
            }
        }
    }//也许要改成用ID查找？

    public void filterStaffInformation(String gender,int maxAge,int minAge,double income){
        List <Staff> requiredStaff = new ArrayList<>();
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getGender()==gender&&staff.get(i).getAge()<maxAge&&staff.get(i).getAge()>minAge&&staff.get(i).getIncome()==income){
                requiredStaff.add(staff.get(i));
            }else {
                System.out.println("no required employee");//存在问题，使用empty
            }
        }
    }

    //未写完
    public void searchStaffInformation(int id){
        int temp=0,index=-1;
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getId()==id)
            {
                index=i;
                temp+=1;
            }
        }
        if(temp==0)System.out.println("Your search did not match any staff");
        else
        {
            System.out.println("Find staff "+ id);
            System.out.println
                    ("Name: "+staff.get(index).getName()+
                    "Age: "+staff.get(index).getAge()+
                    "Id: "+staff.get(index).getId()+
                    "Gender: "+staff.get(index).getGender()+
                    "Position: "+staff.get(index).getPosition()+
                    "Income: "+staff.get(index).getIncome());
            System.out.println(" ");
            System.out.println("Do you want to edit this staff's information?");
            System.out.println("(Please enter Yes or No))");
            String operation = input.nextLine();
            //记得写一个新的编辑函数
            if(operation == "Yes" || operation == "yes" || operation == "YES")
            {
                //TimeUnit.SECONDS.sleep(1);;
            }
            else if(operation == "No" || operation == "no" || operation == "NO")
            {
                ;
            }
            else System.out.println("Wrong Command!");
        }
    }//按id查询

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int displayMenu(){
        clearScreen();
        System.out.println("---Welcome---");
        System.out.println("Staff Mnagement");
        System.out.println("-------------------");
        System.out.println("1.List All staff");
        System.out.println("2.Add a New staff");
        System.out.println("3.Find staff");
        System.out.println("4.Delete staff");
        System.out.println("5.Exit");
        System.out.print("Enter your choice");
        int option = input.nextInt();
        return option;
    }
    public static void main(String[] args) {


    }
}
