package CSVGenerators;

import Interfaces.GeneralRoom;
import Interfaces.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadAmenities {
    private ArrayList<GeneralRoom> roomAmenities;
    private Hotel hotel;

    public ReadAmenities(Hotel hotel) {
        this.roomAmenities = new ArrayList<>();
        this.hotel = hotel;
    }

    public void setRoomAmenities() {
        String file = "src/CSVResources/room_amenities.csv";
        String line;
        try (BufferedReader reader  = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String roomNumber = parts[0];
                String amenities = parts[1];
                this.hotel.getRoom(roomNumber).setAmenity(amenities);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
