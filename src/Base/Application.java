package Base;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginInformation login = new LoginInformation();

        int cases = 0;
        do {
            System.out.println("Login to continue!");
            System.out.println("1: Login ");
            System.out.println("2: Exit ");
            cases = Integer.parseInt(sc.nextLine());
            switch (cases) {
                case 1: {
                    System.out.println("Username : ");
                    String user = sc.nextLine();
                    System.out.println("Password :");
                    String pass = sc.nextLine();
                    login.isAdmin(user, pass);
                    break;
                }
            }
    } while(cases !=2);
}
}
