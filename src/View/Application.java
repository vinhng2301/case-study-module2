package View;

import Base.LoginInformation;

import java.util.Scanner;

public class Application {

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


        System.out.println("----------Menu---------");
        System.out.println("1: ADD EMPLOYEE");
        System.out.println("2: DELETE EMPLOYEE");
        System.out.println("3: EDIT EMPLOYEES VIA ID");
        System.out.println("4: VIEW EMPLOYEES LIST");
        System.out.println("0: EXIT !!");


    }
}