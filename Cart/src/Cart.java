import java.util.HashMap;
import java.util.Map;

public class Cart {
    private HashMap<Product, Integer> items;
    public Cart() {
        this.items = new HashMap<>();
    }

    public void showItems() {
        if (this.items.size() == 0) {
            System.out.println("장바구니가 비어있습니다");
            return;
        }

        for (Map.Entry<Product, Integer> entry : this.items.entrySet()) {
            Product product = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(product.getName() + " - 수량: " + value + "개");
        }
    }

    public void addProduct(Product product, Integer value) {
        this.items.put(product, this.items.getOrDefault(product, 0) + value);
    }

    public void removeProduct(Product product, Integer value) {
        Integer curVal = this.items.get(product);
        if (curVal - value <= 0) {
            this.items.remove(product);
        } else {
            this.items.put(product, curVal - value);
        }
    }

    public int getSize() {
        return this.items.size();
    }
}
