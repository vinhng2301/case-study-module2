package userInterface;

import controller.EmployeesManager;
import entities.Employees;
import login.LoginInformation;

import java.util.Scanner;

public class Application {

    private EmployeesManager em;
    private static Scanner sc;

    public Application(){
        this.sc = new Scanner(System.in);
        this.em = new EmployeesManager();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginInformation login = new LoginInformation();
        int loginCases;
        int past = 1;
        do {
            System.out.println("------Login to continue!-------");
            System.out.println("1: LOGIN");
            System.out.println("2: EXIT");
            loginCases = Integer.parseInt(sc.nextLine());
            if (loginCases == 1) {
                System.out.println("Username : ");
                String user = sc.nextLine();
                System.out.println("Password :");
                String pass = sc.nextLine();
                login.isAdmin(user, pass);
                past = 2;
            }
        } while(loginCases !=2 && past == 1);
        menu();
    }


    private static int menu(){
        System.out.println("----------Menu---------");
        System.out.println("1: ADD EMPLOYEE");
        System.out.println("2: VIEW EMPLOYEES LIST");
        System.out.println("3: EDIT EMPLOYEES VIA ID");
        System.out.println("4: DELETE EMPLOYEE");
        System.out.println("0: EXIT !!");
        int choice = readInt(0, 3);
        return choice;
    }

    public void start (){
        while (true){
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addEmployees();
                    break;
                case 2:
                    showAll();
                default:
                    throw new AssertionError();
            }

        }
    }

    private static int readInt(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= min && choice <= max){
                    break;
                }
            } catch (Exception e){
                e.printStackTrace(  );
            }
        }
        return choice;
    }

    private float readFloat(int min, float max) {
        float salary;
        while(true){
            try{
                salary = Float.parseFloat(sc.nextLine());
                if(salary >= min && salary <= max){
                    break;
                }
            } catch (Exception e){
                System.out.println("Invalid values!!");
            }
        }
        return salary;
    }

    private void addEmployees() {
        System.out.println("Enter Employees ID: ");
        int id = readInt(0, Integer.MAX_VALUE);
        System.out.println("Enter Employees Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Employees Salary: ");
        float salary = readFloat(0, Float.MAX_VALUE);
        Employees e = new Employees(id, name, salary);
        this.em.addEmployee(e);
    }

    private void showAll() {
        System.out.println("-------Employees List-------");
        System.out.println("ID | NAME | SALARY");
        for (int i = 0; i < this.em.count(); i++) {
            Employees e = this.em.getEmployees(i);
            System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getSalary());
        }
    }
}