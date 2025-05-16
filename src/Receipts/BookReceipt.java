package Receipts;

public class BookReceipt {
    private String username;
    private int days;
    private double price;
    private double total;

    public BookReceipt(String username, int days, double price) {
        this.username = username;
        this.days = days;
        this.price = price;
        this.total = price * days;
    }

    @Override
    public String toString(){
        return String.format("""
                User %s
                went to FiveStarPalace
                for %d days
                at price %f.2f lv.
                total price: %f.2f lv.
                """, this.username, this.days, this.price, this.total);
    }


}
