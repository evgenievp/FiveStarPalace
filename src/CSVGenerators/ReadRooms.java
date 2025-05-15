package CSVGenerators;

import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Hotel.rooms.SuiteRoom;
import Interfaces.GeneralRoom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadRooms {
    private ArrayList<GeneralRoom> rooms;

    public ReadRooms() {
        this.rooms = new ArrayList<GeneralRoom>();
    }
    public void readRooms() {
        String file = "src/CSVResources/hotel_rooms.csv";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String number = parts[0];
                String type = parts[1];
                int occupancy = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);
                double discount = Double.parseDouble(parts[4]);
                double cancelFee = Double.parseDouble(parts[5]);
                String status = parts[6];
                int floor = 1;
                if (number.contains("D")) {
                    floor = 1;
                }
                else if (number.contains("C")) {
                    floor = 2;
                }
                else if (number.contains("B")) {
                    floor = 3;
                }
                else if (number.contains("A")) {
                    floor = 4;
                }

                switch (type) {
                    case "Single": {
                        SingleRoom room = new SingleRoom(price, floor, status, number, cancelFee, occupancy, discount);
                        this.rooms.add(room);
                        break;
                    }
                    case "Double": {
                        DoubleRoom room = new DoubleRoom(price, floor, status, number, cancelFee, occupancy, discount);
                        this.rooms.add(room);
                        break;
                    }
                    case "Suite": {
                        SuiteRoom room = new SuiteRoom(price, floor, status, number, cancelFee, occupancy, discount);
                        this.rooms.add(room);
                        break;
                    }
                    default:
                        DeluxeRoom room = new DeluxeRoom(price, floor, status, number, cancelFee, occupancy, discount);
                        this.rooms.add(room);
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<GeneralRoom> getRooms() {
        return this.rooms;
    }
}
