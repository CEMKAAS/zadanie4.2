import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.tools.javac.util.StringUtils.toLowerCase;

public class Main {

    public static void main(String[] args) {

        System.out.println("Выберите операцию");
        System.out.println("1.Операция добавить");
        System.out.println("2.Операция показать");
        System.out.println("3.Операция удалить");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> producs = new ArrayList<>();


        while (true) {
            System.out.println();
            System.out.println("Выберите операцию");
            String input = scanner.nextLine();
            int nomer = Integer.parseInt(input);

            if (nomer == 1) {
                System.out.println("Какую покупку хотите сделать?");
                String inputProducs = scanner.nextLine();
                producs.add(inputProducs);
                System.out.println("Итого в списке покупок: " + producs.size());
            }
            if (nomer == 2) {
                System.out.println("Список покупок:");
                for (int i = 0; i < producs.size(); i++) {
                    String produc = producs.get(i);
                    System.out.println((i + 1) + "." + produc);
                }
            }

            if (nomer == 3) {
                System.out.println("Список покупок:");
                for (int i = 0; i < producs.size(); i++) {
                    String produc = producs.get(i);
                    System.out.println((i + 1) + "." + produc);
                }
                System.out.println("Какую хотите удалить? Введите номер или название");
                String input1 = scanner.nextLine();
                if (producs.remove(input1)) {
                    System.out.println("Покупка " + input1 + " удалена, список покупок:");
                    producs.remove(input1);
                    System.out.println("Список покупок:");
                    for (int i = 0; i < producs.size(); i++) {
                        String produc = producs.get(i);
                        System.out.println((i + 1) + "." + produc);
                    }
                    continue;
                }
                if (!producs.remove(input1)) {
                    int product = Integer.parseInt(input1);
                    System.out.println("Покупка " + producs.get(product - 1) + " удалена, список покупок:");
                    producs.remove(product - 1);
                    System.out.println("Список покупок:");
                    for (int i = 0; i < producs.size(); i++) {
                        String produc = producs.get(i);
                        System.out.println((i + 1) + "." + produc);
                    }
                }
            }

            if (nomer == 4) {
                System.out.println("Введите текст для поиска");
                String queryLower = scanner.nextLine();
                toLowerCase(queryLower);
                for (int i = 0; i < producs.size(); i++) {
                    String itemLower = producs.get(i);
                    toLowerCase(itemLower);
                    if (itemLower.contains(queryLower)) {
                        System.out.println("Найдено: ");
                        String produc = producs.get(i);
                        System.out.println((i + 1) + "." + produc);
                    }

                }
            }
        }
    }
}