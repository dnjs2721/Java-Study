import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {
        Set<Product> productSet = readProductsFromCSV("src/products.csv");

        Scanner scanner = new Scanner(System.in);

        System.out.println("상품을 입력하세요. (종료하려면 'exit' 입력)");
        while (true) {
            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            if (productName.equals("exit")) {
                break;
            }

            System.out.print("가격(원): ");
            int productPrice;
            try {
                productPrice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 가격 형식입니다. 다시 입력하세요.");
                continue;
            }

            Product product = new Product(productName, productPrice);
            productSet.add(product);
        }

        System.out.println("----------판매중인 상품----------");
        if (productSet.size() == 0) {
            System.out.println("판매중인 상품이 없습니다.");
        } else {
            for (Product p : productSet) {
                System.out.println(p.getName() + " : " + p.getPrice());
            }
        }
        System.out.println("-----------------------------");

        Cart myCart = new Cart();

        while (true) {
            System.out.println("------------장바구니-----------");
            myCart.showItems();
            System.out.println("-----------------------------");

            System.out.println("장바구니 상품 추가 add, 장바구니 상품 삭제 remove, 종료 exit 입력");
            System.out.print("입력: ");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case "add" -> {
                    System.out.print("추가할 상품명: ");
                    String addProductName = scanner.nextLine();
                    Product addSelectedProduct = findProduct(productSet, addProductName);
                    if (addSelectedProduct != null) {
                        System.out.print("추가할 수량: ");
                        try {
                            int addQuantity = Integer.parseInt(scanner.nextLine());
                            myCart.addProduct(addSelectedProduct, addQuantity);
                            System.out.println("상품이 장바구니에 추가되었습니다.");
                        } catch (Exception e) {
                            System.out.println("잘못된 수량입니다.");
                        }
                    } else {
                        System.out.println("상품이 상품 목록에 없습니다.");
                    }
                }
                case "remove" -> {
                    if (myCart.getSize() == 0) {
                        System.out.println("장바구니가 비어있습니다.");
                        break;
                    }

                    System.out.print("삭제할 상품명: ");
                    String removeProductName = scanner.nextLine();
                    Product removeSelectedProduct = findProduct(productSet, removeProductName);
                    if (removeSelectedProduct != null) {
                        System.out.print("삭제할 수량: ");
                        try {
                            int removeQuantity = Integer.parseInt(scanner.nextLine());
                            myCart.removeProduct(removeSelectedProduct, removeQuantity);
                            System.out.println("상품이 장바구니에서 제거되었습니다.");
                        } catch (Exception e) {
                            System.out.println("잘못된 수량입니다.");
                        }
                    } else {
                        System.out.println("상품이 상품 목록에 없습니다.");
                    }
                }
                default -> System.out.println("유효하지 않은 입력입니다. 다시 입력하세요.");
            }
        }
    }
    private static Product findProduct(Set<Product> products, String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    private static Set<Product> readProductsFromCSV(String path) {
        Set<Product> products = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String productName = parts[0].trim();
                    int productPrice = Integer.parseInt(parts[1].trim());

                    Product product = new Product(productName, productPrice);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}