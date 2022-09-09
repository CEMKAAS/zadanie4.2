import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sun.tools.javac.util.StringUtils.toLowerCase;

public class Main {
    public static void main(String[] args) {

        System.out.println("Выберите операцию");
        System.out.println("1.Операция добавить");
        System.out.println("2.Операция показать");
        System.out.println("3.Операция удалить");
        System.out.println("4.Операция поиск");
        Scanner scanner = new Scanner(System.in);
        List<String> products = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);

            if (number == 1) {
                System.out.println("Какую покупку хотите сделать?");
                String inputProducts = scanner.nextLine();
                products.add(inputProducts);
                System.out.println("Итого в списке покупок: " + products.size());
            }
            if (number == 2) {
                listOutput(products);
            }

            if (number == 3) {
                listOutput(products);
                System.out.println("Какую хотите удалить? Введите номер или название");
                String delProduct = scanner.nextLine();
                if (products.remove(delProduct)) {
                    System.out.println("Покупка " + delProduct + " удалена, список покупок:");
                    products.remove(delProduct);
                    listOutput(products);
                    continue;
                } else {
                    int product = Integer.parseInt(delProduct);
                    System.out.println("Покупка " + products.get(product - 1) + " удалена, список покупок:");
                    products.remove(product - 1);
                    listOutput(products);
                }
            }

            if (number == 4) {
                System.out.println("Введите текст для поиска");
                String queryLower = scanner.nextLine();
                queryLower = toLowerCase(queryLower);
                System.out.println("Найдено: ");
                for (int i = 0; i < products.size(); i++) {
                    String itemLower = products.get(i);
                    itemLower = toLowerCase(itemLower);
                    if (itemLower.contains(queryLower)) {
                        String product = products.get(i);
                        System.out.println((i + 1) + "." + product);
                    }
                }
            }
        }
    }

    public static void listOutput(List<String> products) {
        System.out.println("Список покупок:");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + "." + product);
        }
    }
}