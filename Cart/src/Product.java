import java.util.Objects;

public class Product {
    private static int nextId = 1;
    private int id;
    private String name;
    private int price;
    public Product(String name, int price) {
        this.id = getNextId();
        this.name = name;
        this.price = price;
    }

    private static synchronized int getNextId() {
        return nextId++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
