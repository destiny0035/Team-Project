import Staff.Staff;

import java.util.ArrayList;
import java.util.List;

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
                System.out.println("no required employee");
            }
        }



    }


    public static void main(String[] args) {


    }
}
