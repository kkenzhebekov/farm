
class Cow extends Animal {
    Cow(String n, int a) {
        super(n, a);
        type = AnimalType.COW;
    }

    ProductType produce() {
        return ProductType.MILK;
    }
}