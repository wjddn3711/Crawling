package model.product;

public class ProductVO {
    private int ranking;
    private String name;
    private String brand;
    private int price;
    private String image;

    @Override
    public String toString() {
        return "ProductVO{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
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

    public void setImage(String image) {
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
