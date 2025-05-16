package Interfaces;

import Receipts.BookReceipt;

import java.util.ArrayList;

public interface User {
    String username = "";
    String password = "";
    void changePassword(String oldPassword, String password);
    void book(GeneralRoom room, int days);
    void cancelBook();
    boolean authenticate(String username, String password);
    String getUsername();
    String getPassword();
    String getDiscountCode();
    ArrayList<BookReceipt> getReceipts();
    public void setCode(String code);
}
