package Dto;


public class StockPricePointDto {

    private String date;
    
    private double price;

    public StockPricePointDto() {
    }

    public StockPricePointDto(String date, double price) {
        this.date = date;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
