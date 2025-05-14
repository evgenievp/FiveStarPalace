package Users;

import Interfaces.GeneralRoom;

public interface User {
    String username = "";
    String password = "";
    void changePassword(String oldPassword, String password);
    void book(GeneralRoom room);
    void cancelBook();
    boolean authenticate(String username, String password);
    String getUsername();
}
