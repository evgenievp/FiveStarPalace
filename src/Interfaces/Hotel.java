package Interfaces;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Hotel.rooms.SuiteRoom;
import Users.CasualUser;

import java.util.ArrayList;

public interface Hotel {
    void registerUser(User user);

    CasualUser signIn(User user);

    void signOut();

    int getRoomsCount();

    ArrayList<GeneralRoom> getRooms();

    ArrayList<SingleRoom> getSingleRooms();

    ArrayList<DoubleRoom> getDoubleRooms();

    ArrayList<DeluxeRoom> getDeluxeRooms();

    ArrayList<SuiteRoom> getSuiteRooms();

    void setRooms(ArrayList<GeneralRoom> rooms);
    GeneralRoom getRoom(String number);

}
