
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = 0;


        while (numberOfPeople < 2) {
            try {
                System.out.println("Сколько человек разделяет счет?");
                numberOfPeople = scanner.nextInt();

                if (numberOfPeople == 1) {
                    System.out.println("Нет смысла ничего считать и делить для одного человека.");
                } else if (numberOfPeople < 1) {
                    System.out.println("Некорректное значение для подсчета.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Пожалуйста, введите корректное количество гостей.");
                scanner.next(); // Discard the input
            }
        }

        System.out.println("Программа продолжает выполнение для " + numberOfPeople + " человек.");


        double totalCost = 0;
        String items = "";

        while (true) {
            System.out.println("Введите название товара (или 'Завершить', чтобы закончить):");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("Завершить")) {
                break;
            }

            double itemCost = 0;
            while (itemCost <= 0) {
                try {
                    System.out.println("Введите стоимость товара в формате рубли.копейки:");
                    itemCost = scanner.nextDouble();
                    if (itemCost <= 0) {
                        System.out.println("Стоимость должна быть положительным числом.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка. Пожалуйста, введите корректную стоимость.");
                    scanner.next();
                }
            }

            totalCost += itemCost;
            items += itemName + ": " + itemCost + "\n";
            System.out.println("Товар успешно добавлен.");
        }

        System.out.println("Добавленные товары:\n" + items);


        double amountPerPerson = totalCost / numberOfPeople;
        System.out.println("Каждый человек должен заплатить: " +Formatter.formatAmount(amountPerPerson));

    }
}


