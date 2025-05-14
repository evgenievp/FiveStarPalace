package Hotel;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Interfaces.GeneralRoom;
import Interfaces.Hotel;
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

    @Override
    public boolean signIn(User user) {
        for (var u : this.users) {
            if (u.password == user.password && u.username == user.username) {
                return true;
            }
        }
        return false;

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
