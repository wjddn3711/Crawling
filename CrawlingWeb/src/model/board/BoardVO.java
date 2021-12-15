package model.board;

public class BoardVO {
    private int ranking;
    private String name;
    private String brand;
    private int price;

    @Override
    public String toString() {
        return "BoardVO{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}
