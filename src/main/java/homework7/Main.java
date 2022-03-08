package homework7;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Storage storage = new Storage();

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Выберите необходимое действие, указав цифру от 1 до 7:");
            System.out.println("1) Получить список продуктов");
            System.out.println("2) Добавить продукт или увеличить количество существующего продукта");
            System.out.println("3) Удалить продукт");
            System.out.println("4) Уменьшить количество существующего продукта");
            System.out.println("5) Получить количество позиций продуктов на складе");
            System.out.println("6) Выгрузить данные склада в excel таблицу");
            System.out.println("7) Выйти из программы");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            int menuValue = scanner.nextInt();
            switch (menuValue) {
                case 1:
                    storage.getListProducts();
                    break;
                case 2:
                    storage.addProductOrCount();
                    break;
                case 3:
                    storage.deleteProduct();
                    break;
                case 4:
                    storage.deleteAmountProduct();
                    break;
                case 5:
                    storage.getSize();
                    break;
                case 6:
                    new CreateExcelWorkBook(storage);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
