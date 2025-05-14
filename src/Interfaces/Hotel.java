package Interfaces;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Users.User;

import java.util.ArrayList;

public interface Hotel {
    void registerUser(User user);

    boolean signIn(User user);

    void signOut();

    int getRoomsCount();

    ArrayList<GeneralRoom> getRooms();

    ArrayList<SingleRoom> gerSingleRooms();

    ArrayList<DoubleRoom> getDoubleRooms();

    ArrayList<DeluxeRoom> getDeluxeRooms();

}
