package Interfaces;

import java.util.ArrayList;

public interface GeneralRoom {
    public String getType();
    public double getPrice();
    public String getStatus();
    public double getCancelationFee();
    public ArrayList<String> getAmenities();
    public double maximumOccupancy();
    public double getDiscount();
    public void setPrice(double price);
    public void setStatus(String status);
    public void setCancelationFee(double fee);
    public void setDiscount(double discount);


}
