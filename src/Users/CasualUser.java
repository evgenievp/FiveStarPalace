package Users;

import Interfaces.GeneralRoom;
import Interfaces.User;
import Receipts.BookReceipt;

import java.util.ArrayList;

public class CasualUser implements User {
    private String username;
    private String userPassword;
    private double money;
    private GeneralRoom currentlyBooked = null;
    private ArrayList<BookReceipt> receipts;
    private String discountCode = null;

    public CasualUser(String username, String password) {
        this.username = username;
        this.userPassword = password;
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
    public void book(GeneralRoom room, int days) {
        if (this.discountCode != null) {
            room.getPrice();
        }
        if (this.money >= room.getPrice() * days) {
            this.money -= room.getPrice() * days;
            BookReceipt receipt = new BookReceipt(username, days, room.getPrice());
            this.receipts.add(receipt);
            this.currentlyBooked = room;
        }
    }

    @Override
    public void cancelBook() {
        if (this.currentlyBooked != null && this.money >= this.currentlyBooked.getCancelationFee()) {
            this.money -= this.currentlyBooked.getCancelationFee();
            this.currentlyBooked =null;
        }
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (getUsername().equals(username) && getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

}
