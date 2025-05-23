package Hotel.rooms;

import Interfaces.GeneralRoom;

import java.util.ArrayList;

public class SuiteRoom implements GeneralRoom {
    private final String type = "Suite";
    private double price;
    private String status;
    private String number;
    private ArrayList<String> amenites;
    private double cancelationFee;
    private double maximumOccupancy;
    private double discount;
    private int floor;
    private String discountCode;


    public SuiteRoom(double price, int floor, String status, String number, double cancelationFee, double maximumOccupancy, double discount) {
        if (price > 0) {
            this.price = price;
        }
        else {
            System.out.println("Error, cant set room price zero or less.");
        }
        if (floor >= 1 && floor <= 4) {
            this.floor = floor;
        }
        if (!status.equals("Free") && (!status.equals("Booked") && (!status.equals("Maintenance")))) {
            System.out.println("Error, cant set that type for Single Room.");
        }
        else {
            this.status = status;
        }
        this.number = number;
        this.amenites = new ArrayList<>();
        this.cancelationFee = cancelationFee;
        this.maximumOccupancy = maximumOccupancy;
        this.discount = discount;
    }

    public String getType() {
        return this.type;
    }

    public double getPrice(String discountCode) {
        return calculatePrice(discountCode);
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public double getCancelationFee() {
        return this.cancelationFee;
    }

    @Override
    public ArrayList<String> getAmenities() {
        return this.amenites;
    }

    @Override
    public double maximumOccupancy() {
        return this.maximumOccupancy;
    }

    @Override
    public double getDiscount() {
        return this.discount;
    }

    public void setPrice(double price) {
        if (price > this.price) {
            this.price = price;
        }
        else {
            System.out.println("Cant set that price");
        }
    }

    public void setStatus(String status) {
        if (!status.equals("Free") && !status.contains("Booked") && !status.contains("Maintenance")) {
            System.out.println("Cant set that status");
        }
        else {
            this.status = status;
        }
    }

    @Override
    public void setCancelationFee(double fee) {
        if (this.cancelationFee >= fee) {
            System.out.println("Cant set that fee.");
        }
        else {
            this.cancelationFee = fee;
        }
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculatePrice(String discountCode) {
        if (discountCode != null) {
            this.price = this.price - (this.price * this.discount);
            return this.price;
        }
        else {
            return this.price;
        }
    }

    @Override
    public void setAmenity(String amenity) {
        this.amenites.add(amenity);
    }

    @Override
    public String getRoomNumber() {
        return this.number;
    }
    @Override
    public double bookRoomForDays(int days, String discountCode) {
        if (this.status.equals("Free")) {
            this.status = "Booked";
            return getPrice(discountCode) * days;
        } else {
            return 0;
        }
    }
}
