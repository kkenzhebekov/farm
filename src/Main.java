import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Farm farm = new Farm();


        boolean run = true;
        while (run) {
            System.out.println("Ферма");
            System.out.println("1 - Показать ферму");
            System.out.println("2 - Добавить животное");
            System.out.println("3 - Кормить животных");
            System.out.println("4 - Собрать продукцию");
            System.out.println("5 - Продать продукцию");
            System.out.println("0 - Выход");
            System.out.print("Выбор: ");
            int c;
            try {
                c = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Неверный ввод");
                continue;
            }

            switch (c) {
                case 1 -> System.out.println(farm);
                case 2 -> {
                    System.out.print("Введите тип (1-Корова, 2-Курица, 3-Овца): ");
                    int t = Integer.parseInt(sc.nextLine());
                    System.out.print("Имя: ");
                    String name = sc.nextLine();
                    boolean ok = switch (t) {
                        case 1 -> farm.addAnimal(new Cow(name, 1), 2000);   // корова 2000 сом
                        case 2 -> farm.addAnimal(new Chicken(name, 1), 500); // курица 500 сом
                        case 3 -> farm.addAnimal(new Sheep(name, 1), 1500);  // овца 1500 сом
                        default -> false;
                    };
                    if (!ok) System.out.println("Недостаточно денег!");
                }
                case 3 -> farm.feedAnimals();
                case 4 -> farm.collectProducts();
                case 5 -> farm.sellProducts();
                case 0 -> run = false;
                default -> System.out.println("Неверный пункт меню");
            }
        }
        sc.close();
        System.out.println("Выход. Пока!");
    }
}










