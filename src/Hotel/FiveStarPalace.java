package Hotel;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Interfaces.GeneralRoom;
import Interfaces.Hotel;
import Users.CasualUser;
import Users.User;
import java.util.ArrayList;

public class FiveStarPalace implements Hotel {
    private double income;
    private ArrayList<GeneralRoom> rooms;
    private ArrayList<User> users;

    public FiveStarPalace() {
        this.income = 0;
        this.users = new ArrayList<User>();
        this.rooms = new ArrayList<GeneralRoom>();
    }


    @Override
    public void registerUser(User user) {
        this.users.add(user);
    }
    private User searchUser(User user) {
        for (var u : this.users) {
            if (u.getUsername().equals(user.getUsername())) {
                return user;
            }
        }
        CasualUser u = new CasualUser("nobody", "nonePassword");
        return u;
    }

    @Override
    public boolean signIn(User user) {
        User foundUser = searchUser(user);
        if (foundUser.getUsername().equals("nobody")) {
            System.out.println("Cant sign in with that user.");
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void signOut() {

    }

    @Override
    public int getRoomsCount() {
        return 0;
    }

    @Override
    public ArrayList<GeneralRoom> getRooms() {
        return null;
    }

    @Override
    public ArrayList<SingleRoom> gerSingleRooms() {
        return null;
    }

    @Override
    public ArrayList<DoubleRoom> getDoubleRooms() {
        return null;
    }

    @Override
    public ArrayList<DeluxeRoom> getDeluxeRooms() {
        return null;
    }
}
