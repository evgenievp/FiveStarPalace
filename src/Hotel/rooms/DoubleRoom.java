package Hotel.rooms;

import Interfaces.GeneralRoom;

import java.util.ArrayList;

public class DoubleRoom implements GeneralRoom {
    private final String type = "Double";
    private double price;
    private String status;
    private String number;
    private ArrayList<String> amenites;
    private double cancelationFee;
    private double maximumOccupancy;
    private double discount;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getPrice() {
        return this.price;
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

    @Override
    public void setPrice(double price) {
        if (price > this.price) {
            this.price = price;
        }
        else {
            System.out.println("Cant set that price");
        }
    }

    @Override
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
        if (this.cancelationFee < fee) {
            this.cancelationFee = fee;
        }
        else {
            System.out.println("Cant set that fee.");
        }
    }

    @Override
    public void setDiscount(double discount) {
        if (this.discount < discount) {
            System.out.println("Cant set that discount");
        }
        else {
            this.discount = discount;
        }
    }
}
