package entities;

public class Product {
    private int id;
    private String name;
    private String category;
    private int price;

    public Product(String name, String category, int price) {
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public Product(int id, String name, String category, int price) {
        setId(id);
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". " + name + " (" + category + ") : " + price;
    }
}
