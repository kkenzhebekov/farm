abstract class Animal {
    String name;
    int age;
    int hunger; // 0..100 (100 - очень голоден)
    AnimalType type;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.hunger = 50;
    }

    void feed() { hunger = Math.max(0, hunger - 30); }

    void tick() {
        age += 1;
        hunger = Math.min(100, hunger + 10);
    }

    abstract ProductType produce();

    public String toString() {
        return name + "(" + type + ", age=" + age + ", hunger=" + hunger + ")";
    }
}
