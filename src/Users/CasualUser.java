package Users;

import Receipts.BookReceipt;

import java.util.ArrayList;

public class CasualUser implements User{
    private String username;
    private String password;
    private ArrayList<BookReceipt> receipts;

    public CasualUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.receipts = new ArrayList<BookReceipt>();
    }

    @Override
    public void changePassword(String oldPassword, String password) {
        if (this.password.equals(oldPassword) && !password.equals(this.password)) {
            if (password.length() >= 6 && password.length() <= 30) {
                this.password = password;
                System.out.println("Password changed successfully");
            }
            else {
                System.out.println("Cant set that password. It should be between 6 and 30 symbols.");
            }
        }
        else {
            System.out.println("Password not match.");
        }

    }
}
