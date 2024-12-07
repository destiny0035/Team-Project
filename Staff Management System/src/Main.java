import Staff.Staff;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    private List<Staff> staff = new ArrayList<>();
    public void ListAllStaff(){
        if (staff.isEmpty()){
            System.out.println("No employee information available");
        }else{
            System.out.println("The employee information is as follows:");
            for (Staff AllStaff : staff) {
                System.out.println("name"+AllStaff.getName()+
                                   "age"+AllStaff.getAge()+
                                    "Id"+AllStaff.getId()+
                                    "gender"+AllStaff.getGender()+
                                    "position"+AllStaff.getPosition()+
                                    "income"+AllStaff.getIncome());
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
    }
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
    public void searchStaffInformation(String name){
        int temp=0,index=-1;
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getName()==name)
            {
                index=i;
                temp+=1;
            }
        }
        if(temp==0)System.out.println("Your search did not match any staff");
        if(temp==1)
        {
            ;
        }
        if(temp>=2)
        {
            System.out.println("Your search matches "+ temp +" staff");;

        }
    }//按名字查询

    public static void main(String[] args) {


    }
}
