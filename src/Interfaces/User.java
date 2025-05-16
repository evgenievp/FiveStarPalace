package Interfaces;

public interface User {
    String username = "";
    String password = "";
    void changePassword(String oldPassword, String password);
    void book(GeneralRoom room, int das);
    void cancelBook();
    boolean authenticate(String username, String password);
    String getUsername();
    String getPassword();
}
