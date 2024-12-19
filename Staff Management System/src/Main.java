import Staff.Staff;
import java.io.EOFException;
import java.sql.Driver;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Main {
    private List<Staff>staff = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public void ListAllStaff(){
        if (staff.isEmpty()){
            System.out.println("No employee information available");
        }else{
            System.out.println("The employee information is as follows:");
            for (Staff AllStaff : staff) {//修改了一下输出，使首字母为大写且加入冒号
                System.out.println("Name: "+AllStaff.getName()+" "+
                        "Age: "+AllStaff.getAge()+" "+
                        "Id: "+AllStaff.getId()+" "+
                        "Gender: "+AllStaff.getGender()+" "+
                        "Position: "+AllStaff.getPosition()+" "+
                        "Income: "+AllStaff.getIncome());
            }
        }
    }

    public void addStaffInformation(Staff extraStaff){
        staff.add(extraStaff);
        System.out.println("New staff added successfully!");
    }

    public void deleteStaffInformation(int id){
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getId() == id)
            {
                staff.remove(i);
                System.out.println("The staff is deleted successfully!");
                return;
            }
        }
        System.out.println("No employee matched!");
    }

    public void filterStaffInformation(double minIncome, double maxIncome) {
        if (minIncome > maxIncome) {
            System.out.println("Invalid income range!");
            return;
        }
        List<Staff> requiredStaff = new ArrayList<>();
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getIncome() < maxIncome && staff.get(i).getIncome() > minIncome) {
                requiredStaff.add(staff.get(i));
            }
        }
        if (requiredStaff.isEmpty()) {
            System.out.println("No employee required!");
            return;
        }
        for (Staff staff1 : requiredStaff) {
            System.out.println(staff1);
        }
        System.out.println("Filtered successfully!");
    }

    public void searchStaffInformation(int id){
        int temp=0,index=-1;
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getId()==id) {
                index=i;
                temp+=1;
            }
        }
        if(temp==0) {
            System.out.println("Your search did not match any staff!");
            System.out.println("Backing to the menu......");
        }
        else
        {
            System.out.println("Find target staff!");
            System.out.println
                    ("Name: "+staff.get(index).getName()+" "+
                            "Age: "+staff.get(index).getAge()+" "+
                            "Id: "+staff.get(index).getId()+" "+
                            "Gender: "+staff.get(index).getGender()+" "+
                            "Position: "+staff.get(index).getPosition()+" "+
                            "Income: "+staff.get(index).getIncome());
            System.out.println(" ");
            System.out.println("Do you want to edit this staff's information?");
            System.out.println("(Please enter Yes or No)");
            System.out.print("Your choice: ");
            String operation = input.nextLine();
            if(operation.equals("Yes") || operation.equals("yes")  || operation.equals("YES")){
                if(editStaffInformation(index)) System.out.println("Information is edited successfully!");
                else return;
            }
            else if(operation.equals("No") || operation.equals("no") || operation.equals("NO"))return;
            else System.out.println("Wrong Command!");
        }
    }//按id查询

    public boolean editStaffInformation(int index){
        int newAge,newIncome;
        long newId;
        String newName,newPosition,newGender;
        Staff target=staff.get(index);
        System.out.println("Please enter new information: ");
        System.out.println("Original Name: "+target.getName());
        System.out.print("New Name: ");
        newName = input.nextLine();
        if(newName==null||newName.length()>20) {
            System.out.println("The input is wrong!");
            System.out.println("Reloading......");
            return false;
        }
        target.setName(newName);
        System.out.println("Original Age: "+target.getAge());
        System.out.print("New Age: ");
        newAge = input.nextInt();
        if(newAge<18||newAge>60){
            System.out.println("The input is wrong");
            System.out.println("Reloading......");
            return false;
        }
        target.setAge(newAge);
        System.out.println("Original Id: "+target.getId());
        System.out.print("New Id: ");
        newId = input.nextLong();
        if(newId<0||newId>=1.00E12){
            System.out.println("The input is wrong");
            System.out.println("Reloading......");
            return false;
        }
        target.setId(newId);
        System.out.println("Original Gender: "+target.getGender());
        System.out.print("New Gender: ");
        input.nextLine();
        newGender = input.nextLine();
        if(!"Male".equals(newGender)&&!"Female".equals(newGender)){
            System.out.println("The input is wrong");
            System.out.println("Reloading......");
            return false;
        }
        target.setGender(newGender);
        System.out.println("Original Position: "+target.getPosition());
        System.out.print("New Position: ");
        newPosition = input.nextLine();
        if(!"Manager".equals(newPosition)&&!"Staff".equals(newPosition)) {
            System.out.println("The input is wrong");
            System.out.println("Reloading......");
            return false;
        }
        target.setPosition(newPosition);
        System.out.println("Original Income: "+target.getIncome());
        System.out.print("New Income: ");
        newIncome = input.nextInt();
        input.nextLine();
        if(newIncome<0.0){
            System.out.println("The input is wrong");
            System.out.println("Reloading......");
            return false;
        }
        target.setIncome(newIncome);
        System.out.println();
        return true;
    }

    public void runMenu() {
        System.out.println("///////////////////////////////////////");
        System.out.println("Staff Management System (Final Version)");
        System.out.println("///////////////////////////////////////");
        System.out.println("Now Loading.......");
        try {
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
            System.out.println();
        }
        catch(Exception e) {}
        System.out.println("Lording Complete!");
        while(true) {
            System.out.print("Press enter to continue......");
            input.nextLine();
            int command = displayMenu();
            input.nextLine();
            if (command == -1) {
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
            if(command == 0)
            {
                System.out.println("System Closed!");
                break;
            }
            if (command == 1) {
                ListAllStaff();
                System.out.println();
                System.out.println("All staff are listed!");
            }
            else if (command == 2) {
                System.out.print("Enter the name of the staff: ");
                String name_1 = input.nextLine();
                if(name_1==null||name_1.length()>20) {
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    continue;
                }
                System.out.print("Enter the age of the staff: ");
                int age_1 = input.nextInt();
                if(age_1<18||age_1>60){
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    input.nextLine();
                    continue;
                }
                System.out.print("Enter the id of the staff: ");
                long id_1 = input.nextLong();
                if(id_1<0||id_1>=1.00E12){
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    input.nextLine();
                    continue;
                }
                System.out.print("Enter the gender of the staff (Male/Female): ");
                input.nextLine();
                String gender_1 = input.nextLine();
                if(!"Male".equals(gender_1)&&!"Female".equals(gender_1)){
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    continue;
                }
                System.out.print("Enter the position of the staff (Manager/Staff): " );
                String position_1 = input.nextLine();
                if(!"Manager".equals(position_1)&&!"Staff".equals(position_1)) {
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    continue;
                }
                System.out.print("Enter the income of the staff: ");
                double income_1 = input.nextDouble();
                if(income_1<0.0){
                    System.out.println("The input is wrong!");
                    System.out.println("Reloading......");
                    input.nextLine();
                    continue;
                }
                Staff temp=new Staff(name_1,age_1,id_1,gender_1,position_1,income_1);
                input.nextLine();
                addStaffInformation(temp);
            }
            else if  (command ==3) {
                System.out.print("Please input the id of the staff you want to search: ");
                int searchId = input.nextInt();
                input.nextLine();
                searchStaffInformation(searchId);
            }
            else if (command ==4) {
                System.out.print("Please input the id of the staff you want to delete: ");
                int deleteId = input.nextInt();
                input.nextLine();
                System.out.println();
                deleteStaffInformation(deleteId);
            }
            else if (command == 5) {
                System.out.print("Enter the minIncome of the staff: ");
                double minIncome = input.nextDouble();
                System.out.println();
                System.out.print("Enter the maxIncome of the staff: ");
                double maxIncome = input.nextDouble();
                input.nextLine();
                System.out.println();
                filterStaffInformation(minIncome,maxIncome);

            }
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int displayMenu() {
        clearScreen();
        System.out.println("\033[1;34m");
        System.out.println("---Welcome---");
        System.out.println("Staff Management System");
        System.out.println("-------------------");
        System.out.println("\033[0m\033[1;32m");
        System.out.println("1) List All staff");
        System.out.println("2) Add a New staff");
        System.out.println("3) Find & Edit staff");
        System.out.println("4) Delete staff");
        System.out.println("5) Filter staff");
        System.out.println("\033[0m\033[1;31m");
        System.out.println("0) Exit");
        System.out.println("\033[0m-------------------");
        System.out.println();
        System.out.print("\033[1;33mPlease enter your choice : \033[0m");
        int option = input.nextInt();
        System.out.println();
        if (option >= 0 && option <= 5)
            return option;
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.clearScreen();
        main.runMenu();
    }
}