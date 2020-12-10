package login;

import java.io.File;
import java.util.Scanner;

public class LoginInformation {
    String filepath = "src\\login\\members.txt";
    public void isAdmin(String username, String password) {
        boolean found = false;
        String tempUsername ;
        String tempPassword ;
        try {
            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !found){
                tempUsername = x.next();
                tempPassword = x.next();
                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    found = true;
                }
            }
            x.close();
            System.out.println(found);
        }
        catch (Exception e){
            System.out.println("Something went wrong!");
        }
    }
}