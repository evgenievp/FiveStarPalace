package Hotel;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Hotel.rooms.SuiteRoom;
import Interfaces.GeneralRoom;
import Interfaces.Hotel;
import Users.CasualUser;
import Interfaces.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FiveStarPalace implements Hotel {
    private double income;
    private ArrayList<GeneralRoom> rooms;
    private ArrayList<User> users;
    private boolean signedIn;

    public FiveStarPalace() {
        this.income = 0;
        this.users = new ArrayList<User>();
        this.rooms = new ArrayList<GeneralRoom>();
    }


    @Override
    public void registerUser(User user) {
        this.users.add(user);
        String file = "src/CSVResources/users.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String line = user.getUsername() + "," + user.getPassword();
            writer.write(line);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
    public CasualUser signIn(User user) {
        User foundUser = searchUser(user);
        if (foundUser.getUsername().equals(user.getUsername()) && foundUser.getPassword().equals(user.getPassword())) {
            return (CasualUser) foundUser;
        }
        else {
            CasualUser u = new CasualUser("nobody", "nonePassword");
            return u;
        }
    }

    public CasualUser getUser(String username) {
        for (var user: this.users) {
            if (user.getUsername().equals(username)) {
                return (CasualUser) user;
            }
        }
        CasualUser u = new CasualUser("nobody", "nonePassword");
        return u;
    }


    @Override
    public void signOut() {
        this.signedIn = false;
    }

    @Override
    public int getRoomsCount() {
        return 0;
    }

    @Override
    public ArrayList<GeneralRoom> getRooms() {
        return this.rooms;
    }

    @Override
    public ArrayList<SingleRoom> getSingleRooms() {
        ArrayList<SingleRoom> singleRooms = new ArrayList<>();
        this.rooms.stream()
                .filter(room -> room instanceof SingleRoom)
                .map(room -> (SingleRoom) room)
                .forEach(singleRooms::add);
        return singleRooms;
    }

    @Override
    public ArrayList<DoubleRoom> getDoubleRooms() {
        ArrayList<DoubleRoom> doubleRooms = new ArrayList<>();
        this.rooms.stream()
                .filter(room -> room instanceof DoubleRoom)
                .map(room -> (DoubleRoom) room)
                .forEach(doubleRooms::add);
        return doubleRooms;
    }

    @Override
    public ArrayList<DeluxeRoom> getDeluxeRooms() {
        ArrayList<DeluxeRoom> deluxeRooms = new ArrayList<>();
        this.rooms.stream()
                .filter(room -> room instanceof DeluxeRoom)
                .map(room -> (DeluxeRoom) room)
                .forEach(deluxeRooms::add);
        return deluxeRooms;
    }

    @Override
    public ArrayList<SuiteRoom> getSuiteRooms() {
        ArrayList<SuiteRoom> suiteRooms = new ArrayList<>();
        this.rooms.stream()
                .filter(room -> room instanceof SuiteRoom)
                .map(room -> (SuiteRoom) room)
                .forEach(suiteRooms::add);
        return suiteRooms;
    }

    @Override
    public void setRooms(ArrayList<GeneralRoom> rooms) {
        this.rooms.addAll(rooms);
    }

    @Override
    public GeneralRoom getRoom(String number) {
        for (var room : this.rooms) {
            if (room.getRoomNumber().equals(number)) {
                return room;
            }
        }
        SingleRoom room = new SingleRoom(0, 1, "Free", "11", 0,0, 0);
        return room;
    }

}
