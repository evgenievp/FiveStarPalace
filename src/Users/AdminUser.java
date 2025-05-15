package Users;

import Interfaces.GeneralRoom;
import Interfaces.User;
import Receipts.BookReceipt;
import java.util.ArrayList;

public class AdminUser implements User {
    private String username;
    private String userPassword;
    private double money;
    private ArrayList<BookReceipt> receipts;
    private GeneralRoom currentlyBooked;
    private String discountCode = null;

    public AdminUser(String user, String userPassword) {
        this.username = user;
        this.userPassword = userPassword;
        this.money = 1000;
        this.receipts = new ArrayList<BookReceipt>();
    }

    @Override
    public void changePassword(String oldPassword, String password) {
        if (this.userPassword.equals(oldPassword) && !password.equals(this.userPassword)) {
            if (password.length() >= 6 && password.length() <= 30) {
                this.userPassword = password;
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

    @Override
    public void book(GeneralRoom room) {
        if (this.money >= room.getPrice()) {
            this.money -= room.getPrice();
            room.setStatus("Booked");
            this.currentlyBooked = room;
        }
        else {
            System.out.println("Book cant be done.");
        }
    }

    @Override
    public void cancelBook() {
        if (this.currentlyBooked != null && this.money >= this.currentlyBooked.getCancelationFee()) {
            this.money -= this.currentlyBooked.getCancelationFee();
            this.currentlyBooked =null;
        }
        else {
            System.out.println("Cant cancel room booking");
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.userPassword;
    }


    @Override
    public boolean authenticate(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
