import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Farm {
    List<Animal> animals = new ArrayList<>();
    Map<ProductType, Integer> storage = new HashMap<>();
    int balance = 10_000;

    boolean addAnimal(Animal a, int price) {
        if (balance >= price) {
            animals.add(a);
            balance -= price;
            System.out.println("Добавлено животное: " + a.name + " (-" + price + ")");
            return true;
        }
        return false;
    }

    void feedAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Нет животных!");
            return;
        }

        int totalCost = 0;
        for (Animal a : animals) {
            int feedCost = (int) (getProductPrice(a.produce()) * 0.3); // 70% дешевле
            if (balance >= feedCost) {
                a.feed();
                balance -= feedCost;
                totalCost += feedCost;
            } else {
                System.out.println("Недостаточно денег для кормления " + a.name);
            }
        }
        System.out.println("Животные накормлены! Потрачено: " + totalCost + ". Баланс: " + balance);
    }

    void collectProducts() {
        if (animals.isEmpty()) {
            System.out.println("Нет животных!");
            return;
        }
        for (Animal a : animals) {
            ProductType p = a.produce();
            storage.put(p, storage.getOrDefault(p, 0) + 1);
        }
        System.out.println("Продукция собрана!");
    }

    void sellProducts() {
        if (storage.isEmpty()) {
            System.out.println("Склад пуст!");
            return;
        }
        int total = 0;
        for (Map.Entry<ProductType, Integer> e : storage.entrySet()) {
            int price = getProductPrice(e.getKey());
            total += e.getValue() * price;
        }
        balance += total;
        storage.clear();
        System.out.println("Продано на сумму: " + total + ". Новый баланс: " + balance);
    }

    void updateAnimals() {
        for (Animal a : animals) a.tick();
        System.out.println("⏰ Прошла минута: животные постарели и проголодались!");
    }

    int getBalance() {
        return balance;
    }

    private int getProductPrice(ProductType type) {
        return switch (type) {
            case MILK -> 100;
            case EGG -> 30;
            case WOOL -> 70;
        };
    }

    public String toString() {
        return "Животных: " + animals.size() +
                "\nСклад: " + storage +
                "\nБаланс: " + balance +
                "\nЖивотные: " + animals;
    }
}