package homework7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    static Map<String, Product> storage = new HashMap<>();
    public Scanner scanner = new Scanner(System.in);

    static {
        storage.put("sweets_1", new Sweets("Milka", 47, 310));
        storage.put("sweets_2", new Sweets("Nesquik", 16, 415));
        storage.put("sweets_3", new Sweets("Snickers", 84, 430));
        storage.put("sweets_4", new Sweets("Mars", 12, 450));

        storage.put("meat_1", new Meat("Lamb", 88, 531));
        storage.put("meat_2", new Meat("Beef", 69, 566));
        storage.put("meat_3", new Meat("Pork", 89, 403));
        storage.put("meat_4", new Meat("Turkey", 31, 500));

        storage.put("fruit_1", new Fruit("Apple", 36, 92));
        storage.put("fruit_2", new Fruit("Pear", 22, 105));
        storage.put("fruit_3", new Fruit("Plum", 43, 158));
        storage.put("fruit_4", new Fruit("Orange", 33, 78));
        storage.put("fruit_5", new Fruit("Banana", 72, 60));
        storage.put("fruit_6", new Fruit("Lemon", 12, 44));

        storage.put("vegetables_1", new Vegetables("Tomato", 25, 220));
        storage.put("vegetables_2", new Vegetables("Potato", 60, 250));
        storage.put("vegetables_3", new Vegetables("Cucumber", 52, 190));
    }

    public void getListProducts() {
        for (Map.Entry<String, Product> entry : storage.entrySet()) {
            System.out.println("У нас есть " + entry.getValue().name + " " + entry.getValue().amount + " кг " + entry.getValue().price + " руб/кг");
        }
        System.out.println();
    }

    //Add new product or count to exist product
    public void addProductOrCount() {
        System.out.println("Введите название продукта для добавления:");
        String nameProduct = scanner.nextLine();
        String valueProduct = "newProduct";
        for (Map.Entry<String, Product> productEntry : storage.entrySet()) {
            if (productEntry.getValue().name.equals(nameProduct)) {
                valueProduct = "existProduct";
                break;
            }
        }

        switch (valueProduct) {
            case "existProduct":
                for (Map.Entry<String, Product> productEntry : storage.entrySet()) {
                    if (productEntry.getValue().name.equals(nameProduct)) {
                        System.out.println("Такой продукт уже существует");
                        System.out.println();
                        System.out.println("Давайте добавим количество нашего продукта (кг)");
                        int amountProduct = scanner.nextInt();
                        productEntry.getValue().setAmount(productEntry.getValue().amount + amountProduct);
                        System.out.println("Вы успешно добавили количество продукта " + productEntry.getValue().name);
                        System.out.println();
                        scanner.nextLine();
                        break;
                    }
                }
                break;

            case "newProduct":
                if (storage.size() <= 20) {
                    System.out.println("Давайте добавим количество нашего продукта (кг)");
                    int amountProduct = scanner.nextInt();
                    System.out.println("Давайте добавим цену нашего продукта (руб/кг)");
                    int priceProduct = scanner.nextInt();
                    scanner.nextLine();
                    Product newProduct = new Product(nameProduct, amountProduct, priceProduct);
                    int random_id = 1 + (int) (Math.random() * 10000);
                    String randomKey = "newProduct" + random_id;
                    storage.put(randomKey, newProduct);
                    for (Map.Entry<String, Product> entryProduct : storage.entrySet()) {
                        if (entryProduct.getValue() == newProduct) {
                            System.out.println("Вы добавили продукт: " + entryProduct.getValue().name + " " + entryProduct.getValue().amount + " кг " + entryProduct.getValue().price + " руб/кг");
                            System.out.println();
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Добавление нового продукта невозможно, склад переполнен. Возможно только редактирование количества существующих продуктов");
                    System.out.println();
                }
        }
    }

    public void deleteProduct() {
        System.out.println("Введите наименование продукта для удаления: ");
        String deleteProduct = scanner.nextLine();
        for (Map.Entry<String, Product> entry : storage.entrySet()) {
            if (entry.getValue().name.equals(deleteProduct)) {
                storage.remove(entry.getKey());
                System.out.println("Продукт " + deleteProduct + " успешно удалён");
                break;
            }
        }
        System.out.println();
    }

    public void deleteAmountProduct() {
        System.out.println("Введите название уменьшаемого продукта:");
        String nameProduct = scanner.nextLine();

        for (Map.Entry<String, Product> productEntry : storage.entrySet()) {
            if (productEntry.getValue().name.equals(nameProduct)) {
                System.out.println();
                System.out.println("Какое количество продукта " + productEntry.getValue().name + " вы хотите уменьшить (кг)");
                int amountProduct = scanner.nextInt();
                productEntry.getValue().setAmount(productEntry.getValue().amount - amountProduct);
                System.out.println("Вы успешно уменьшили количество продукта " + productEntry.getValue().name);
                System.out.println();
                scanner.nextLine();
                break;
            }
        }
    }

    public void getSize() {
        System.out.println("Количество позиций продуктов на складе: " + storage.size());
        System.out.println();
    }

    public Map<String, Product> getAllProducts() {
        return storage;
    }
}



