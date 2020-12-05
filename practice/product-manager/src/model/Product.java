package model;

public class Product {

    private int id;
    private String developer;
    private String model;
    private float price;
    private String description;

    public Product(int id, String developer, String model, float price, String description) {
        this.id = id;
        this.developer = developer;
        this.model = model;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return this.developer + this.model;
    }

    public void setName(String developer, String model) {
        this.developer = developer;
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + developer + model + '\'' +
            ", price=" + price +
            ", description='" + description + '\'' +
            '}';
    }
}

