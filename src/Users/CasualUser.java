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
                System.out.println("Успешно променена парола");
            }
            else {
                System.out.println("Паролата трябва да е между 6 и 30 символа.");
            }
        }
        else {
            System.out.println("Паролите не съвпадат");
        }
    }

    @Override
    public void book(GeneralRoom room, int days) {
        if (this.discountCode != null) {
            double price = room.getPrice(discountCode);
            if (this.money >= price) {
                this.currentlyBooked = room;
                room.bookRoomForDays(days, this.discountCode);
                this.money -= price;
            }
            else {
                System.out.println("Недостатъчна наличност");
            }
        } else {
            if (this.money >= room.getPrice(null) * days) {
                this.money -= room.getPrice(null) * days;
                BookReceipt receipt = new BookReceipt(username, days, room.getPrice(null));
                this.receipts.add(receipt);
                room.bookRoomForDays(days, this.discountCode);
                this.currentlyBooked = room;
            } else {
                System.out.println("не може да се резирвира. Недостатъчна анличност.");
            }
        }
    }

    @Override
    public boolean cancelBook() {
        if (this.currentlyBooked != null && this.money >= this.currentlyBooked.getCancelationFee()) {
            this.money -= this.currentlyBooked.getCancelationFee();
            this.currentlyBooked =null;
            return true;
        }
        else {
            return false;
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
    public String getDiscountCode() {
        return this.discountCode;
    }


    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public ArrayList<BookReceipt> getReceipts() {
        return this.receipts;
    }

    public void setCode(String code) {
        this.discountCode = code;
    }

    public GeneralRoom getRoomReservation() {
        return this.currentlyBooked;
    }
}
