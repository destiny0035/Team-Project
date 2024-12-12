import Staff.Staff;

import java.sql.Driver;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    //未写完set部分与检查部分
    public void editStaffInformation(int index){
        int newAge,newIncome;
        long newId;
        String newName,newPosition,newGender;
        System.out.println("Please enter new information: ");
        System.out.println("Original Name: "+staff.get(index).getName());
        System.out.print("New Name: ");
        newName = input.nextLine();
        System.out.println();
        System.out.println("Original Age: "+staff.get(index).getAge());
        System.out.print("New Age: ");
        newAge = input.nextInt();
        System.out.println();
        System.out.println("Original Id: "+staff.get(index).getId());
        System.out.print("New Id: ");
        newId = input.nextLong();
        System.out.println();
        System.out.println("Original Gender: "+staff.get(index).getGender());
        System.out.print("New Gender: ");
        newGender = input.nextLine();
        System.out.println();
        System.out.println("Original Position: "+staff.get(index).getPosition());
        System.out.print("New Position: ");
        newPosition = input.nextLine();
        System.out.println();
        System.out.println("Original Income: "+staff.get(index).getIncome());
        System.out.print("New Income: ");
        newIncome = input.nextInt();
        System.out.println();
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
                editStaffInformation(index);
                return;
            }
            else if(operation == "No" || operation == "no" || operation == "NO")
            {
                System.out.println("Backing to the menu......");
                return;
            }
            else System.out.println("Wrong Command!");
        }
    }//按id查询

    public void runMenu() {
        System.out.println("///////////////////////////////////////");
        System.out.println("Staff Management System V1.0");
        System.out.println("///////////////////////////////////////");
        System.out.println("Now Loading.......");
        try {
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("...");
            System.out.println();
        }
        catch(Exception e) {}
        System.out.println("Lording Complete!");
        
        while(true)
        {
            int command=displayMenu();
            if(command == -1)
            {
                System.out.println("Wrong Command!");
                System.out.println("Now Reloading.......");
                try {
                    System.out.print("...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("...");
                    System.out.println();
                }
                catch(Exception e) {}
                System.out.println("Reloading Complete!");
            }
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int displayMenu(){
        clearScreen();
        System.out.println("---Welcome---");
        System.out.println("Staff Management System");
        System.out.println("-------------------");
        System.out.println("1) List All staff");
        System.out.println("2) Add a New staff");
        System.out.println("3) Find staff");
        System.out.println("4) Delete staff");
        System.out.println("0) Exit");
        System.out.println("-------------------");
        System.out.print("Please enter your choice : ");
        int option = input.nextInt();
        if (option>=0 && option<=4)return option;
        else return -1;
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.clearScreen();
        main.runMenu();
    }
}
