package Hotel.rooms;

import Interfaces.GeneralRoom;

import java.util.ArrayList;

public class SingleRoom implements GeneralRoom {
    private final String type = "Single";
    private double price;
    private String status;
    private String number;
    private ArrayList<String> amenites;
    private double cancelationFee;
    private double maximumOccupancy;
    private double discount;
    private String discountCode;


    public SingleRoom(double price, String status, String number, double cancelationFee, double maximumOccupancy, double discount) {
        if (price > 0) {
            this.price = price;
        }
        else {
            System.out.println("Error, cant set room price zero or less.");
        }
        if (!this.status.equals("Free") && (!this.status.equals("Booked") && (!this.status.equals("Maintenance")))) {
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

    public double getPrice() {
        return calculatePrice();
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
    public double calculatePrice() {
        if (this.discountCode != null) {
            this.price -= (this.price * this.discount);
            return this.price;
        }
        else {
            return this.price;
        }
    }


}
